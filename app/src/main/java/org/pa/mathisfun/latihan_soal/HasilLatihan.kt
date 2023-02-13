package org.pa.mathisfun.latihan_soal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.menu.MainActivity
import org.pa.mathisfun.databinding.ActivityHasilLatihanBinding

class HasilLatihan : AppCompatActivity() {

    private lateinit var binding: ActivityHasilLatihanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHasilLatihanBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnBack.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
    }
}