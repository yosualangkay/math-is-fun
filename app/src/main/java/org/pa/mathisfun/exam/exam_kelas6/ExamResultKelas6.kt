package org.pa.mathisfun.exam.exam_kelas6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.menu.MainActivity
import org.pa.mathisfun.R
import org.pa.mathisfun.databinding.ActivityExamResultKelas6Binding

class ExamResultKelas6 : AppCompatActivity() {

    private lateinit var binding: ActivityExamResultKelas6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamResultKelas6Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val score = intent.getIntExtra("RIGHT_ANSWER_COUNT", 0)
        binding.nilaiExam.text = getString(R.string.result_score, score)

        binding.btnUlang.setOnClickListener {
            startActivity(Intent(this, ExamKelas6::class.java))
        }
        binding.btnKembali.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}