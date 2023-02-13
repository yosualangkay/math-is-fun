package org.pa.mathisfun.exam.exam_kelas6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.pa.mathisfun.R
import org.pa.mathisfun.Users
import org.pa.mathisfun.databinding.ActivityExamKelas5Binding
import org.pa.mathisfun.databinding.ActivityExamKelas6Binding
import org.pa.mathisfun.exam.exam_kelas5.ExamResultKelas5
import org.pa.mathisfun.exam.exam_kelas5.ExamResultMinKelas5

class ExamKelas6 : AppCompatActivity() {

    private lateinit var binding: ActivityExamKelas6Binding

    private lateinit var auth: FirebaseAuth

    private var rightAnswer: String? = null
    private var rightAnswerCount = 0
    private var quizCount = 1
    private val kuisCount = 10

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

    var skorKelas1 =""
    var skorKelas2 =""
    var skorKelas3=""
    var skorKelas4=""
    var skorKelas5=""
    var skorKelas6=""

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

    var statusOperasiHitungBilangan=""
    var statusPengukuranKelas3=""
    var statusPecahanSederhana=""
    var statusUnsurSifatBangunDatar=""
    var statusKelilingLuasPersegi=""

    private val quizData = mutableListOf(
        mutableListOf("Penulisan dari negatif tujuh adalah...",
            "-7", "7", "17", "-17"),
        mutableListOf("Bilangan -5 -4 -3 -2 -1 0 1 2 3\n" + "merupakan bilangan yang berada\n" + "diantara bilangan...dan bilangan...",
            "-6 dan 4", "-5 dan 3", "-5 dan 4", "-6 dan 3"),
        mutableListOf("Ikan paus berenang pada\n" + "kedalaman 30 m dibawah\n" + "permukaan air. Lalu ikan paus\n" + "naik 10 m untuk mencari\n" + "makanan. Berapakah kedalaman\n" + "ikan paus saat ini...",
            "20", "10", "40", "15"),
        mutableListOf("Rumah Udin terletak diantara\n" + "rumah Tina dan rumah Ali. Udin\n" + "berjalan 7 langkah ke kiri menuju\n" + "rumah Tina, lalu berjalan 14\n" + "langkah ke kanan menuju rumah\n" + "Ali. Tentukan titik Udin berada\n" + "saat ini...",
            "7", "-7", "21", "-21"),
        mutableListOf("Di daerah Wonosobo suhu pada\n" + "siang hari adalah 32°C sedangkan\n" + "pada malam hari adalah 24°C.\n" + "Berapakah sesilih suhu tersebut...",
            "8°C", "7°C", "9°C", "5°C"),
        mutableListOf("Seorang penyelam akan menyelam\n" + "sejauh 8 m ke dalam permukaan\n" + "air. Kecepatan yang penyelam\n" + "tersebut adalah 2 meter per detik.\n" + "Berapa waktu yang dibutuhkan\n" + "penyelam tersebut...",
            "16", "4", "10", "6"),
        mutableListOf("Tita membuat gambar berbentuk\n" + "lingkaran. Panjang diameter\n" + "lingkaran tersebut 28 cm. Berapakah\n" + "keliling lingkaran tersebut...",
            "308", "309", "310", "306"),
        mutableListOf("Tia membeli pizza dengan\n" + "diameter 30 cm. Berapakah\n" + "jari-jari pizza tersebut...",
            "15", "13", "18", "20"),
        mutableListOf("Tutup kaleng biskuit Dori memiliki\n" + "keliling 88 cm. Tentukan jari-jari\n" + "tutup kaleng biskuit tersebut...",
            "14", "18", "16", "12"),
        mutableListOf("Rika mempunyai kolam renang\n" + "dengan diameter 28 m. Berapakah\n" + "luas kolam Rika...",
            "616", "600", "22", "25"),
        mutableListOf("Mika memakai tempat makan\n" + "yang alasnya berbentuk lingkaran.\n" + "Luas lingkaran tersebut 154 cm.\n" + "Berapakah jari-jari lingkaran\n" + "tersebut...",
            "7", "8", "6", "5"),
        mutableListOf("Ika membeli cokelat berbentuk\n" + "prisma segitiga. Luas alas cokelat\n" + "tersebut adalah 7 cm dan keliling\n" + "alas cokelat adalah 8 cm dan\n" + "tinggi cokelat tersebut adalah\n" + "10 cm. Berapakah luas permukaan\n" + "cokelat tersebut...",
            "94", "162", "64", "54"),
        mutableListOf("Tempat biskuit Roni berbentuk\n" + "tabung yang memiliki panjang\n" + "jari-jari 21 cm dan tinggi 30 cm.\n" + "Berapakah luas permukaan\n" + "kaleng biskuit Roni...",
            "6.732", "6.532", "6.372", "6.733"),
        mutableListOf("Luas permukaan prisma tegak\n" + "yang alasnya berbentuk segitiga\n" + "siku-siku adalah 912 cm². Jika\n" + "panjang rusuk alas masing-\n" + "masing 12 cm, 20 cm, dan 16 cm\n" + "maka tinggi prisma adalah...",
            "15", "10", "4", "5"),
        mutableListOf("Alas suatu limas berbentuk\n" + "persegi dengan panjang 12 cm.\n" + "Jika tinggi limas 8 cm. Maka\n" + "hitunglah luas permukaan limas...",
            "380", "350", "340", "360"),
        mutableListOf("Sebuah limas yang alasnya\n" + "berbentuk persegi mempunyai\n" + "luas alas 144 cm². Jika tinggi\n" + "limas 8 cm, hitunglah luas\n" + "permukaan limas tersebut...",
            "384", "476", "294", "508"),
        mutableListOf("Jari-jari alas sebuah kerucut\n" + "adalah 6 cm. Jika tinggi kerucut\n" + "adalah 8 cm. Hitunglah luas\n" + "permukaan kerucut...",
            "301,44", "300,04", "304,00", "305,4"),
        mutableListOf("Bayu membeli bola yang\n" + "memiliki diameter 16 cm.\n" + "Hitunglah luas permukaan\n" + "bola tersebut...",
            "803,84", "803,80", "803,48", "803,85"),
        mutableListOf("Es krim merupakan gabungan\n" + "dari setengah bola dan kerucut.\n" + "Panjang diameter es krim 7 cm.\n" + "Dan panjang garis tepi cone\n" + "15 cm. Hitunglah luas permukaan\n" + "es krim tersebut...",
            "242", "232", "424", "222"),
        mutableListOf("Alas sebuah prisma berbentuk\n" + "segitiga sama kaki dengan\n" + "panjang sisi alas 10 cm dan\n" + "panjang sisi kaki 13 cm. Maka\n" + "volume prisma tersebut jika\n" + "tingginya 15 cm adalah...",
            "900", "750", "800", "720"),
        mutableListOf("Diketahui jari-jari alas tabung\n" + "21 cm. Tinggi tabung 40 cm.\n" + "Berapakah volume tabung\n" + "tersebut...",
            "55.440", "55.443", "44.440", "45.240"),
        mutableListOf("Sebuah bola basket mempunyai\n" + "diameter 24 cm. Carilah volume\n" + "bola tersebut...",
            "7234,56", "7145,66", "7343,77", "7654,45"),
        mutableListOf("Berikut ini adalah data hasil\n" + "ulangan matematika kelas VI\n" + "SD Budi Mulia 5 6 6 7 5 8 9 10\n" + "10 9 8 6 7 6 7 8 9 10 7 8 5 6 9 8\n" + "8 7 7 9 5 9 8 9 9 8 7 7 8 6 6 8.\n" + "Nilai rata-rata dari data di atas\n" + "adalah ....",
            "7,5", "8,3", "7,4", "8,5"),
        mutableListOf("Dewi mendapat nilai ulangan\n" + "sebanyak 4 kali yaitu 10, 8, 9, 6.\n" + "Supaya nilai rata- ratanya 8,5,\n" + "maka ulangan kelima, Dewi\n" + "harus mendapat nilai ....",
            "9,5", "8,3", "7,4", "8,5"),
        mutableListOf("Nilai rata-rata Matematika 5 orang\n" + "siswa adalah 90. Jika ditambah\n" + "dengan nilai Amel, nilai rata-rata\n" + "menjadi 85. Nilai Amel adalah ....",
            "60", "73", "84", "95")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamKelas6Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()
        val userid = auth.currentUser?.uid

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
                statusBangunDatar = snapshot.child("users/${userid}/statusBangunDatar").value!!.toString()

                skorKelas1 = snapshot.child("users/${userid}/skorKelas1").value!!.toString()
                skorKelas2 = snapshot.child("users/${userid}/skorKelas2").value!!.toString()
                skorKelas3 = snapshot.child("users/${userid}/skorKelas3").value!!.toString()
                skorKelas4 = snapshot.child("users/${userid}/skorKelas4").value!!.toString()
                skorKelas5 = snapshot.child("users/${userid}/skorKelas5").value!!.toString()
                skorKelas6 = snapshot.child("users/${userid}/skorKelas6").value!!.toString()

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

        binding.btnSelesai.setOnClickListener {
            if (rightAnswerCount <= 50){
                val intent = Intent(this@ExamKelas6, ExamResultMinKelas6::class.java)
                intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount)
                startActivity(intent)
            }
            else{
                val intent = Intent(this@ExamKelas6, ExamResultKelas6::class.java)
                intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount)
                startActivity(intent)
            }

