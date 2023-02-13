package org.pa.mathisfun.latihan_soal.latihan_soal_kelas4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.pa.mathisfun.databinding.ActivityLatihanKelas4Nomor5Binding
import org.pa.mathisfun.latihan_soal.HasilLatihan
import org.pa.mathisfun.latihan_soal.latihan_soal_kelas4.solusi_kelas4.SolusiKelas4Nomor5

class LatihanKelas4Nomor5 : AppCompatActivity() {

    private lateinit var binding: ActivityLatihanKelas4Nomor5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLatihanKelas4Nomor5Binding.inflate(layoutInflater)
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
            startActivity(Intent(this, HasilLatihan::class.java  ))
        }
        binding.pilihanD.setOnClickListener {
            Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show()
        }
        binding.solusi1.setOnClickListener {
            startActivity(Intent(this, SolusiKelas4Nomor5::class.java))
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}