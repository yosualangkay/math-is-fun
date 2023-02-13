package org.pa.mathisfun.menu

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import org.pa.mathisfun.daftar_tips.Tips1
import org.pa.mathisfun.daftar_tips.Tips2
import org.pa.mathisfun.daftar_tips.Tips3
import org.pa.mathisfun.daftar_tips.Tips4
import org.pa.mathisfun.daftar_tips.Tips5
import org.pa.mathisfun.daftar_tips.Tips6

import org.pa.mathisfun.databinding.ActivityHalamanTipsBinding

class HalamanTips : AppCompatActivity() {

    private lateinit var binding: ActivityHalamanTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalamanTipsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title="Tips"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        var b = AlertDialog.Builder(this)
        b.setTitle("INFO")
        b.setMessage("Fitur ini berisi tips-tips yang dapat membantu kamu dalam belajar matematika")
        b.setNegativeButton("OK", { dialog: DialogInterface?, which: Int -> })
        b.show()

        binding.btnTips1.setOnClickListener{
            startActivity(Intent(this, Tips1::class.java ))
        }

        binding.btnTips2.setOnClickListener{
            startActivity(Intent(this, Tips2::class.java ))
        }
        binding.btnTips3.setOnClickListener{
            startActivity(Intent(this, Tips3::class.java ))
        }
        binding.btnTips4.setOnClickListener{
            startActivity(Intent(this, Tips4::class.java ))
        }
        binding.btnTips5.setOnClickListener{
            startActivity(Intent(this, Tips5::class.java ))
        }
//        binding.btnTips6.setOnClickListener{
//            startActivity(Intent(this, Tips6::class.java ))
//        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}