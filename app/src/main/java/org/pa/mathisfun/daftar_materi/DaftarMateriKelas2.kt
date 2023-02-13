package org.pa.mathisfun.daftar_materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.databinding.ActivityDaftarMateriKelas2Binding
import org.pa.mathisfun.materi2.*

class DaftarMateriKelas2 : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarMateriKelas2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarMateriKelas2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnUrutanBilangan.setOnClickListener {
            startActivity(Intent(this, UrutanBilangan::class.java ))
        }
        binding.btnPengukuran.setOnClickListener {
            startActivity(Intent(this, Pengukuran::class.java ))
        }
        binding.btnOperasiPenjumlahanPengurangan.setOnClickListener {
            startActivity(Intent(this, OperasiPenjumlahanPengurangan::class.java ))
        }
        binding.btnPerkalianPembagian.setOnClickListener {
            startActivity(Intent(this, OperasiPerkalianPembagian::class.java ))
        }
        binding.btnBangunDatar.setOnClickListener {
            startActivity(Intent(this, BangunDatarKelas2::class.java ))
        }
    }
}