package org.pa.mathisfun.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.pa.mathisfun.Login
import org.pa.mathisfun.databinding.ActivityUbahPasswordBinding

class UbahPassword : AppCompatActivity() {

    private lateinit var binding: ActivityUbahPasswordBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUbahPasswordBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnReset.setOnClickListener {
            val email = binding.etUsername.text.toString().trim()

            if(email.isEmpty()){
                binding.etUsername.error = "Email tidak boleh kosong"
                binding.etUsername.requestFocus()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(this, "Cek Email Untuk Reset Password" ,Toast.LENGTH_SHORT).show()
                    Intent(this, Login::class.java).also {
                        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(it)
                    }

                }else{
                    Toast.makeText(this, "${it.exception?.message}" ,Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.btnBatal.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
    }
}