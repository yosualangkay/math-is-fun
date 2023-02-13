package org.pa.mathisfun.exam.exam_kelas2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.menu.MainActivity
import org.pa.mathisfun.R
import org.pa.mathisfun.databinding.ActivityExamResultKelas2Binding

class ExamResultKelas2 : AppCompatActivity() {

    private lateinit var binding: ActivityExamResultKelas2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamResultKelas2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val score = intent.getIntExtra("RIGHT_ANSWER_COUNT", 0)
        binding.nilaiExam.text = getString(R.string.result_score, score)

        binding.btnUlang.setOnClickListener {
            startActivity(Intent(this, ExamKelas2::class.java))
        }
        binding.btnKembali.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}