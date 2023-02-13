package org.pa.mathisfun.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.pa.mathisfun.Login
import org.pa.mathisfun.ProgresBelajar
import org.pa.mathisfun.R
import org.pa.mathisfun.databinding.ActivityMainBinding
import org.pa.mathisfun.menu.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var backPresseTime = 0L

    private lateinit var auth: FirebaseAuth
    private lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()

        ref = FirebaseDatabase.getInstance().getReference("users")

        val user: FirebaseUser? = auth.currentUser


        if (user != null){
            binding.tvNama.setText(user.displayName)
        }

        binding.imagekelas.setOnClickListener {
            startActivity(Intent(this, HalamanPilihKelas::class.java))
        }
        binding.imagesemuamateri.setOnClickListener {
            startActivity(Intent(this, ProgresBelajar::class.java))
        }
        binding.imageQuiz.setOnClickListener {
            startActivity(Intent(this, PilihKelasExam::class.java))
        }
        binding.imageTips.setOnClickListener {
            startActivity(Intent(this, HalamanTips::class.java))
        }
        binding.profile.setOnClickListener{
            startActivity(Intent(this, Profile::class.java))
        }
        binding.about.setOnClickListener{
            startActivity(Intent(this, InfoApp::class.java ))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.utama_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
//            R.id.nav_about -> startActivity(Intent(this, InfoApp::class.java))
            R.id.nav_tambah_saran -> startActivity(Intent(this, HalamanSaran::class.java))
            R.id.nav_Keluar -> logout()
//            R.id.nav_profile -> startActivity(Intent(this, Profile::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun logout() {
        auth.signOut()
        Intent(this@MainActivity, Login::class.java).also { intent ->
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }


    override fun onBackPressed() {
        if(backPresseTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed()
        }else{
            Toast.makeText(applicationContext, "Tekan kembali untuk keluar", Toast.LENGTH_SHORT).show()
        }
        backPresseTime = System.currentTimeMillis()
    }
}