package com.radlab.eltiempodelemur

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.radlab.eltiempodelemur.realm.SearchItem
import kotlinx.android.synthetic.main.activity_detils.*
import kotlinx.android.synthetic.main.activity_main.*


class DetailActivity : AppCompatActivity(), OnMapReadyCallback {


    companion object {
        private const val EXTRA_KEY = "detail_activity_extra_key"
        private lateinit var mMap: GoogleMap
        fun newIntent(context: Context, searchItem: SearchItem): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_KEY, searchItem)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val searchItem = intent.extras.get(EXTRA_KEY) as SearchItem
        val temperature: Int? = searchItem.temperature

        details_name.text = searchItem.name
        progressBar.progress = temperature!!
        details_temperature.text = resources.getString(R.string.details_tempertre, temperature)

    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val searchItem = intent.extras.get(EXTRA_KEY) as SearchItem
        val location = LatLng(searchItem.lat!!, searchItem.lng!!)
        mMap.addMarker(MarkerOptions().position(location).title("Hola!"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location))
    }

}
