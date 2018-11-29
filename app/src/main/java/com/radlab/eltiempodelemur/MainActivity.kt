package com.radlab.eltiempodelemur

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import com.radlab.eltiempodelemur.adapters.GeoAdapter
import com.radlab.eltiempodelemur.adapters.SearchItemsAdapter
import com.radlab.eltiempodelemur.network.ElTiempoAPI
import com.radlab.eltiempodelemur.network.models.geoModels.Geoname
import com.radlab.eltiempodelemur.network.response.GeoResponse
import com.radlab.eltiempodelemur.network.response.WeatherResponse
import com.radlab.eltiempodelemur.realm.SearchItem
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit
import java.io.IOException
import java.util.*

class MainActivity : AppCompatActivity() {

    val data = SearchItem()
    private var _weatherAPI: ElTiempoAPI? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initRetrofit()
        setSearchAdapter(getStoredData().reversed())
        setSearchBox()
    }

    override fun onResume() {
        super.onResume()
        setSearchAdapter(getStoredData().reversed())
    }


    private fun getStoredData(): List<SearchItem> {
        Realm.init(this)
        val config = RealmConfiguration.Builder().name(getString(R.string.realm_bd_name)).build()
        val realm = Realm.getInstance(config)
        return realm.where(SearchItem::class.java).findAll()
    }

    private fun saveItem(searchItem: SearchItem) {
        Realm.init(this)
        val config = RealmConfiguration.Builder().name(getString(R.string.realm_bd_name)).build()
        val realm = Realm.getInstance(config)
        realm.beginTransaction()
        val item = realm.createObject(SearchItem::class.java, Calendar.getInstance().timeInMillis)
        item.name = searchItem.name
        item.temperature = searchItem.temperature
        item.lat = searchItem.lat
        item.lng = searchItem.lng
        realm.commitTransaction()
    }

    private fun setSearchBox() {
        search_box.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                callGeoEndPoint(search_box.text.toString())
                (applicationContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).hideSoftInputFromWindow(
                    v.windowToken,
                    0
                )
            }
            false
        }
    }

    private fun initRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl(getString(R.string.BASE_URL))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        _weatherAPI = retrofit.create(ElTiempoAPI::class.java)
    }

    private fun callGeoEndPoint(cityName: String) {
        val geoSearchCall = _weatherAPI?.getGeoResponse(
            cityName,
            20,
            0,
            "EN",
            true,
            "FULL",
            getString(R.string.USER_NAME)
        )
        geoSearchCall?.enqueue(_geoSearchResponseCallback)
    }

    private fun callWeatherEndpoint(geoname: Geoname) {
        if (geoname.bbox != null) {
            val weatherCall = _weatherAPI?.getWeatherResponse(
                geoname.bbox.north,
                geoname.bbox.south,
                geoname.bbox.east,
                geoname.bbox.west,
                getString(R.string.USER_NAME)
            )
            weatherCall?.enqueue(_weatherResponseCallback)
        } else {
            Toast.makeText(this@MainActivity, getString(R.string.error_empty), Toast.LENGTH_SHORT).show()
        }

    }

    private fun setGeoAdapter(list: List<Geoname>) {
        recycler_view.layoutManager = LinearLayoutManager(this)
        val geoAdapter = GeoAdapter(list, this)
        recycler_view.adapter = geoAdapter

        geoAdapter.onItemClick = { geoname ->
            data.name = geoname.name
            data.lat = geoname.lat.toDouble()
            data.lng = geoname.lng.toDouble()
            callWeatherEndpoint(geoname)
        }
    }

    private fun setSearchAdapter(list: List<SearchItem>) {
        recycler_view.layoutManager = LinearLayoutManager(this)
        val searchAdapter = SearchItemsAdapter(list, this)

        recycler_view.adapter = searchAdapter
        searchAdapter.onItemClick = {
            data.name = it.name
            data.temperature = it.temperature
            data.lat = it.lat
            data.lng = it.lng
            startActivity(DetailActivity.newIntent(this@MainActivity, data))
        }
    }

    private val _geoSearchResponseCallback = object : Callback<GeoResponse> {
        override fun onResponse(response: Response<GeoResponse>?, retrofit: Retrofit) {
            if (response != null) setGeoAdapter(response.body().geonames)
        }

        override fun onFailure(t: Throwable) {
            if (t is IOException) {
                Log.d(getString(R.string.error_TAG), getString(R.string.error_network_connection))
            } else {
                Log.d(getString(R.string.error_TAG), getString(R.string.error_unknown))
            }
        }
    }

    private val _weatherResponseCallback = object : Callback<WeatherResponse> {
        override fun onResponse(response: Response<WeatherResponse>?, retrofit: Retrofit) {
            if (response != null) {
                if (response.body().weatherObservations.size > 0) {
                    data.temperature = response.body().weatherObservations[0].temperature.toInt()
                    saveItem(data)
                    startActivity(DetailActivity.newIntent(this@MainActivity, data))
                } else {
                    Toast.makeText(this@MainActivity, getString(R.string.error_empty), Toast.LENGTH_SHORT).show()
                }
            }
        }

        override fun onFailure(t: Throwable) {
            if (t is IOException) {
                Log.d(getString(R.string.error_TAG), getString(R.string.error_network_connection))
            } else {
                Log.d(getString(R.string.error_TAG), getString(R.string.error_unknown))
            }
        }
    }

}
