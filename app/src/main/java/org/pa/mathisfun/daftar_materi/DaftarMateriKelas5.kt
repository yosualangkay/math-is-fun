package org.pa.mathisfun.daftar_materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.databinding.ActivityDaftarMateriKelas5Binding
import org.pa.mathisfun.materi5.*

class DaftarMateriKelas5 : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarMateriKelas5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarMateriKelas5Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title="Kelas 5"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        binding.btnOperasiHitungPecahan.setOnClickListener {
            startActivity(Intent(this, OperasiHitungPecahan::class.java ))
        }
        binding.btnKecepatanDebit.setOnClickListener {
            startActivity(Intent(this, KecepatanDebit::class.java ))
        }
        binding.btnSkala.setOnClickListener {
            startActivity(Intent(this, Skala::class.java ))
        }
        binding.btnBangunRuang.setOnClickListener {
            startActivity(Intent(this, BangunRuang::class.java ))
        }
        binding.btnPengumpulanPenyajianData.setOnClickListener {
            startActivity(Intent(this, PengumpulanPenyajianData::class.java ))
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}