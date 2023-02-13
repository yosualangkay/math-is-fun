package org.pa.mathisfun

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.database.FirebaseDatabase
import org.pa.mathisfun.databinding.ActivityNamaUserBinding
import org.pa.mathisfun.menu.MainActivity

class NamaUser : AppCompatActivity() {

    private lateinit var binding: ActivityNamaUserBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNamaUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()

        val user: FirebaseUser? = auth.currentUser


        if (user != null) {
            binding.etNama.setText(user.displayName)
        }

        binding.btnSelesai.setOnClickListener {
            val nama: String = binding.etNama.text.toString().trim()

            if (nama.isEmpty()) {
                binding.etNama.error = "Nama harus diisi"
                return@setOnClickListener
            }

            UserProfileChangeRequest.Builder()
                .setDisplayName(nama)
                .build().also {
                    user?.updateProfile(it)?.addOnCompleteListener {
                        if (it.isSuccessful) {
                            Intent(this, MainActivity::class.java).also {
                                it.flags =
                                    Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                val statusBilanganCacah = "belum"
                                val statusSatuanPengukuran = "belum"
                                val statusBangunRuang = "belum"
                                val statusPenjumlahanPengurangan = "belum"
                                val statusPengukuranBerat = "belum"
                                val statusBangunDatar = "belum"

                                val statusUrutanBilangan= "belum"
                                val statusOperasiPenjumlahanPengurangan= "belum"
                                val statusPengukuran= "belum"
                                val statusOperasiPerkalianPembagian= "belum"
                                val statusBangunDatarKelas2= "belum"

                                val aplikasiPecahan= "belum"
                                val aproksimasi1= "belum"
                                val aproksimasi2= "belum"
                                val aproksimasi3= "belum"
                                val bentukPecahan= "belum"
                                val bilanganPecahan= "belum"
                                val faktorPrima= "belum"
                                val faktorKelipatanBilangan= "belum"
                                val kpkfpb= "belum"
                                val kelilingBangunDatar= "belum"
                                val luasBangunDatar= "belum"
                                val penerapanKpkFpb= "belum"
                                val sudut1= "belum"
                                val sudut2= "belum"
                                val segiBanyak= "belum"
                                val statistika1= "belum"
                                val statistika2= "belum"
                                val taksiran= "belum"

                                val bangunRuangKelas5= "belum"
                                val kecepatanDebit= "belum"
                                val operasiHitungPecahan= "belum"
                                val pengumpulanPenyajianData= "belum"
                                val skala= "belum"

                                val bangunRuangKelas6= "belum"
                                val bilanganBulat= "belum"
                                val lingkaran= "belum"
                                val statistikaKelas6= "belum"

                                val skorKelas1 = "Belum ada nilai"
                                val skorKelas2 = "Belum ada nilai"
                                val skorKelas3 = "Belum ada nilai"
                                val skorKelas4 = "Belum ada nilai"
                                val skorKelas5 = "Belum ada nilai"
                                val skorKelas6 = "Belum ada nilai"

                                val statusOperasiHitungBilangan="belum"
                                val statusPengukuranKelas3="belum"
                                val statusPecahanSederhana="belum"
                                val statusUnsurSifatBangunDatar="belum"
                                val statusKelilingLuasPersegi="belum"


                                val userid = auth.currentUser?.uid

                                val ref = FirebaseDatabase.getInstance().getReference("users")
                                val usersId = userid
                                val usr = Users(usersId,
                                    statusBilanganCacah,
                                    statusSatuanPengukuran,
                                    statusPenjumlahanPengurangan,
                                    statusBangunRuang,
                                    statusPengukuranBerat,
                                    statusBangunDatar,
                                    statusUrutanBilangan,
                                    statusOperasiPenjumlahanPengurangan,
                                    statusPengukuran,
                                    statusOperasiPerkalianPembagian,
                                    statusBangunDatarKelas2,
                                    skorKelas1,
                                    skorKelas2,
                                    skorKelas3,
                                    skorKelas4,
                                    skorKelas5,
                                    skorKelas6,
                                    statusOperasiHitungBilangan,
                                    statusPengukuranKelas3,
                                    statusPecahanSederhana,
                                    statusUnsurSifatBangunDatar,
                                    statusKelilingLuasPersegi,
                                    aplikasiPecahan,
                                    aproksimasi1,
                                    aproksimasi2,
                                    aproksimasi3,
                                    bentukPecahan,
                                    bilanganPecahan,
                                    faktorPrima,
                                    faktorKelipatanBilangan,
                                    kpkfpb,
                                    kelilingBangunDatar, luasBangunDatar, penerapanKpkFpb, sudut1, sudut2, segiBanyak, statistika1, statistika2, taksiran, bangunRuangKelas5, kecepatanDebit, operasiHitungPecahan, pengumpulanPenyajianData, skala, bangunRuangKelas6, bilanganBulat, lingkaran, statistikaKelas6
                                    )

                                if (usersId != null) {
                                    ref.child(usersId).setValue(usr).addOnCompleteListener{
                                        Toast.makeText(this, "Berhasil Masuk", Toast.LENGTH_SHORT).show()
                                    }
                                }
                                Toast.makeText(this, "Berhasil Masuk", Toast.LENGTH_SHORT).show()
                                startActivity(it)
                            }
                        } else {
                                Toast.makeText(this, "Gagal Masuk", Toast.LENGTH_SHORT).show()
                            }
                    }
                }

        }
    }
}