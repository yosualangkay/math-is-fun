package org.pa.mathisfun.exam.exam_kelas1

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
import org.pa.mathisfun.databinding.ActivityExamKelas1Binding

class ExamKelas1 : AppCompatActivity() {

    private lateinit var binding: ActivityExamKelas1Binding
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
    var skorKelas2 = ""
    var skorKelas3 = ""
    var skorKelas4 = ""
    var skorKelas5 = ""
    var skorKelas6 = ""

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


    private val quizData = mutableListOf(
        mutableListOf("17 bilangan di samping dibaca...",
            "Tujuh belas", "Tujuh", "Tujuh puluh", "Tujuh ratus"),
        mutableListOf("4, 6, 8, 12 bilangan yang terbesar\n" + "adalah...",
            "12", "4", "6", "8"),
        mutableListOf("Anto memiliki 5 balon kemudian\n" + "meletus 1. Berapa sisa balon Anto...",
            "4", "5", "3", "2"),
        mutableListOf("Dino memiliki 12 kelereng Angga\n" + "memiliki 7 kelereng Aldo memiliki\n" + "15 Kelereng Kelereng siapa yang\n" + "jumlahnya lebih banyak...",
            "Aldo", "Dino", "Angga", "Sama banyak"),
        mutableListOf("Ibu membeli 8 butir telur. Saat\n" + "perjalanan telurnya pecah 2 butir.\n" + "Berapa butir telur ibu yang tersisa...",
            "6", "3", "4", "5"),
        mutableListOf("Pukul 11 jarum pendek menunjuk\n" + "angka...",
            "Sebelas", "Sembilan", "Sepuluh", "Tujuh"),
        mutableListOf("3 bulan sebelum bulan September\n" + "adalah bulan...",
            "Juni", "Juli", "Agustus", "Mei"),
        mutableListOf("Dina tidur siang mulai pukul satu\n" + "dan bangun pukul tiga. Berapa\n" + "lama Dina tidur siang...",
            "Tiga", "Empat", "Lima", "Satu"),
        mutableListOf("Matahari terbit pada waktu...hari",
            "Pagi", "Siang", "Sore", "Malam"),
        mutableListOf("Adik menginap di rumah nenek\n" + "hari Sabtu. 3 hari kemudian adik\n" + "pulang ke rumah. Hari apa adik\n" + "pulang ke rumah...",
            "Selasa", "Senin", "Rabu", "Kamis"),
        mutableListOf("Gelas termasuk bangun...",
            "Tabung", "Kerucut", "Bola", "Kubus"),
        mutableListOf("Bola tenis termasuk bangun...",
            "Bola", "Balok", "Kerucut", "Tabung"),
        mutableListOf("Yang termasuk bangun kerucut\n" + "adalah...",
            "Topi ulang tahun", "Gelas", "Globe", "Kotak korek api"),
        mutableListOf("Doni memiliki 23 kelereng.\n" + "Kemudian ia membeli lagi 36\n" + "kelereng. Berapakah jumlah\n" + "kelereng milik Doni saat ini...",
            "59", "60", "58", "61"),
        mutableListOf("Ibu membeli 29 buah apel saat\n" + "belanja. Diberikan kepada\n" + "tetangga 6 buah. Berapa sisa\n" + "apel ibu sekarang...",
            "23", "32", "24", "35"),
        mutableListOf("Rian mempunyai 2 bola basket,\n" + "lalu kakek memberikan 3 bola\n" + "sepak dan 4 bola voli.\n" + "Doni mempunyai 2 bola basket\n" + "dan 3 bola sepak, lalu paman\n" + "memberikan 4 bola voli. Berapa\n" + "banyak jumlah bola Rian dan Doni\n" + "sekarang...",
            "18", "16", "14", "20"),
        mutableListOf("Mobil...daripada motor",
            "Lebih berat", "Lebih ringan", "Sama berat", "Salah semua"),
        mutableListOf("Bola tenis...daripada bola basket",
            "Lebih ringan", "Lebih berat", "Sama berat", "Salah semua"),
        mutableListOf("7 pensil...daripada 2 pensil",
            "Lebih berat", "Lebih ringan", "Sama berat", "Salah semua"),
        mutableListOf("Sapi...daripada kambing",
            "Lebih berat", "Lebih ringan", "Sama berat", "Salah semua"),
        mutableListOf("Bangun yang mempunyai 3 sisi\n" + "adalah...",
            "Segitiga", "Segiempat", "Lingkaran", "Segilima"),
        mutableListOf("Bangun segitiga mempunyai...sisi",
            "3", "2", "4", "5"),
        mutableListOf("Bangun yang dibatasi oleh\n" + "sebuah sisi lengkung adalah...",
            "Lingkaran", "Segitiga", "Segiempat", "Segilima"),
        mutableListOf("Pintu mempunyai...sisi",
            "4", "3", "2", "5"),
        mutableListOf("Televisi mempunyai bentuk\n" + "permukaan...",
            "Segiempat", "Lingkaran", "Segitiga", "Segilima"),
        mutableListOf("Gelas mempunyai bentuk\n" + "permukaan...",
            "Lingkaran", "Segiempat", "Segitiga", "Segilima"),
        mutableListOf("Uang logam mempunyai...sisi",
            "1", "3", "4", "2")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamKelas1Binding.inflate(layoutInflater)
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
                val intent = Intent(this@ExamKelas1, ExamResultMinKelas1::class.java)
                intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount)
                startActivity(intent)
            }
            else{
                val intent = Intent(this@ExamKelas1, ExamResultKelas1::class.java)
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
        val skorKelas1 = rightAnswerCount.toString()

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

//    private fun showPrevQuiz() {
//
//        //update nomor
//        binding.nomorExam.text = getString(R.string.nomorExam, quizCount)
//
//        //pick one quiz set
//        val quiz = quizData[0]
//
//        //set question & right answer
//        binding.tvQuestion.text = quiz[0]
//        rightAnswer = quiz[1]
//
//        //remove soal from quiz
////        quiz.removeAt(0)
//
////        //shuffle answer & choices
//        quiz.shuffle()
//
//        //set choices
//        binding.rbOptionOne.text = quiz[0]
//        binding.rbOptionTwo.text = quiz[1]
//        binding.rbOptionThree.text = quiz[2]
//        binding.rbOptionFour.text = quiz[3]
//
//        //remove this quiz from quizData
////        quizData.removeAt(0)
//
//    }

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
//        //remove soal from quiz
//        quiz.removeAt(0)
//
////        //shuffle answer & choices
//        quiz.shuffle()
//
//        //set choices
        binding.rbOptionOne.text = quiz[1]
        binding.rbOptionTwo.text = quiz[2]
        binding.rbOptionThree.text = quiz[3]
        binding.rbOptionFour.text = quiz[4]


//
//        //remove this quiz from quizData
//        quizData.removeAt(0)



    }

    fun checkAnswer(view: View) {
//        //get pushed button

        val answerBtn: RadioButton = findViewById(view.id)
        val btnText = answerBtn.text.toString()

//        val alertTitle: String
        if (btnText == rightAnswer) {
            //correct
//            alertTitle = "Correct!"ght
            rightAnswerCount += 10
        }
        else {
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