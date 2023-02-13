package org.pa.mathisfun.daftar_tips

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.databinding.ActivityTips3Binding

class Tips3 : AppCompatActivity() {

    private lateinit var binding: ActivityTips3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTips3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title="Tips"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}