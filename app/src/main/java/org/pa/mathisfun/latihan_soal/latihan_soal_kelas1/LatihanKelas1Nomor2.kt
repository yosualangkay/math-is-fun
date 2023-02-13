package org.pa.mathisfun.latihan_soal.latihan_soal_kelas1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.pa.mathisfun.databinding.ActivityLatihanKelas1Nomor2Binding
import org.pa.mathisfun.latihan_soal.latihan_soal_kelas1.solusi.SolusiKelas1Nomor2

class LatihanKelas1Nomor2 : AppCompatActivity() {

    private lateinit var binding: ActivityLatihanKelas1Nomor2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLatihanKelas1Nomor2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title="Latihan Soal"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        binding.pilihanA.setOnClickListener {
            startActivity(Intent(this, LatihanKelas1Nomor3::class.java  ))
            Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show()
        }
        binding.pilihanB.setOnClickListener {
            Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show()
        }
        binding.pilihanC.setOnClickListener {
            Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show()
        }
        binding.pilihanD.setOnClickListener {
            Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show()
        }
        binding.solusi2.setOnClickListener {
            startActivity(Intent(this, SolusiKelas1Nomor2::class.java))
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}