package com.radlab.eltiempodelemur

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import com.radlab.eltiempodelemur.realm.SearchItem
import kotlinx.android.synthetic.main.activity_detils.*
import kotlinx.android.synthetic.main.activity_main.*


class DetailActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_KEY = "detail_activity_extra_key"
        private var progressStatus = 0
        private val handler = Handler()

        fun newIntent(context: Context, searchItem: SearchItem): Intent {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRA_KEY, searchItem)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detils)
        setSupportActionBar(toolbar)

        val searchItem = intent.extras.get(EXTRA_KEY) as SearchItem
        val temperature: Int? = searchItem.temperature

        details_name.text = searchItem.name
        details_temperature.text = resources.getString(R.string.details_tempertre, temperature)
        if (temperature != null) {
            fakeAnimation(temperature)
        }


    }

    private fun fakeAnimation(temperature: Int) {
        Thread(Runnable {
            while (progressStatus < temperature) {
                progressStatus += 1
                handler.post { progressBar.progress = progressStatus }
                try {
                    Thread.sleep(50)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }).start()
    }
}
