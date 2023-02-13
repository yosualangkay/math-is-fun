package org.pa.mathisfun.daftar_materi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.pa.mathisfun.databinding.ActivityDaftarMateriKelas1Binding
import org.pa.mathisfun.materi1.*

class DaftarMateriKelas1 : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarMateriKelas1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarMateriKelas1Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.cacah.setOnClickListener {
            startActivity(Intent(this, BilanganCacah::class.java ))
        }

    }
}