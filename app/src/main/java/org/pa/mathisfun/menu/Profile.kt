package org.pa.mathisfun.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.pa.mathisfun.ProgresBelajar
import org.pa.mathisfun.databinding.ActivityProfileBinding

class Profile : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var auth: FirebaseAuth
    var skorKelas1 = ""
    var skorKelas2 = ""
    var skorKelas3 = ""
    var skorKelas4 = ""
    var skorKelas5 = ""
    var skorKelas6 = ""


    var statusBilanganCacah = ""
    var statusPengukuranBerat = ""
    var statusBangunDatar = ""
    var statusBangunRuang = ""
    var statusSatuanPengukuran = ""
    var statusPenjumlahanPengurangan = ""

    var statusUrutanBilangan= ""
    var statusOperasiPenjumlahanPengurangan= ""
    var statusPengukuran= ""
    var statusOperasiPerkalianPembagian= ""
    var statusBangunDatarKelas2= ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()
        val userid = auth.currentUser?.uid
        val user: FirebaseUser? = auth.currentUser

        val dref = FirebaseDatabase.getInstance().reference
        dref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                statusBangunDatarKelas2 = snapshot.child("users/${userid}/statusBangunDatarKelas2").value!!.toString()
                statusUrutanBilangan = snapshot.child("users/${userid}/statusUrutanBilangan").value!!.toString()
                statusOperasiPerkalianPembagian = snapshot.child("users/${userid}/statusOperasiPerkalianPembagian").value!!.toString()
                statusPengukuran = snapshot.child("users/${userid}/statusPengukuran").value!!.toString()
                statusOperasiPenjumlahanPengurangan = snapshot.child("users/${userid}/statusOperasiPenjumlahanPengurangan").value!!.toString()

                statusBilanganCacah = snapshot.child("users/${userid}/statusBilanganCacah").value!!.toString()
                statusSatuanPengukuran = snapshot.child("users/${userid}/statusSatuanPengukuran").value!!.toString()
                statusBangunRuang = snapshot.child("users/${userid}/statusBangunRuang").value!!.toString()
                statusPenjumlahanPengurangan = snapshot.child("users/${userid}/statusPenjumlahanPengurangan").value!!.toString()
                statusPengukuranBerat = snapshot.child("users/${userid}/statusPengukuranBerat").value!!.toString()
                statusBangunDatarKelas2 = snapshot.child("users/${userid}/statusBangunDatarKelas2").value!!.toString()

                skorKelas1 = snapshot.child("users/${userid}/skorKelas1").value!!.toString()
                skorKelas2 = snapshot.child("users/${userid}/skorKelas2").value!!.toString()
                skorKelas3 = snapshot.child("users/${userid}/skorKelas3").value!!.toString()
                skorKelas4 = snapshot.child("users/${userid}/skorKelas4").value!!.toString()
                skorKelas5 = snapshot.child("users/${userid}/skorKelas5").value!!.toString()
                skorKelas6 = snapshot.child("users/${userid}/skorKelas6").value!!.toString()


                binding.skorKelas1.setText(skorKelas1)
                binding.skorKelas2.setText(skorKelas2)
                binding.skorKelas3.setText(skorKelas3)
                binding.skorKelas4.setText(skorKelas4)
                binding.skorKelas5.setText(skorKelas5)
                binding.skorKelas6.setText(skorKelas6)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })



        if (user != null){
            binding.etUsername.setText(user.email)
            binding.etUser.setText(user.displayName)
        }

        binding.btnUpdate.setOnClickListener{
            val username: String = binding.etUser.text.toString().trim()
            binding.btnUpdate.visibility = View.INVISIBLE
            binding.btnGanti.visibility = View.VISIBLE

            if (username.isEmpty()){
                binding.etUser.error = "username harus diisi"
                return@setOnClickListener
            }

            UserProfileChangeRequest.Builder()
                .setDisplayName(username)
                .build().also {
                    user?.updateProfile(it)?.addOnCompleteListener{
                        if (it.isSuccessful){
                            Intent(this, MainActivity::class.java).also {
                                it.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                Toast.makeText(this, "Berhasil Update", Toast.LENGTH_SHORT).show()
                                binding.etUser.isEnabled = false
                                startActivity(it)
                                }
                            }else{
                            Toast.makeText(this, "Gagal Update", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
        }

        binding.btnGanti.setOnClickListener{
            binding.etUser.isEnabled = true
            binding.btnUpdate.visibility = View.VISIBLE
            binding.btnGanti.visibility = View.INVISIBLE
        }

    }
}