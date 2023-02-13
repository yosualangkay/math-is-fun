package org.pa.mathisfun.daftar_materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.databinding.ActivityDaftarMateriKelas3Binding
import org.pa.mathisfun.materi3.*

class DaftarMateriKelas3 : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarMateriKelas3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarMateriKelas3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnBangunDatar.setOnClickListener {
            startActivity(Intent(this, BangunDatarK3::class.java ))
        }
        binding.btnKelilingLuas.setOnClickListener {
            startActivity(Intent(this, KelilingBangunDatar::class.java ))
        }
        binding.btnPecahanSederhana.setOnClickListener {
            startActivity(Intent(this, PecahanSederhana::class.java ))
        }
        binding.btnOperasiHitungBilangan.setOnClickListener {
            startActivity(Intent(this, OperasiHitungBilangan::class.java ))
        }
        binding.btnPengukuran.setOnClickListener {
            startActivity(Intent(this, PengukuranKelas3::class.java ))
        }
    }
}