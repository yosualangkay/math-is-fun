package org.pa.mathisfun.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import org.pa.mathisfun.R
import org.pa.mathisfun.databinding.ActivityPilihKelasExamBinding
import org.pa.mathisfun.exam.FragmentKuisKelas1
import org.pa.mathisfun.exam.exam_kelas1.ExamKelas1
import org.pa.mathisfun.exam.exam_kelas2.ExamKelas2
import org.pa.mathisfun.exam.exam_kelas3.ExamKelas3
import org.pa.mathisfun.exam.exam_kelas4.ExamKelas4
import org.pa.mathisfun.exam.exam_kelas5.ExamKelas5
import org.pa.mathisfun.exam.exam_kelas6.ExamKelas6

class PilihKelasExam : AppCompatActivity() {

    private lateinit var binding: ActivityPilihKelasExamBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPilihKelasExamBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title="Pilih Kelas"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        binding.kelas1.setOnClickListener{
            startActivity(Intent(this, ExamKelas1::class.java ))
        }
        binding.kelas2.setOnClickListener{
            startActivity(Intent(this, ExamKelas2::class.java ))
        }
        binding.kelas3.setOnClickListener{
            startActivity(Intent(this, ExamKelas3::class.java ))
        }
        binding.kelas4.setOnClickListener{
            startActivity(Intent(this, ExamKelas4::class.java ))
        }
        binding.kelas5.setOnClickListener{
            startActivity(Intent(this, ExamKelas5::class.java ))
        }
        binding.kelas6.setOnClickListener{
            startActivity(Intent(this, ExamKelas6::class.java ))
        }



    }

//    private fun replaceFragment(fragment: Fragment) {
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.fragmentCotainer,fragment)
//        fragmentTransaction.commit()
//    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}