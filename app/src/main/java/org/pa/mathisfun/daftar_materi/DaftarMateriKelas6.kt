package org.pa.mathisfun.daftar_materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.databinding.ActivityDaftarMateriKelas6Binding
import org.pa.mathisfun.materi6.*

class DaftarMateriKelas6 : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarMateriKelas6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarMateriKelas6Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title="Kelas 6"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        binding.btnBilanganBulat.setOnClickListener {
            startActivity(Intent(this, BilanganBulat::class.java ))
        }
        binding.btnLingkaran.setOnClickListener {
            startActivity(Intent(this, Lingkaran::class.java ))
        }
        binding.btnBangunRuangKelas6.setOnClickListener {
            startActivity(Intent(this, BangunRuangKelas6::class.java ))
        }
        binding.btnStatistikaKelas6.setOnClickListener {
            startActivity(Intent(this, StatistikaKelas6::class.java ))
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}