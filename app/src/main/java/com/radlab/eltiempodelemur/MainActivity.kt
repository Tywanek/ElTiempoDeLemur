package com.radlab.eltiempodelemur

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.radlab.eltiempodelemur.adapters.GeoAdapter
import com.radlab.eltiempodelemur.network.ElTiempoAPI
import com.radlab.eltiempodelemur.network.models.geoModels.Geoname
import com.radlab.eltiempodelemur.network.response.GeoResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private var _weatherAPI: ElTiempoAPI? = null

    private val _weatherResponseCallback = object : Callback<GeoResponse> {
        override fun onResponse(response: Response<GeoResponse>?, retrofit: Retrofit) {
            if (response != null) {
                setGeoAdapter(response.body().geonames)
            } else {
                Log.d("Error message", response!!.raw().message())
                Log.d("Error code", response!!.raw().code().toString())
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
        callGeoEndPoint()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun initRetrofit() {
        val retrofit = Retrofit.Builder()
            .baseUrl(getString(R.string.BASE_URL))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        _weatherAPI = retrofit.create(ElTiempoAPI::class.java)

    }

    private fun callGeoEndPoint() {
        val usersCall = _weatherAPI?.weather
        usersCall?.enqueue(_weatherResponseCallback)
    }

    private fun setGeoAdapter(list: List<Geoname> ){
        geo_recycler_view.layoutManager = LinearLayoutManager(this)
        val geoAdapter = GeoAdapter(list, this)
        geo_recycler_view.adapter = geoAdapter

        geoAdapter.onItemClick = { geoname ->
            Log.d("TAG", geoname.name)
            Toast.makeText(this, geoname.name, Toast.LENGTH_SHORT).show()
            startActivity(DetailActivity.newIntent(this))
        }
    }

}
