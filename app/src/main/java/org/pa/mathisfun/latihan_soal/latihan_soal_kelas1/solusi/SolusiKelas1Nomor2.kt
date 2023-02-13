package org.pa.mathisfun.latihan_soal.latihan_soal_kelas1.solusi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.databinding.ActivitySolusiKelas1Nomor2Binding

class SolusiKelas1Nomor2 : AppCompatActivity() {

    private lateinit var binding: ActivitySolusiKelas1Nomor2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySolusiKelas1Nomor2Binding.inflate(layoutInflater)
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