package org.pa.mathisfun.exam.exam_kelas4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.R
import org.pa.mathisfun.databinding.ActivityExamResultMinKelas3Binding
import org.pa.mathisfun.databinding.ActivityExamResultMinKelas4Binding
import org.pa.mathisfun.exam.exam_kelas1.ExamKelas1
import org.pa.mathisfun.menu.MainActivity

class ExamResultMinKelas4 : AppCompatActivity() {
    private lateinit var binding: ActivityExamResultMinKelas4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamResultMinKelas4Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val score = intent.getIntExtra("RIGHT_ANSWER_COUNT", 0)
        binding.nilaiExam.text = getString(R.string.result_score, score)

        binding.btnUlang.setOnClickListener {
            startActivity(Intent(this, ExamKelas4::class.java))
        }
        binding.btnKembali.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}