            saveNilai()
        }

        binding.btnNext.setOnClickListener {
            if (quizCount < quizData.size){
                quizCount++
                checkQuizCount()

            }
        }

        binding.btnBack.setOnClickListener {
            if (quizCount > 1){
                quizCount--
                checkQuizCount()
            }
        }

        showNextQuiz()

        val actionbar = supportActionBar
        actionbar!!.title="Exam"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    private fun saveNilai() {
        val skorKelas6 = rightAnswerCount.toString()

        auth = FirebaseAuth.getInstance()
        val userid = auth.currentUser?.uid


        val ref = FirebaseDatabase.getInstance().getReference("users")
        val usersId = userid
        val usr = Users(usersId,
            statusBilanganCacah,
            statusSatuanPengukuran,
            statusBangunRuang,
            statusPenjumlahanPengurangan,
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
                Toast.makeText(this, "Selesai", Toast.LENGTH_SHORT).show()


            }
        }
    }

    private fun showNextQuiz() {

        if (quizCount==10){
            binding.btnNext.visibility = View.INVISIBLE
        }else{
            binding.btnNext.visibility = View.VISIBLE
        }
        if (quizCount==1){
            binding.btnBack.visibility = View.INVISIBLE
        }else{
            binding.btnBack.visibility = View.VISIBLE
        }

//        //update nomor
        binding.nomorExam.text = getString(R.string.nomorExam, quizCount)
//
//        //pick one quiz set
        val quiz = quizData[quizCount-1]
//
//        //set question & right answer
        binding.tvQuestion.text = quiz[0]
        rightAnswer = quiz[1]
//
//
//        //set choices
        binding.rbOptionOne.text = quiz[1]
        binding.rbOptionTwo.text = quiz[2]
        binding.rbOptionThree.text = quiz[3]
        binding.rbOptionFour.text = quiz[4]

    }

    fun checkAnswer(view: View) {
//        //get pushed button

        val answerBtn: RadioButton = findViewById(view.id)
        val btnText = answerBtn.text.toString()

//        val alertTitle: String
        if (btnText == rightAnswer) {
            //correct
//            alertTitle = "Correct!"
            rightAnswerCount += 10
        }else {
            rightAnswerCount += 0
        }

        //create dialog
        AlertDialog.Builder(this)
            .setMessage("Jawaban diisi, soal selanjutnya.")
            .setPositiveButton("OK") {dialogInterface, i -> }
            .setCancelable(false).show()
    }

    private fun checkQuizCount() {
        if (quizCount == 10) {
            //show result
            showNextQuiz()
            binding.btnSelesai.visibility = View.VISIBLE
        } else {
            binding.btnSelesai.visibility = View.INVISIBLE
            showNextQuiz()
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}