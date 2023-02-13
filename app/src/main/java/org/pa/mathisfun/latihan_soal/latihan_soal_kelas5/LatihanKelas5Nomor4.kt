package org.pa.mathisfun.latihan_soal.latihan_soal_kelas5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.pa.mathisfun.databinding.ActivityLatihanKelas5Nomor4Binding
import org.pa.mathisfun.latihan_soal.latihan_soal_kelas5.solusi_kelas5.SolusiKelas5Nomor4

class LatihanKelas5Nomor4 : AppCompatActivity() {

    private lateinit var binding: ActivityLatihanKelas5Nomor4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLatihanKelas5Nomor4Binding.inflate(layoutInflater)
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
            Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LatihanKelas5Nomor5::class.java))
        }
        binding.pilihanD.setOnClickListener {
            Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show()
        }
        binding.solusi1.setOnClickListener {
            startActivity(Intent(this, SolusiKelas5Nomor4::class.java))
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}