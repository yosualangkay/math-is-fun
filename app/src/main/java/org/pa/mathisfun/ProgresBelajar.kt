package org.pa.mathisfun

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.pa.mathisfun.databinding.ActivityProgresBelajarBinding
import org.pa.mathisfun.materi3.*
import org.pa.mathisfun.materi1.*
import org.pa.mathisfun.materi2.*

class ProgresBelajar : AppCompatActivity() {

    private lateinit var binding: ActivityProgresBelajarBinding
    private lateinit var auth: FirebaseAuth
    var statusBilanganCacah = ""
    var statusPenjumlahanPengurangan = ""
    var statusPengukuranBerat = ""
    var statusBangunDatar = ""
    var statusBangunRuang = ""
    var statusSatuanPengukuran = ""
    var statusUrutanBilangan= ""
    var statusOperasiPenjumlahanPengurangan= ""
    var statusPengukuran= ""
    var statusOperasiPerkalianPembagian= ""
    var statusBangunDatarKelas2= ""
    var statusOperasiHitungBilangan=""
    var statusPengukuranKelas3=""
    var statusPecahanSederhana=""
    var statusUnsurSifatBangunDatar=""
    var statusKelilingLuasPersegi=""

    var aplikasiPecahan= ""
    var aproksimasi1= ""
    var aproksimasi2= ""
    var aproksimasi3= ""
    var bentukPecahan= ""
    var bilanganPecahan= ""
    var faktorPrima= ""
    var faktorKelipatanBilangan= ""
    var kpkfpb= ""
    var kelilingBangunDatar= ""
    var luasBangunDatar= ""
    var penerapanKpkFpb= ""
    var sudut1= ""
    var sudut2= ""
    var segiBanyak= ""
    var statistika1= ""
    var statistika2= ""
    var taksiran= ""

    var bangunRuangKelas5= ""
    var kecepatanDebit= ""
    var operasiHitungPecahan= ""
    var pengumpulanPenyajianData= ""
    var skala= ""

    var bangunRuangKelas6= ""
    var bilanganBulat= ""
    var lingkaran= ""
    var statistikaKelas6= ""

    var skorKelas1 =""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgresBelajarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title="Semua Materi"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        auth = FirebaseAuth.getInstance()
        val userid = auth.currentUser?.uid

        binding.mt1.setOnClickListener{
            startActivity(Intent(this, Materi1::class.java))
        }
        binding.mt2.setOnClickListener{
            startActivity(Intent(this, Materi2::class.java))
        }
        binding.mt3.setOnClickListener{
            startActivity(Intent(this, Materi3::class.java))
        }
        binding.mt4.setOnClickListener{
            startActivity(Intent(this, Materi4::class.java))
        }
        binding.mt5.setOnClickListener{
            startActivity(Intent(this, Materi5::class.java))
        }
        binding.mt6.setOnClickListener{
            startActivity(Intent(this, Materi6::class.java))
        }
        binding.mt7.setOnClickListener{
            startActivity(Intent(this, Materi7::class.java))
        }
        binding.mt8.setOnClickListener{
            startActivity(Intent(this, Materi8::class.java))
        }
        binding.mt9.setOnClickListener{
            startActivity(Intent(this, Materi9::class.java))
        }
        binding.mt10.setOnClickListener{
            startActivity(Intent(this, Materi10::class.java))
        }
        binding.mt11.setOnClickListener{
            startActivity(Intent(this, Materi11::class.java))
        }
        binding.mt12.setOnClickListener{
            startActivity(Intent(this, Materi12::class.java))
        }
        binding.mt13.setOnClickListener{
            startActivity(Intent(this, Materi13::class.java))
        }
        binding.mt14.setOnClickListener{
            startActivity(Intent(this, Materi14::class.java))
        }
        binding.mt15.setOnClickListener{
            startActivity(Intent(this, Materi15::class.java))
        }
        binding.mt16.setOnClickListener{
            startActivity(Intent(this, Materi16::class.java))
        }


        val dref = FirebaseDatabase.getInstance().reference
        dref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                statusBilanganCacah = snapshot.child("users/${userid}/statusBilanganCacah").value!!.toString()
                statusSatuanPengukuran = snapshot.child("users/${userid}/statusSatuanPengukuran").value!!.toString()
                statusBangunRuang = snapshot.child("users/${userid}/statusBangunRuang").value!!.toString()
                statusPenjumlahanPengurangan = snapshot.child("users/${userid}/statusPenjumlahanPengurangan").value!!.toString()
                statusPengukuranBerat = snapshot.child("users/${userid}/statusPengukuranBerat").value!!.toString()
                statusBangunDatar = snapshot.child("users/${userid}/statusBangunDatar").value!!.toString()
                statusUrutanBilangan = snapshot.child("users/${userid}/statusUrutanBilangan").value!!.toString()
                statusOperasiPenjumlahanPengurangan = snapshot.child("users/${userid}/statusOperasiPenjumlahanPengurangan").value!!.toString()
                statusPengukuran = snapshot.child("users/${userid}/statusPengukuran").value!!.toString()
                statusOperasiPerkalianPembagian = snapshot.child("users/${userid}/statusOperasiPerkalianPembagian").value!!.toString()
                statusBangunDatarKelas2 = snapshot.child("users/${userid}/statusBangunDatarKelas2").value!!.toString()
                skorKelas1 = snapshot.child("users/${userid}/skorKelas1").value!!.toString()

