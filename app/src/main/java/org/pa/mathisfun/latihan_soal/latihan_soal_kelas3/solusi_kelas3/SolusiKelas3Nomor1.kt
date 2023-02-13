package org.pa.mathisfun.latihan_soal.latihan_soal_kelas3.solusi_kelas3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.databinding.ActivitySolusiKelas3Nomor1Binding

class SolusiKelas3Nomor1 : AppCompatActivity() {

    private lateinit var binding: ActivitySolusiKelas3Nomor1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySolusiKelas3Nomor1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title="Penyelesaian"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}