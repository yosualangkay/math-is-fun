package org.pa.mathisfun.latihan_soal.latihan_soal_kelas3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.pa.mathisfun.databinding.ActivityLatihanKelas3Nomor2Binding
import org.pa.mathisfun.latihan_soal.latihan_soal_kelas3.solusi_kelas3.SolusiKelas3Nomor2

class LatihanKelas3Nomor2 : AppCompatActivity() {

    private lateinit var binding: ActivityLatihanKelas3Nomor2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLatihanKelas3Nomor2Binding.inflate(layoutInflater)
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
            Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LatihanKelas3Nomor3::class.java  ))
        }
        binding.pilihanC.setOnClickListener {
            Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show()
        }
        binding.pilihanD.setOnClickListener {
            Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show()
        }
        binding.solusi1.setOnClickListener {
            startActivity(Intent(this, SolusiKelas3Nomor2::class.java))
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}