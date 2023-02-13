package org.pa.mathisfun.menu

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import org.pa.mathisfun.databinding.ActivityHalamanQuizBinding

class HalamanQuiz : AppCompatActivity() {

    private lateinit var binding: ActivityHalamanQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalamanQuizBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title="Latihan"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        var b = AlertDialog.Builder(this)
        b.setTitle("INFO")
        b.setMessage("Latihan dapat kamu lakukan dengan beberapa pilihan sesuai dengan yang kamu inginkan")
        b.setNegativeButton("OK", { dialog: DialogInterface?, which: Int -> })
        b.show()

//        binding.btnLatihanSoal.setOnClickListener{
//            startActivity(Intent(
//                this, PilihKelasLatihan::class.java
//            ))
//
//        }

        binding.btnExam.setOnClickListener{
            startActivity(Intent(
                this, PilihKelasExam::class.java
            ))
        }

        binding.btnBelajarHitung.setOnClickListener{
            startActivity(Intent(this, BelajarHitung::class.java))
        }

        binding.btnPenjumlahan.setOnClickListener{
            startActivity(Intent(this, BelajarPerkalian::class.java))
        }

        binding.btnRumus.setOnClickListener{
            startActivity(Intent(this, RumusLuas::class.java))
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}