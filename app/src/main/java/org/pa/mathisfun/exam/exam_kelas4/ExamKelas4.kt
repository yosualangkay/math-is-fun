package org.pa.mathisfun.exam.exam_kelas4

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
import org.pa.mathisfun.databinding.ActivityExamKelas4Binding
import org.pa.mathisfun.exam.exam_kelas3.ExamResultKelas3
import org.pa.mathisfun.exam.exam_kelas3.ExamResultMinKelas3

class ExamKelas4 : AppCompatActivity() {

    private lateinit var binding: ActivityExamKelas4Binding

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

    var statusOperasiHitungBilangan=""
    var statusPengukuranKelas3=""
    var statusPecahanSederhana=""
    var statusUnsurSifatBangunDatar=""
    var statusKelilingLuasPersegi=""

    private val quizData = mutableListOf(
        mutableListOf("Rita dan Nina membeli roti bakar.\n" + "Roti bakar tersebut dipotong\n" + "menjadi 8 bagian. Masing-masing\n" + "dari mereka mendapatkan 4 bagian.\n" + "Rita telah memakan 3 bagian, lalu\n" + "Nina sudah memakan 1 bagian.\n" + "Pecahan berapakah yang menunjukkan\n" + "bagian yang belum dimakan Nina...",
            "3\n" + "-\n" + "4", "1\n" + "-\n" + "4", "1\n" + "-\n" + "8", "3\n" + "-\n" + "8"),
        mutableListOf("Sederhanakanlah nilai pecahan\n" + "dari 3/6...",
            "1\n" + "-\n" + "2", "1\n" + "-\n" + "3", "2\n" + "-\n" + "3", "1\n" + "-\n" + "6"),
        mutableListOf("Bentuk sederhana dari pecahan\n" + "7/21...",
            "1\n" + "-\n" + "3", "1\n" + "-\n" + "2", "7\n" + "-\n" + "3", "2\n" + "-\n" + "3"),
        mutableListOf("Tito membeli 1/4 kg mangga,\n" + "Toto membeli 1/2 kg mangga.\n" + "Berapa kg mangga yang mereka\n" + "beli...",
            "3\n" + "-\n" + "4", "3\n" + "-\n" + "2", "4\n" + "-\n" + "4", "2\n" + "-\n" + "3"),
        mutableListOf("Ibu meminta tolong kepada Tina\n" + "untuk membelikan 2 kg cabe,\n" + "1  4/2 kg telur, 1 kg bawang.\n" + "Berapa kg jumlah belanjaan Tina...",
            "6", "3", "4", "5"),
        mutableListOf("Ubahlah 35% ke dalam bentuk\n" + "desimal...",
            "0,35", "3,5", "0,035", "35"),
        mutableListOf("Tentukan taksiran bawah ke\n" + "ratusan terdekat dari 1.450...",
            "1.400", "1.300", "1.000", "1.350"),
        mutableListOf("20% dari 250 adalah...",
            "50", "25", "100", "20"),
        mutableListOf("Sebutkan bilangan yang merupakan\n" + "faktor dari 10...",
            "1, 2, 5, 10", "1, 2, 4, 5,", "2, 5, 10", "2, 4, 5, 10"),
        mutableListOf("Tentukan kelipatan dari 12...",
            "12, 24, 36, 48", "2, 3, 6, 12", "12, 25, 36, 48", "6, 12, 18, 24"),
        mutableListOf("Mana yang termasuk ke\n" + "dalam bilangan prima...",
            "2, 5, 7, 11", "2, 3, 4, 7", "1, 2, 3, 5", ", 1, 3, 4, 8"),
        mutableListOf("Faktorisasi dari 24 adalah...",
            "2 x 2 x 2 x 3", "2 x 2 x 3", "2 x 3 x 3", "2 x 2 x 2 x 2"),
        mutableListOf("Berapakah KPK dari 7 dan 3...",
            "21", "14", "24", "42"),
        mutableListOf("Tentukan FPB dari 18 dan 24...",
            "6", "12", "4", "3"),
        mutableListOf("Edo dan Tedy berangkat ke\n" + "sekolah pada waktu yang sama.\n" + "Edo membutuhkan waktu 90\n" + "menit sedangkan Tedy\n" + "membutuhkan waktu 60 menit.\n" + "Pada menit berapakah mereka\n" + "akan bertemu...",
            "15", "60", "75", "40"),
        mutableListOf("Hari ini bunga menimbang berat\n" + "badannya di posyandu. Berat\n" + "badan bunga saat ini adalah\n" + "23,7 kg. Berapakah pembulatan\n" + "terbaik dari berat badan bunga...",
            "24", "23", "25", "20"),
        mutableListOf("Andi pergi ke supermarket untuk\n" + "membeli anggur. Ia menimbang\n" + "anggur tersebut. Berat anggur\n" + "tersebut adalah 1,2 kg. Berapakah\n" + "pembulatan terbaik dari berat\n" + "anggur tersebut...",
            "1", "3", "4", "2"),
        mutableListOf("Segilima memiliki ... sisi dan ...\n" + "titik sudut",
            "5 dan 5", "5 dan 4", "4 dan 5", "5 dan 6"),
        mutableListOf("Paman memiliki tanah berbentuk\n" + "persegi. Setiap sisinya memiliki\n" + "panjang 50m. Paman ingin\n" + "menambahkan kawat pada setiap\n" + "sisinya. Berapa panjang kawat\n" + "yang dibutuhkan paman...",
            "200", "250", "300", "100"),
        mutableListOf("Beni pergi ke kolam renang\n" + "dengan panjang 32m dan lebar\n" + "20m. Berapakah keliling kolam\n" + "tersebut...",
            "104", "52", "640", "64"),
        mutableListOf("Hitunglah keliling segitiga sama\n" + "sisi dengan panjang 13cm...",
            "39", "169", "26", "156"),
        mutableListOf("Hitunglah panjang sisi miring\n" + "dari segitiga siku-siku dengan\n" + "tinggi 4cm dan alas 3cm...",
            "5", "3", "4", "6"),
        mutableListOf("Hitunglah luas kebun kakek yang\n" + "berbentuk persegi panjang dengan\n" + "panjang 35m dan lebar 23m...",
            "805", "116", "58", "807"),
        mutableListOf("Hitunglah luas segitiga dengan\n" + "alas 10cm dan tinggi 7cm...",
            "35", "17", "24", "34"),
        mutableListOf("Contoh garis berpotongan\n" + "terdapat pada...",
            "Perempatan jalan", "Jarum jam pukul 12.00", "Huruf L", "Huruf V"),
        mutableListOf("Pada suatu kelas terdapat 20 siswa\n" + "yang mengikuti ujian matematika.\n" + "Hasil dari ujian matematika tersebut\n" + "adalah sebagai berikut : 70, 79, 80,\n" + "85, 89, 90, 98, 67, 78, 65, 88, 78, 82,\n" + "98, 83, 84, 78, 78, 89, 90. Dari hasil\n" + "tersebut nilai yang memiliki frekuensi\n" + "terbanyak adalah...",
            "78", "89", "98", "90"),
        mutableListOf("Pada suatu kelas terdapat 20 siswa\n" + "yang mengikuti ujian matematika.\n" + "Hasil darj ujian matematika tersebut\n" + "adalah sebagai berikut : 70, 79, 80,\n" + "85, 89, 90, 98, 67, 78, 65, 88, 78, 82,\n" + "98, 83, 84, 78, 78, 89, 90. Dari hasil\n" + "tersebut frekuensi nilai tertinggi adalah...",
            "2", "3", "4", "5"),
        mutableListOf("Berapakah besar salah satu sudut\n" + "pada segitiga sama sisi...",
            "60°", "90°", "50°", "65°"),
        mutableListOf("Pukul berapakah yang menunjukkan\n" + "sudut lancip...",
            "15.25", "03.00", "18.00", "08.00"),
        mutableListOf("Berapakah besar sudut dari pukul\n" + "06.00...",
            "180°", "90°", "120°", "185°")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamKelas4Binding.inflate(layoutInflater)
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
                val intent = Intent(this@ExamKelas4, ExamResultMinKelas4::class.java)
                intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount)
                startActivity(intent)
            }
            else{
                val intent = Intent(this@ExamKelas4, ExamResultKelas4::class.java)
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
        val skorKelas4 = rightAnswerCount.toString()

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
            .setPositiveButton("OK") {dialogInterface, i ->}
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