                statusOperasiHitungBilangan = snapshot.child("users/${userid}/statusOperasiHitungBilangan").value!!.toString()
                statusPengukuranKelas3 = snapshot.child("users/${userid}/statusPengukuranKelas3").value!!.toString()
                statusPecahanSederhana = snapshot.child("users/${userid}/statusPecahanSederhana").value!!.toString()
                statusUnsurSifatBangunDatar = snapshot.child("users/${userid}/statusUnsurSifatBangunDatar").value!!.toString()
                statusKelilingLuasPersegi = snapshot.child("users/${userid}/statusKelilingLuasPersegi").value!!.toString()


                aplikasiPecahan = snapshot.child("users/${userid}/aplikasiPecahan").value!!.toString()
                aproksimasi1 = snapshot.child("users/${userid}/aproksimasi1").value!!.toString()
                aproksimasi2 = snapshot.child("users/${userid}/aproksimasi2").value!!.toString()
                aproksimasi3 = snapshot.child("users/${userid}/aproksimasi3").value!!.toString()
                bentukPecahan = snapshot.child("users/${userid}/bentukPecahan").value!!.toString()
                bilanganPecahan = snapshot.child("users/${userid}/bilanganPecahan").value!!.toString()
                faktorPrima = snapshot.child("users/${userid}/faktorPrima").value!!.toString()
                faktorKelipatanBilangan = snapshot.child("users/${userid}/faktorKelipatanBilangan").value!!.toString()
                kpkfpb = snapshot.child("users/${userid}/kpkfpb").value!!.toString()
                kelilingBangunDatar = snapshot.child("users/${userid}/kelilingBangunDatar").value!!.toString()
                luasBangunDatar = snapshot.child("users/${userid}/luasBangunDatar").value!!.toString()
                penerapanKpkFpb = snapshot.child("users/${userid}/penerapanKpkFpb").value!!.toString()
                sudut1 = snapshot.child("users/${userid}/sudut1").value!!.toString()
                sudut2 = snapshot.child("users/${userid}/sudut2").value!!.toString()
                segiBanyak = snapshot.child("users/${userid}/segiBanyak").value!!.toString()
                statistika1 = snapshot.child("users/${userid}/statistika1").value!!.toString()
                statistika2 = snapshot.child("users/${userid}/statistika2").value!!.toString()
                taksiran = snapshot.child("users/${userid}/taksiran").value!!.toString()

                bangunRuangKelas5 = snapshot.child("users/${userid}/bangunRuangKelas5").value!!.toString()
                kecepatanDebit = snapshot.child("users/${userid}/kecepatanDebit").value!!.toString()
                operasiHitungPecahan = snapshot.child("users/${userid}/operasiHitungPecahan").value!!.toString()
                pengumpulanPenyajianData = snapshot.child("users/${userid}/pengumpulanPenyajianData").value!!.toString()
                skala = snapshot.child("users/${userid}/skala").value!!.toString()

                bangunRuangKelas6 = snapshot.child("users/${userid}/bangunRuangKelas6").value!!.toString()
                bilanganBulat = snapshot.child("users/${userid}/bilanganBulat").value!!.toString()
                lingkaran = snapshot.child("users/${userid}/lingkaran").value!!.toString()
                statistikaKelas6 = snapshot.child("users/${userid}/statistikaKelas6").value!!.toString()

                if (statusBilanganCacah == "sudah"){
                    binding.cek1.visibility = View.VISIBLE
                    binding.mt1.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text1.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statusSatuanPengukuran == "sudah"){
                    binding.cek2.visibility = View.VISIBLE
                    binding.mt2.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text2.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statusBangunRuang == "sudah"){
                    binding.cek3.visibility = View.VISIBLE
                    binding.mt3.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text3.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statusPenjumlahanPengurangan == "sudah"){
                    binding.cek4.visibility = View.VISIBLE
                    binding.mt4.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text4.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statusPengukuranBerat == "sudah"){
                    binding.cek5.visibility = View.VISIBLE
                    binding.mt5.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text5.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statusBangunDatar == "sudah"){
                    binding.cek6.visibility = View.VISIBLE
                    binding.mt6.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text6.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statusUrutanBilangan == "sudah"){
                    binding.cek7.visibility = View.VISIBLE
                    binding.mt7.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text7.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statusOperasiPenjumlahanPengurangan == "sudah"){
                    binding.cek8.visibility = View.VISIBLE
                    binding.mt8.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text8.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statusPengukuran == "sudah"){
                    binding.cek9.visibility = View.VISIBLE
                    binding.mt9.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text9.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statusOperasiPerkalianPembagian == "sudah"){
                    binding.cek10.visibility = View.VISIBLE
                    binding.mt10.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text10.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statusBangunDatarKelas2 == "sudah"){
                    binding.cek11.visibility = View.VISIBLE
                    binding.mt11.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text11.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statusOperasiHitungBilangan == "sudah"){
                    binding.cek12.visibility = View.VISIBLE
                    binding.mt12.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text12.setTextColor(Color.parseColor("#FFFFFF"))
                }

