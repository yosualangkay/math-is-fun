package org.pa.mathisfun.exam.exam_kelas1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.R
import org.pa.mathisfun.databinding.ActivityExamResultBinding
import org.pa.mathisfun.databinding.ActivityExamResultMinKelas1Binding
import org.pa.mathisfun.menu.MainActivity

class ExamResultMinKelas1 : AppCompatActivity() {

    private lateinit var binding: ActivityExamResultMinKelas1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamResultMinKelas1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val score = intent.getIntExtra("RIGHT_ANSWER_COUNT", 0)
        binding.nilaiExam.text = getString(R.string.result_score, score)

        binding.btnUlang.setOnClickListener {
            startActivity(Intent(this, ExamKelas1::class.java))
        }
        binding.btnKembali.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}