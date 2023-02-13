package org.pa.mathisfun.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.R

class InfoApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_app)

        val actionbar = supportActionBar
        actionbar!!.title="About Apps"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}