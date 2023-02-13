package org.pa.mathisfun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.pa.mathisfun.databinding.ActivityRegisterBinding
import org.pa.mathisfun.menu.MainActivity

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()

        binding.btnDaftar.setOnClickListener{
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

            register(username, password)
        }
        binding.btnLogin.setOnClickListener{
            startActivity(Intent(this, Login::class.java))
        }
    }

    private fun register(
        username: String,
        password: String,

    ) {
        auth.createUserWithEmailAndPassword(username,password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Intent(this, NamaUser::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        Toast.makeText(this, "Berhasil Registrasi", Toast.LENGTH_SHORT).show()
                        startActivity(it)
                    }
                }
                else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }
    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null) {
            Intent(this, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                Toast.makeText(this, "Berhasil Registrasi", Toast.LENGTH_SHORT).show()
                startActivity(it)
            }
        }
    }
}