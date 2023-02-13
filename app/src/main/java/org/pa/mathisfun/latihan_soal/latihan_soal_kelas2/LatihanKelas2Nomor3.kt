package org.pa.mathisfun.latihan_soal.latihan_soal_kelas2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.pa.mathisfun.databinding.ActivityLatihanKelas2Nomor3Binding
import org.pa.mathisfun.latihan_soal.latihan_soal_kelas2.solusi_kelas2.SolusiKelas2Nomor3

class LatihanKelas2Nomor3 : AppCompatActivity() {

    private lateinit var binding: ActivityLatihanKelas2Nomor3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLatihanKelas2Nomor3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title="Latihan Soal"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        binding.pilihanA.setOnClickListener {
            Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show()
        }
        binding.pilihanB.setOnClickListener {
            Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show()
        }
        binding.pilihanC.setOnClickListener {
            Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show()
        }
        binding.pilihanD.setOnClickListener {
            Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LatihanKelas2Nomor4::class.java  ))
        }
        binding.solusi1.setOnClickListener {
            startActivity(Intent(this, SolusiKelas2Nomor3::class.java))
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}