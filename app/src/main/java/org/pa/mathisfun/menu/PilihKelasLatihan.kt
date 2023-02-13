package org.pa.mathisfun.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.databinding.ActivityPilihKelasLatihanBinding
import org.pa.mathisfun.latihan_soal.latihan_soal_kelas2.LatihanKelas2Nomor1
import org.pa.mathisfun.latihan_soal.latihan_soal_kelas3.LatihanKelas3Nomor1
import org.pa.mathisfun.latihan_soal.latihan_soal_kelas4.LatihanKelas4Nomor1
import org.pa.mathisfun.latihan_soal.latihan_soal_kelas5.LatihanKelas5Nomor1
import org.pa.mathisfun.latihan_soal.latihan_soal_kelas6.LatihanKelas6Nomor1
import org.pa.mathisfun.latihan_soal.latihan_soal_kelas1.LatihanKelas1

class PilihKelasLatihan : AppCompatActivity() {

    private  lateinit var binding: ActivityPilihKelasLatihanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPilihKelasLatihanBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title="Pilih Kelas"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        binding.btnPilihKelas1.setOnClickListener{
            startActivity(Intent(this, LatihanKelas1::class.java ))
        }
        binding.btnPilihKelas2.setOnClickListener{
            startActivity(Intent(this, LatihanKelas2Nomor1::class.java ))
        }
        binding.btnPilihKelas3.setOnClickListener{
            startActivity(Intent(this, LatihanKelas3Nomor1::class.java ))
        }
        binding.btnPilihKelas4.setOnClickListener{
            startActivity(Intent(this, LatihanKelas4Nomor1::class.java ))
        }
        binding.btnPilihKelas5.setOnClickListener{
            startActivity(Intent(this, LatihanKelas5Nomor1::class.java ))
        }
        binding.btnPilihKelas6.setOnClickListener{
            startActivity(Intent(this, LatihanKelas6Nomor1::class.java ))
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}