package org.pa.mathisfun.exam.exam_kelas6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.R
import org.pa.mathisfun.databinding.ActivityExamResultMinKelas5Binding
import org.pa.mathisfun.databinding.ActivityExamResultMinKelas6Binding
import org.pa.mathisfun.exam.exam_kelas1.ExamKelas1
import org.pa.mathisfun.exam.exam_kelas5.ExamKelas5
import org.pa.mathisfun.menu.MainActivity

class ExamResultMinKelas6 : AppCompatActivity() {
    private lateinit var binding: ActivityExamResultMinKelas6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamResultMinKelas6Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val score = intent.getIntExtra("RIGHT_ANSWER_COUNT", 0)
        binding.nilaiExam.text = getString(R.string.result_score, score)

        binding.btnUlang.setOnClickListener {
            startActivity(Intent(this, ExamKelas5::class.java))
        }
        binding.btnKembali.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}