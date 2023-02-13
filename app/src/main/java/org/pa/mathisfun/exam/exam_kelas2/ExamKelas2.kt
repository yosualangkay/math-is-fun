package org.pa.mathisfun.exam.exam_kelas2

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
import org.pa.mathisfun.databinding.ActivityExamKelas2Binding
import org.pa.mathisfun.exam.exam_kelas1.ExamResultKelas1
import org.pa.mathisfun.exam.exam_kelas1.ExamResultMinKelas1

class ExamKelas2 : AppCompatActivity() {

    private lateinit var binding: ActivityExamKelas2Binding

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
        mutableListOf("Lambang bilangan dari seratus\n" + "enam puluh tujuh adalah...",
            "167", "163", "164", "165"),
        mutableListOf("Penulisan 163 dalam bentuk\n" + "kata adalah...",
            "Seratus enam puluh tiga", "Seratus enam puluh dua", "Seratus enam belas", "Seratus enam puluh satu"),
        mutableListOf("Bilangan terkecil yang dapat\n" + "dibentuk dari angka 1, 2, 3\n" + "adalah...",
            "123", "131", "321", "231"),
        mutableListOf("Urutan bilangan 66, 76, 46, 68, 62,\n" + "dan 67 mulai dari terkecil yang\n" + "benar adalah...",
            "46, 62, 66, 67, 68, 76", "46, 62, 66, 68, 67, 76", "76, 67, 68, 66, 62, 46", "76, 68, 67, 66, 62, 46"),
        mutableListOf("Jika Andi memiliki 86 kelereng\n" + "dan Nanda 78 kelereng maka\n" + "kelereng Andi lebih...daripada\n" + "kelereng Nanda.",
            "Banyak", "Sedikit", "Kurang", "Sedikit"),
        mutableListOf("Lisa mendapatkan nilai 73 pada\n" + "ujian matematika. Jika nilai ujian\n" + "matematika siswa dibawah 75\n" + "maka diwajibkan untuk mengikuti\n" + "pelajaran tambahan matematika.\n" + "Berapa tambahan nilai yang perlu\n" + "dimiliki Lisa agar tidak mengikuti\n" + "pelajaran tambahan matematika...",
            "2", "3", "4", "5"),
        mutableListOf("Bilangan genap yang terletak\n" + "diantara 1 sampai 12 adalah...",
            "2, 4, 6, 8", "2, 4, 5, 6, 8, 12", "1, 2, 4, 6, 8, 12", "2, 4, 5, 6, 8"),
        mutableListOf("Bilangan ganjil yang terletak\n" + "diantara 16 sampai 27 adalah...",
            "17, 19, 21, 23, 25", "17, 19, 20, 21, 25", "17, 19, 21, 22, 25, 27", "17, 19, 21, 23, 25, 27, 29"),
        mutableListOf("Tentukan nilai tempat angka 7\n" + "dari bilangan 175...",
            "Puluhan", "Ratusan", "Ribuan", "Satuan"),
        mutableListOf("Tentukan nilai yang memiliki\n" + "tempat ratusan pada bilangan\n" + "908...",
            "9", "0", "8", "1"),
        mutableListOf("Penulisan bentuk panjang dari\n" + "bilangan 652 yaitu...",
            "600 + 50 + 2", "600 + 20 + 5", "500 + 60 + 2", "200 + 20 + 6"),
        mutableListOf("Hitunglah hasil dari 61 + 76...",
            "137", "138", "139", "136"),
        mutableListOf("Ana mempunyai 74 apel,\n" + "kemudian diberikan kepada\n" + "teman-temannya sebanyak\n" + "55 buah. Maka berapakah\n" + "sisa apel yang dimiliki Ana...",
            "19", "29", "21", "11"),
        mutableListOf("Jika panjang tali rafia 18 meter\n" + "dan panjang pita 14 meter, maka\n" + "panjang pita... daripada tali rafia.",
            "Lebih pendek", "Lebih kecil", "Lebih berat", "Lebih panjang"),
        mutableListOf("Nina berangkat sekolah pukul\n" + "06:00 dan sampai pada pukul\n" + "07:00. Berapa jam perjalanan\n" + "dari rumah Nina ke sekolah...",
            "1", "3", "4", "2"),
        mutableListOf("Dinda membeli 500 gram telur,\n" + "kemudian digunakan untuk\n" + "membuat kue sebanyak 125\n" + "gram. Tentukan berapa gram\n" + "telur yang dimiliki Dinda sekarang...",
            "375", "357", "475", "457"),
        mutableListOf("Nia membeli 5 bungkus permen\n" + "dengan setiap bungkusnya berisi\n" + "7 permen. Berapa jumlah perman\n" + "yang dimiliki Nia...",
            "35", "34", "33", "36"),
        mutableListOf("Bangun datar uang pasti memiliki\n" + "sisi berukuran sama panjang dan\n" + "semua sudutnya siku-siku disebut...",
            "Persegi", "Jajargenjang", "Persegi panjang", "Layang-layang"),
        mutableListOf("Jumlah sisi pada bangun persegi\n" + "panjang adalah...",
            "4", "3", "6", "5"),
        mutableListOf("Jumlah titik sudut yang terdapat\n" + "pada bangun segitiga adalah...",
            "3", "2", "4", "5"),
        mutableListOf("Jumlah titik sudut pada bangun\n" + "persegi panjang adalah",
            "4", "3", "2", "5"),
        mutableListOf("Bangun datar yang memiliki tiga\n" + "titik sudut adalah...",
            "4", "3", "4", "5"),
        mutableListOf("Bangun datar yang memiliki\n" + "jumlah titik sudut sama dengan\n" + "persegi adalah...",
            "Jajargenjang", "Segitiga", "Segilima", "Segidelapan"),
        mutableListOf("Dinda membeli 48 kue yang\n" + "akan dibagikan sama rata\n" + "kepada saudara-saudaranya.\n" + "Jika jumlah saudara Dinda 8,\n" + "maka berapa kue yang akan\n" + "didapatkan oleh setiap saudara\n" + "Dinda...",
            "6", "3", "4", "5"),
        mutableListOf("Sinta mempunyai 5 kotak pensil\n" + "dengan jumlah pensil pada setiap\n" + "kotak adalah 8. Sinta memberikan\n" + "2 kotak pensilnya kepada adiknya\n" + "dan sisanya akan dibagikan kepada teman-temannya. Jika Sinta akan\n" + "membagikan pensil tersebut sama\n" + "rata kepada delapan temannya,\n" + "maka setiap teman Sinta akan\n" + "memperoleh berapa banyak pensil...",
            "3", "2", "4", "5"),
        mutableListOf("5 meter ... 5 centimeter. Tanda\n" + "yang tepat untuk mengisi titik-\n" + "titik tersebut adalah",
            ">", "<", "=", "+"),
        mutableListOf("Bangun datar yang memiliki 5\n" + "sisi yaitu...",
            "Trapesium", "Lingkaran", "Segienam", "Segitiga"),
        mutableListOf("Benda yang memiliki bentuk\n" + "persegi panjang yaitu...",
            "Permukaan balok kayu", "Layang-layang", "Roda sepeda", "Tenda"),
        mutableListOf("Bangun datar yang memiliki 4 titik\n" + "sudut, kecuali...",
            "Segitiga", "Layang-layang", "Persegi", "Lingkaran"),
        mutableListOf("Segitiga yang memiliki dua sisi\n" + "sama panjang dapat disebut...",
            "Segitiga sama kaki", "Segitiga sama sisi", "Segitiga siku-siku", "Segitiga sembarang")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamKelas2Binding.inflate(layoutInflater)
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
                val intent = Intent(this@ExamKelas2, ExamResultMinKelas2::class.java)
                intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount)
                startActivity(intent)
            }
            else{
                val intent = Intent(this@ExamKelas2, ExamResultKelas2::class.java)
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
        val skorKelas2 = rightAnswerCount.toString()

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

        val alertTitle: String
        if (btnText == rightAnswer) {
            //correct
//            alertTitle = "Correct!"
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