package com.radlab.eltiempodelemur

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.radlab.eltiempodelemur.network.ElTiempoAPI
import com.radlab.eltiempodelemur.network.models.geoModels.Geoname
import com.radlab.eltiempodelemur.network.response.GeoResponse
import kotlinx.android.synthetic.main.activity_detils.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit
import java.io.IOException

class DetailActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detils)
        setSupportActionBar(toolbar)
        details_text.text = "Details"

    }
}
