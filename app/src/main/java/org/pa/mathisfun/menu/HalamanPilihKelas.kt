package org.pa.mathisfun.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.databinding.ActivityHalamanPilihKelasBinding
import org.pa.mathisfun.materi3.Materi12
import org.pa.mathisfun.materi5.BangunRuang
import org.pa.mathisfun.materi6.BangunRuangKelas6
import org.pa.mathisfun.materi4.AplikasiPecahan
import org.pa.mathisfun.materi1.Materi1
import org.pa.mathisfun.materi2.Materi7

class HalamanPilihKelas : AppCompatActivity() {

    private lateinit var binding: ActivityHalamanPilihKelasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalamanPilihKelasBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title="Math Is Fun"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        binding.kelas1.setOnClickListener{
            startActivity(Intent(this, Materi1::class.java))
        }
        binding.kelas2.setOnClickListener{
            startActivity(Intent(this, Materi7::class.java))
        }
        binding.kelas3.setOnClickListener{
            startActivity(Intent(this, Materi12::class.java))
        }
        binding.kelas4.setOnClickListener{
            startActivity(Intent(this, AplikasiPecahan::class.java))
        }
        binding.kelas5.setOnClickListener{
            startActivity(Intent(this, BangunRuang::class.java))
        }
        binding.kelas6.setOnClickListener{
            startActivity(Intent(this, BangunRuangKelas6::class.java))
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        startActivity(Intent(this, MainActivity::class.java))
        return true
    }
}