package org.pa.mathisfun.daftar_materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.databinding.ActivityDaftarMateriKelas4Binding
import org.pa.mathisfun.materi4.*

class DaftarMateriKelas4 : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarMateriKelas4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarMateriKelas4Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title="Kelas 4"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        binding.btnBentukPecahan .setOnClickListener {
            startActivity(Intent(this, BentukPecahan::class.java ))
        }
        binding.btnFaktorDanKelipatanBilangan .setOnClickListener {
            startActivity(Intent(this, FaktorKelipatanBilangan::class.java ))
        }
        binding.btnMenentukanKpkFpb.setOnClickListener {
            startActivity(Intent(this, FpbKpk::class.java ))
        }
        binding.btnPenerapanKpkFpb.setOnClickListener {
            startActivity(Intent(this, PenerapanKpkFpb::class.java ))
        }
        binding.btnMateriSegiBanyak.setOnClickListener {
            startActivity(Intent(this, SegiBanyak::class.java ))
        }
        binding.btnBilanganPecahan.setOnClickListener {
            startActivity(Intent(this, BilanganPecahan::class.java ))
        }
        binding.btnTaksiran.setOnClickListener {
            startActivity(Intent(this, Taksiran::class.java ))
        }
        binding.btnAplikasiPecahan.setOnClickListener {
            startActivity(Intent(this, AplikasiPecahan::class.java ))
        }
        binding.btnFaktorisasiPrima.setOnClickListener {
            startActivity(Intent(this, FaktorisasiPrima::class.java ))
        }
        binding.btnAproksimasi1.setOnClickListener {
            startActivity(Intent(this, Aproksimasi1::class.java ))
        }
        binding.btnAproksimasi2.setOnClickListener {
            startActivity(Intent(this, Aproksimasi2::class.java ))
        }
        binding.btnAproksimasi3.setOnClickListener {
            startActivity(Intent(this, Aproksimasi3::class.java ))
        }
        binding.btnKelilingBangunDatar.setOnClickListener {
            startActivity(Intent(this, KelilingBangunDatar::class.java ))
        }
        binding.btnLuasBangunDatar.setOnClickListener {
            startActivity(Intent(this, LuasBangunDatar::class.java ))
        }
        binding.btnStatistika1.setOnClickListener {
            startActivity(Intent(this, Statistika1::class.java ))
        }
        binding.btnStatistika2.setOnClickListener {
            startActivity(Intent(this, Statistika2::class.java ))
        }
        binding.btnPengukuranSudut1.setOnClickListener {
            startActivity(Intent(this, PengukuranSudut1::class.java ))
        }
        binding.btnPengukuranSudut2.setOnClickListener {
            startActivity(Intent(this, PengukuranSudut2::class.java ))
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}