package org.pa.mathisfun

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import org.pa.mathisfun.databinding.ActivityLoginBinding
import org.pa.mathisfun.menu.*

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()

        binding.btnLogin.setOnClickListener{
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if(username.isEmpty()){
                binding.etUsername.error = "Email tidak boleh kosong"
                return@setOnClickListener
            }
            if(password.isEmpty()){
                binding.etPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }
            binding.progressBar2.visibility = View.VISIBLE
            masuk(username, password)
        }

        binding.lupaPass.setOnClickListener {
            startActivity(Intent(this, UbahPassword::class.java))
        }

        binding.btnDaftar.setOnClickListener{
            startActivity(Intent(this, Register::class.java))
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.login_info, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.info_login -> info()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun info() {
        var b = AlertDialog.Builder(this)
        b.setTitle("INFO")
        b.setMessage("Untuk pengguna yang masih belum bisa menggunakan smartphone dapat meminta orang tua atau saudara untuk membantu dalam penggunaan aplikasi.")
        b.setNegativeButton("OK", { dialog: DialogInterface?, which: Int ->
        })
        b.show()
    }

    private fun masuk(username: String, password: String) {
        auth.signInWithEmailAndPassword(username,password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    binding.progressBar2.visibility = View.INVISIBLE
                    startActivity(Intent(this, MainActivity::class.java))
                }else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    binding.progressBar2.visibility = View.INVISIBLE
                }
            }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            Intent(this, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                binding.progressBar2.visibility = View.INVISIBLE
                Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
                startActivity(it)
            }
        }
    }
}