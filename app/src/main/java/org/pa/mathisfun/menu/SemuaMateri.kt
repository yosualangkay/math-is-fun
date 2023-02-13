package org.pa.mathisfun.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.pa.mathisfun.MateriAdapter
import org.pa.mathisfun.R
import org.pa.mathisfun.databinding.ActivitySemuaMateriBinding
import org.pa.mathisfun.materi3.*
import org.pa.mathisfun.materi5.*
import org.pa.mathisfun.materi5.BangunRuang
import org.pa.mathisfun.materi6.*
import org.pa.mathisfun.materi4.*
import org.pa.mathisfun.materi4.KelilingBangunDatar
import org.pa.mathisfun.materi1.*
import org.pa.mathisfun.materi2.*
import java.util.*

class SemuaMateri : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: MateriAdapter

    private var materiList = mutableListOf<String>()
    private  var displayList = mutableListOf<String>()

    private lateinit var binding: ActivitySemuaMateriBinding
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
        binding = ActivitySemuaMateriBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val actionbar = supportActionBar
        actionbar!!.title="Semua Materi"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        //kelas1

        materiList.add("Bilangan Cacah")
        materiList.add("Satuan Pengukuran")
        materiList.add("Bangun Ruang Kelas 1")
        materiList.add("Penjumlahan dan Pengurangan")
        materiList.add("Pengukuran Berat")
        materiList.add("Bangun Datar Kelas 1")

        //kelas2
        materiList.add("Urutan Bilangan")
        materiList.add("Operasi Penjumlahan dan Pengurangan")
        materiList.add("Pengukuran Kelas 2")
        materiList.add("Operasi Perkalian dan Pembagian")
        materiList.add("Bangun Datar Kelas 2")

        //kelas3
        materiList.add("Operasi Hitung Bilangan")
        materiList.add("Pengukuran Kelas 3")
        materiList.add("Pecahan Sederhana")
        materiList.add("Unsur-Unsur dan Sifat Bangun Datar")
        materiList.add("Keliling dan Luas Persegi dan Persegi Panjang")

        //kelas4
        materiList.add("Bilangan Pecahan")
        materiList.add("Bentuk Pecahan")
        materiList.add("Taksiran")
        materiList.add("Aplikasi Pecahan")
        materiList.add("Faktor dan Kelipatan Bilangan")
        materiList.add("FaktorisasiPrima")
        materiList.add("Menentukan KPK dan FPB")
        materiList.add("Penerapan KPK dan FPB")
        materiList.add("Pembulatan Hasil Pengukuran Panjang dan Berat Ke Satuan Terdekat")
        materiList.add("Pembulatan Hasil Pengukuran Panjang dan Berat Ke Puluhan Terdekat")
        materiList.add("Pembulatan Hasil Pengukuran Panjang dan Berat Ke Ratusan Terdekat")
        materiList.add("Bangun Segi Banyak")
        materiList.add("Keliling Bangun Datar")
        materiList.add("Luas Bangun Datar")
        materiList.add("Membaca dan Menafsir Data")
        materiList.add("Penyajian Data Dalam Bentuk Diagram Batang")
        materiList.add("Pengukuran Sudut Dalam Satuan Baku Dengan Busur Serajat")
        materiList.add("Pengukuran Sudut Dengan Busur Serajat")
        //kelas5
        materiList.add("Operasi Hitung Pecahan")
        materiList.add("Kecepatan dan Debit")
        materiList.add("Skala")
        materiList.add("Bangun Ruang")
        materiList.add("Pengumpulan dan Penyajian Data")
        //kelas6
        materiList.add("Bilangan Bulat")
        materiList.add("Bangun Ruang Kelas 6")
        materiList.add("Lingkaran")
        materiList.add("Statistika")

        displayList.addAll(materiList)



        auth = FirebaseAuth.getInstance()
        val userid = auth.currentUser?.uid

        recyclerView = findViewById(R.id.rvMateri)
        recyclerAdapter = MateriAdapter(displayList)
        {
            when (it) {

                //kelas1
                "Bilangan Cacah" -> {
                    startActivity(Intent(this, Materi1::class.java))

                }
                "Satuan Pengukuran" -> {
                    startActivity(Intent(this, Materi2::class.java))
                }
                "Bangun Ruang Kelas 1" -> {
                    startActivity(Intent(this, Materi3::class.java))
                }
                "Penjumlahan dan Pengurangan" -> {
                    startActivity(Intent(this, Materi4::class.java))
                }
                "Pengukuran Berat" -> {
                    startActivity(Intent(this, Materi5::class.java))
                }
                "Bangun Datar Kelas 1" -> {
                    startActivity(Intent(this, BilanganPecahan::class.java))
                }
                //kelas2
                "Urutan Bilangan" -> {
                    startActivity(Intent(this, Materi7::class.java))
                }
                "Operasi Penjumlahan dan Pengurangan" -> {
                    startActivity(Intent(this, Materi8::class.java))
                }
                "Pengukuran Kelas 2" -> {
                    startActivity(Intent(this, Materi9::class.java))
                }
                "Operasi Perkalian dan Pembagian" -> {
                    startActivity(Intent(this, Materi10::class.java))
                }
                "Bangun Datar Kelas 2" -> {
                    startActivity(Intent(this, Materi11::class.java))
                }

                //kelas3
                "Operasi Hitung Bilangan" -> {
                    startActivity(Intent(this, Materi12::class.java))
                }
                "Pengukuran" -> {
                    startActivity(Intent(this, Materi13::class.java))
                }
                "Pecahan Sederhana" -> {
                    startActivity(Intent(this, Materi14::class.java))
                }
                "Unsur-Unsur dan Sifat Bangun Datar" -> {
                    startActivity(Intent(this, Materi15::class.java))
                }
                "Keliling dan Luas Persegi dan Persegi Panjang" -> {
                    startActivity(Intent(this, Materi16::class.java))
                }
                //kelas 4
                    "Bilangan Pecahan" -> {
                        startActivity(Intent(this, BilanganPecahan::class.java))
                    }
                "Bentuk Pecahan" -> {
                    startActivity(Intent(this, BentukPecahan::class.java))
                }
                "Taksiran" -> {
                    startActivity(Intent(this, Taksiran::class.java))
                }
                "Aplikasi Pecahan" -> {
                    startActivity(Intent(this, AplikasiPecahan::class.java))
                }
                "Faktor dan Kelipatan Bilangan" -> {
                    startActivity(Intent(this, FaktorKelipatanBilangan::class.java))
                }
                "Faktorisasi Prima" -> {
                    startActivity(Intent(this, FaktorisasiPrima::class.java))
                }
                "Menentukan KPK dan FPB" -> {
                    startActivity(Intent(this, FpbKpk::class.java))
                }
                "Penerapan KPK dan FPB" -> {
                    startActivity(Intent(this, PenerapanKpkFpb::class.java))
                }
                "Bangun Segi Banyak" -> {
                    startActivity(Intent(this, SegiBanyak::class.java))
                }
                "Keliling Bangun Datar" -> {
                    startActivity(Intent(this, KelilingBangunDatar::class.java))
                }
                "Luas Bangun Datar" -> {
                    startActivity(Intent(this, LuasBangunDatar::class.java))
                }
                "Pembulatan Hasil Pengukuran Panjang dan Berat Ke Satuan Terdekat" -> {
                    startActivity(Intent(this, Aproksimasi1::class.java))
                }
                "Pembulatan Hasil Pengukuran Panjang dan Berat Ke Puluhan Terdekat" -> {
                    startActivity(Intent(this, Aproksimasi2::class.java))
                }
                "Pembulatan Hasil Pengukuran Panjang dan Berat Ke Ratusan Terdekat" -> {
                    startActivity(Intent(this, Aproksimasi3::class.java))
                }
                "Membaca dan Menafsir Data" -> {
                    startActivity(Intent(this, Statistika1::class.java))
                }
                "Penyajian Data Dalam Bentuk Diagram Batang" -> {
                    startActivity(Intent(this, Statistika2::class.java))
                }
                "Pengukuran Sudut Dalam Satuan Baku Dengan Busur Serajat" -> {
                    startActivity(Intent(this, PengukuranSudut1::class.java))
                }
                "Pengukuran Sudut Bangun Datar Dengan Busur Serajat" -> {
                    startActivity(Intent(this, PengukuranSudut2::class.java))
                }
                    //kelas 5
                "Operasi Hitung Pecahan" -> {
                    startActivity(Intent(this, OperasiHitungPecahan::class.java))
                }
                "Kecepatan dan Debit" -> {
                    startActivity(Intent(this, KecepatanDebit::class.java))
                }
                "Skala" -> {
                    startActivity(Intent(this, Skala::class.java))
                }
                "Bangun Ruang" -> {
                    startActivity(Intent(this, BangunRuang::class.java))
                }
                "Pengumpulan dan Penyajian Data" -> {
                    startActivity(Intent(this, PengumpulanPenyajianData::class.java))
                }
                //kelas 6

                "Bilangan Bulat" -> {
                    startActivity(Intent(this, BilanganBulat::class.java))
                }
                "Lingkaran" -> {
                    startActivity(Intent(this, Lingkaran::class.java))
                }
                "Bangun Ruang Kelas 6" -> {
                    startActivity(Intent(this, BangunRuangKelas6::class.java))
                }
                "Statistika" -> {
                    startActivity(Intent(this, StatistikaKelas6::class.java))
                }

            }


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

            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        val item: MenuItem = menu!!.findItem(R.id.action_search)

        if (item != null){
            val searchView = item.actionView as SearchView

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {

                    if (newText!!.isNotEmpty()){
                        displayList.clear()
                        val search = newText.lowercase(Locale.getDefault())
                        for(materii in materiList){
                            if (materii.lowercase(Locale.getDefault()).contains(search)){
                                displayList.add(materii)
                            }
                            recyclerView.adapter!!.notifyDataSetChanged()
                        }
                    }else{
                        displayList.clear()
                        displayList.addAll(materiList)
                        recyclerView.adapter!!.notifyDataSetChanged()
//                        toLowerCase
                    }
                    return true
                }

            })
        }

        return super.onCreateOptionsMenu(menu)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}