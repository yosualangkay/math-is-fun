package org.pa.mathisfun.latihan_soal.latihan_soal_kelas2.solusi_kelas2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.databinding.ActivitySolusiKelas2Nomor2Binding

class SolusiKelas2Nomor2 : AppCompatActivity() {

    private lateinit var binding: ActivitySolusiKelas2Nomor2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySolusiKelas2Nomor2Binding.inflate(layoutInflater)
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