package org.pa.mathisfun.exam.exam_kelas3

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
import org.pa.mathisfun.databinding.ActivityExamKelas3Binding
import org.pa.mathisfun.exam.exam_kelas2.ExamResultKelas2
import org.pa.mathisfun.exam.exam_kelas2.ExamResultMinKelas2

class ExamKelas3 : AppCompatActivity() {

    private lateinit var binding: ActivityExamKelas3Binding

    private lateinit var auth: FirebaseAuth

    private var rightAnswer: String? = null
    private var rightAnswerCount = 0
    private var quizCount = 1
    private val kuisCount = 10

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

    var statusOperasiHitungBilangan=""
    var statusPengukuranKelas3=""
    var statusPecahanSederhana=""
    var statusUnsurSifatBangunDatar=""
    var statusKelilingLuasPersegi=""

    private val quizData = mutableListOf(
        mutableListOf("Lisa, Nina, dan Aldo mengikuti\n" + "audisi pencarian bakat. Masing-\n" + "masing dari mereka mendapatkan\n" + "nomor urut. Lisa mendapatkan\n" + "nomor urut 235, Nina mendapatkan\n" + "nomor urut 190, dan Aldo\n" + "mendapatkan nomor urut 450.\n" + "Urutkan nomor urut mereka dari\n" + "yang terkecil ke terbesar...",
            "Nina, Lisa, Aldo", "Lisa, Nina, Aldo", "Aldo, Lisa, Nina", "Aldo, Nina, Lisa"),
        mutableListOf("Lisa, Nina, dan Aldo mengikuti\n" + "audisi pencarian bakat. Masing-\n" + "masing dari mereka mendapatkan\n"+ "nomor urut. Lisa mendapatkan\n" + "nomor urut 235, Nina mendapatkan\n" + "nomor urut 190, dan Aldo\n" + "mendapatkan nomor urut 450.\n" + "Siapakah yang akan dipanggil kedua\n" + "dari mereka...",
            "Lisa", "Nina", "Aldo", "Sarah"),
        mutableListOf("Dicky, Dani, Bakti, dan Bima\n" + "suka mengoleksi kelereng.\n" + "Dicky memiliki 687 kelereng,\n" + "Dani memiliki 467 kelereng,\n" + "Bakti memiliki 596 kelereng,\n" + "dan Bima memiliki 364 kelereng.\n" + "Siapakah dari mereka yang\n" + "memiliki kelereng paling sedikit...",
            "Bima", "Dicky", "Bakti", "Dani"),
        mutableListOf("Dicky, Dani, Bakti, dan Bima\n" + "suka mengoleksi kelereng.\n" + "Dicky memiliki 687 kelereng,\n" + "Dani memiliki 467 kelereng,\n" + "Bakti memiliki 596 kelereng,\n" + "dan Bima memiliki 364 kelereng.\n" + "Siapakah dari mereka yang\n" + "memiliki kelereng paling banyak...",
            "Dicky", "Dani", "Bakti", "Bima"),
        mutableListOf("Bilangan apakah yang terletak\n" + "diantara bilangan 457 dan 460..",
            "458, 459", "456, 455", "410, 411", "455, 456"),
        mutableListOf("Tentukan lambang bilangan dari\n" + "tujuh ratus tujuh puluh tiga...",
            "773", "783", "173", "775"),
        mutableListOf("Tentukan lambang bilangan dari\n" + "100 + 20 + 7...",
            "127", "123", "143", "122"),
        mutableListOf("Hitunglah penjumlahan antara\n" + "bilangan 111 + 32 adalah...",
            "143", "133", "144", "145"),
        mutableListOf("Hitunglah pengurangan antara\n" + "bilangan 385 - 73 adalah...",
            "312", "311", "314", "315"),
        mutableListOf("Selisih dari bilangan 284 dan\n" + "83 adalah...",
            "201", "203", "204", "205"),
        mutableListOf("Hitunglah perkalian antara\n" + "bilangan 9 x 6 adalah...",
            "54", "46", "64", "56"),
        mutableListOf("Hitunglah pembagian antara\n" + "bilangan 24 : 6 adalah...",
            "4", "3", "6", "5"),
        mutableListOf("Tentukan hasil dari (2 + 4) x 5\n" + "adalah...",
            "30", "22", "24", "35"),
        mutableListOf("Tentukan bilangan berikut yang\n" + "merupakan bilangan ganjil...",
            "40", "36", "34", "35"),
        mutableListOf("Anis membeli 8 pensil di toko\n" + "alat tulis. Jika harga 1 pensil\n" + "Rp.2.300,00 maka berapa\n" + "banyak uang yang harus\n" + "dibayar oleh Anis...",
            "Rp.18.400,00", "Rp.19.400,00", "Rp.16.300,00", "Rp.15.600,00"),
        mutableListOf("Berapakah taksiran berat sesisir\n" + "pisang dengan berat sesisir\n" + "pisang adalah 3 kg lebih 6 ons...",
            "4 kg", "3 kg", "5 kg", "2 kg"),
        mutableListOf("Lisa belajar mulai pukul 09:05\n" + "sampai 10:32. Hasil taksiran\n" + "lama waktu belajar Lisa adalah...",
            "1 jam", "2 jam", "4 jam", "3 jam"),
        mutableListOf("Ana memiliki pita sepanjang 1 m\n" + "lebih 5 cm. Kemudian, pita tersebut\n" + "digunakan untuk membungkus\n" + "kado sepanjang 50 cm. Berapa\n" + "sisa pita yang dimiliki oleh Ana\n" + "sekarang...cm",
            "55", "43", "54", "45"),
        mutableListOf("Ibu membeli 2 kg tepung terigu di\n" + "pasar. Berapa gram tepung yang\n" + "dibeli ibu di pasar...",
            "2.000", "200", "20", "0,2"),
        mutableListOf("Hari ini adalah hari Sabtu.\n" + "Dua hari kemudian adalah\n" + "hari...",
            "Senin", "Selasa", "Minggu", "Jumat"),
        mutableListOf("Bulan ini adalah bulan Juli. Enam\n" + "bulan kemudian adalah bulan...",
            "Januari", "Desember", "Februari", "November"),
        mutableListOf("Jumlah sisi yang dimiliki bangun\n" + "persegi panjang adalah...",
            "4", "3", "6", "5"),
        mutableListOf("Jumlah sudut pada bangun\n" + "segitiga adalah...",
            "180 derajat", "360 derajat", "90 derajat", "270 derata"),
        mutableListOf("Banyak simetri putar pada bangun\n" + "persegi ada...",
            "4", "3", "2", "5"),
        mutableListOf("Besar sudut yang dibentuk oleh\n" + "kedua jarum jam pada pukul\n" + "02:00 adalah...",
            "60 derajat", "30 derajat", "90 derajat", "120 derajat"),
        mutableListOf("Diketahui luas bangun persegi\n" + "adalah 36 cm. Panjang setiap\n" + "sisi dari bangun persegi tersebut\n" + "adalah...cm",
            "6", "3", "4", "5"),
        mutableListOf("Sebuah persegi panjang dengan\n" + "panjang 5 m dan lebar 17 m. Luas\n" + "persegi panjang tersebut adalah...m",
            "85", "850", "80", "800"),
        mutableListOf("Keliling persegi panjang yang\n" + "memiliki panjang 700 cm dan\n" + "3 m yaitu...m",
            "20", "23", "21", "19")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamKelas3Binding.inflate(layoutInflater)
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
                val intent = Intent(this@ExamKelas3, ExamResultMinKelas3::class.java)
                intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount)
                startActivity(intent)
            }
            else{
                val intent = Intent(this@ExamKelas3, ExamResultKelas3::class.java)
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
        val skorKelas3 = rightAnswerCount.toString()

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