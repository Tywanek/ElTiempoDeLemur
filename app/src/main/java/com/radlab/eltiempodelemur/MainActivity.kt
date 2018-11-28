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
import com.radlab.eltiempodelemur.network.ElTiempoAPI
import com.radlab.eltiempodelemur.network.models.geoModels.Geoname
import com.radlab.eltiempodelemur.network.response.GeoResponse
import com.radlab.eltiempodelemur.network.response.WeatherResponse
import com.radlab.eltiempodelemur.realm.SearchItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit
import java.io.IOException

class MainActivity : AppCompatActivity() {
    val data = SearchItem()

    private var _weatherAPI: ElTiempoAPI? = null

    private val _geoSearchResponseCallback = object : Callback<GeoResponse> {
        override fun onResponse(response: Response<GeoResponse>?, retrofit: Retrofit) {
            if (response != null) {
                setGeoAdapter(response.body().geonames)

            }
        }

        override fun onFailure(t: Throwable) {
            if (t is IOException) {
                Log.d("Error message", "network connection error")
            } else {
                Log.d("Error message", "unknown connection error")
            }
        }
    }

    private val _weatherResponseCallback = object : Callback<WeatherResponse> {
        override fun onResponse(response: Response<WeatherResponse>?, retrofit: Retrofit) {
            if (response != null) {
                Log.d("###", response.body().weatherObservations[0].temperature)
                data.temperature = response.body().weatherObservations[0].temperature.toInt()
                startActivity(DetailActivity.newIntent(this@MainActivity, data))
            }
        }

        override fun onFailure(t: Throwable) {
            if (t is IOException) {
                Log.d("Error message", "network connection error")
            } else {
                Log.d("Error message", "unknown connection error")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initRetrofit()

        search_box.setOnEditorActionListener() { v, actionId, event ->
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


    private fun callWeatherEndpoin(geoname: Geoname) {
        val weatherCall = _weatherAPI?.getWeatherResponse(
            geoname.bbox.north,
            geoname.bbox.south,
            geoname.bbox.east,
            geoname.bbox.west,
            getString(R.string.USER_NAME)
        )
        weatherCall?.enqueue(_weatherResponseCallback)
    }


    private fun setGeoAdapter(list: List<Geoname>) {
        geo_recycler_view.layoutManager = LinearLayoutManager(this)
        val geoAdapter = GeoAdapter(list, this)
        geo_recycler_view.adapter = geoAdapter

        geoAdapter.onItemClick = { geoname ->
            Toast.makeText(this, geoname.name, Toast.LENGTH_SHORT).show()
            data.name = geoname.name
            callWeatherEndpoin(geoname)
        }
    }

}