                if (statusPengukuranKelas3 == "sudah"){
                    binding.cek13.visibility = View.VISIBLE
                    binding.mt13.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text13.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statusPecahanSederhana == "sudah"){
                    binding.cek14.visibility = View.VISIBLE
                    binding.mt14.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text14.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statusUnsurSifatBangunDatar == "sudah"){
                    binding.cek15.visibility = View.VISIBLE
                    binding.mt15.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text15.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statusKelilingLuasPersegi == "sudah"){
                    binding.cek16.visibility = View.VISIBLE
                    binding.mt16.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text16.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (aplikasiPecahan == "sudah"){
                    binding.cek17.visibility = View.VISIBLE
                    binding.mt17.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text17.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (aproksimasi1 == "sudah"){
                    binding.cek18.visibility = View.VISIBLE
                    binding.mt18.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text18.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (aproksimasi2 == "sudah"){
                    binding.cek19.visibility = View.VISIBLE
                    binding.mt19.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text19.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (aproksimasi3 == "sudah"){
                    binding.cek20.visibility = View.VISIBLE
                    binding.mt20.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text20.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (bentukPecahan == "sudah"){
                    binding.cek21.visibility = View.VISIBLE
                    binding.mt21.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text21.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (bilanganPecahan == "sudah"){
                    binding.cek22.visibility = View.VISIBLE
                    binding.mt22.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text22.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (faktorPrima == "sudah"){
                    binding.cek23.visibility = View.VISIBLE
                    binding.mt23.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text23.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (faktorKelipatanBilangan == "sudah"){
                    binding.cek24.visibility = View.VISIBLE
                    binding.mt24.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text24.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (kpkfpb == "sudah"){
                    binding.cek25.visibility = View.VISIBLE
                    binding.mt25.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text25.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (kelilingBangunDatar == "sudah"){
                    binding.cek26.visibility = View.VISIBLE
                    binding.mt26.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text26.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (luasBangunDatar == "sudah"){
                    binding.cek27.visibility = View.VISIBLE
                    binding.mt27.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text27.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (penerapanKpkFpb == "sudah"){
                    binding.cek28.visibility = View.VISIBLE
                    binding.mt28.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text28.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (sudut1 == "sudah"){
                    binding.cek29.visibility = View.VISIBLE
                    binding.mt29.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text29.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (sudut2 == "sudah"){
                    binding.cek30.visibility = View.VISIBLE
                    binding.mt30.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text30.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (segiBanyak == "sudah"){
                    binding.cek31.visibility = View.VISIBLE
                    binding.mt31.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text31.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statistika1 == "sudah"){
                    binding.cek32.visibility = View.VISIBLE
                    binding.mt32.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text32.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statistika2 == "sudah"){
                    binding.cek33.visibility = View.VISIBLE
                    binding.mt33.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text33.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (taksiran == "sudah"){
                    binding.cek34.visibility = View.VISIBLE
                    binding.mt34.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text34.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (bangunRuangKelas6 == "sudah"){
                    binding.cek35.visibility = View.VISIBLE
                    binding.mt35.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text35.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (kecepatanDebit == "sudah"){
                    binding.cek36.visibility = View.VISIBLE
                    binding.mt36.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text36.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (operasiHitungPecahan == "sudah"){
                    binding.cek37.visibility = View.VISIBLE
                    binding.mt37.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text37.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (pengumpulanPenyajianData == "sudah"){
                    binding.cek38.visibility = View.VISIBLE
                    binding.mt38.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text38.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (skala == "sudah"){
                    binding.cek39.visibility = View.VISIBLE
                    binding.mt39.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text39.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (bangunRuangKelas6 == "sudah"){
                    binding.cek40.visibility = View.VISIBLE
                    binding.mt40.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text40.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (bilanganBulat == "sudah"){
                    binding.cek41.visibility = View.VISIBLE
                    binding.mt41.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text41.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (lingkaran == "sudah"){
                    binding.cek42.visibility = View.VISIBLE
                    binding.mt42.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text42.setTextColor(Color.parseColor("#FFFFFF"))
                }
                if (statistikaKelas6 == "sudah"){
                    binding.cek43.visibility = View.VISIBLE
                    binding.mt43.setCardBackgroundColor(Color.parseColor("#03738B"))
                    binding.text43.setTextColor(Color.parseColor("#FFFFFF"))
                }
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



}