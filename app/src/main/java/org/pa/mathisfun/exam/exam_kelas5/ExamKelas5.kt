package org.pa.mathisfun.exam.exam_kelas5

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
import org.pa.mathisfun.databinding.ActivityExamKelas5Binding
import org.pa.mathisfun.exam.exam_kelas4.ExamResultKelas4
import org.pa.mathisfun.exam.exam_kelas4.ExamResultMinKelas4

class ExamKelas5 : AppCompatActivity() {

    private lateinit var binding: ActivityExamKelas5Binding

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
        mutableListOf("Hasil dari 1/6 + 3/4 ...",
            "11\n" + "-\n" + "12", "9\n" + "-\n" + "12", "4\n" + "-\n" + "10", "12\n" + "-\n" + "12"),
        mutableListOf("Berapakah hasil pengurangan\n" + "dari 5/6 - 2/9 ...",
            "11\n" + "-\n" + "18", "4\n" + "-\n" + "3", "9\n" + "-\n" + "24", "12\n" + "-\n" + "18"),
        mutableListOf("Ubahlah pecahan campuran dari\n" + "10 3/9 menjadi pecahan biasa...",
            "31\n" + "-\n" + "3", "90\n" + "-\n" + "9", "31\n" + "-\n" + "9", "30\n" + "-\n" + "3"),
        mutableListOf("Hasil penjumlahan dari\n" + "4  5/6 + 2  3/4...",
            "6  19/12", "7  19/12", "5  12/6", "3  18/20"),
        mutableListOf("Hasil pengurangan dari\n" + "4  1/2 - 1  1/3...",
            "3  1/6", "2  1/3", "1  2/4", "3  2/6"),
        mutableListOf("Berapakah hasil dari 4 + 2  3/4...",
            "6  3/4", "5  3/4", "4  4/3", "6  2/4"),
        mutableListOf("Ani ingin membuat sebuah baju.\n" + "Ia membutuhkan kain sepanjang\n" + "2  1/3 meter. Sedangkan untuk\n" + "membuat rok Ani membutuhkan\n" + "3  4/6 meter. Jika ani ingin\n" + "membuat 3 buah baju dan 2 buah\n" + "rok, berapakah panjang kain yang\n" + "diperlukan Ani..",
            "14  1/3", "11  2/4", "7  5/4", "13  4/2"),
        mutableListOf("Hitunglah perkalian dari 3/5 × 2/4...",
            "6\n" + "-\n" + "20", "6\n" + "-\n" + "9", "3\n" + "-\n" + "9", "5\n" + "-\n" + "8"),
        mutableListOf("Hitunglah perkalian dari 4 × 7/6...",
            "4  4/6", "3  4/5", "6  2/3", "2  3/4"),
        mutableListOf("Hitunglah perkalian dari 1  7/5 × 6 ...",
            "14  2/5", "12  2/5", "14  5/2", "13  4/5"),
        mutableListOf("Ayu ingin membuat donat. Setiap\n" + "adonan membutuhkan 1/5 kg\n" + "tepung. Persediaan tepung di\n" + "rumah Ayu 3 4/5. Berapa banyak\n" + "adonan yang dapat dibuat Ayu...",
            "19", "15", "20", "12"),
        mutableListOf("Rani akan membuat popcorn\n" + "sebanyak 3,5 kg. Untuk membuat\n" + "popcorn sebanyak itu Rani\n" + "membutuhkan 2,3 kg mentega.\n" + "Tetapi persediaan mentega di\n" + "rumah Rani tersisa 1,4 kg.\n" + "Berapakah sisa mentega yang\n" + "dibutuhkan Rani...",
            "0,9", "0,8", "1,2", "1,3"),
        mutableListOf("Rina sedang menunggu antrian\n" + "untuk konsultasi dengan dokter.\n" + "Saat ini menunjukkan pukul\n" + "09.13. Kemungkinan Rina\n" + "akan dipanggil sekitar 34 menit\n" + "lagi. Pukul berapakah Rina akan\n" + "dipanggil...",
            "09.47", "09.45", "09.50", "09.48"),
        mutableListOf("Ali pergi dari kota A ke kota B\n" + "menggunakan bis dengan\n" + "menempuh jarak 347 km.\n" + "Kemudian Ali harus mengendarai\n" + "motor untuk mencapai rumahnya\n" + "di kota B dengan menempuh jarak\n" + "4,7 km. Berapakah jarak yang\n" + "ditempuh Ali dari kota A menuju\n" + "rumah di kota B...",
            "351,7", "355,7", "345,2", "354,6"),
        mutableListOf("Sebuah mobil melaju dari kota A\n" + "menuju kota B selama 3 jam.\n" + "Mobil tersebut melaju dengan\n" + "kecepatan 80 kilometer per jam.\n" + "Berapakah jarak yang ditempuh\n" + "mobil tersebut dari kota A menuju\n" + "kota B...",
            "240", "250", "200", "180"),
        mutableListOf("Ibu berjalan kaki menuju pasar\n" + "dengan kecepatan 2km/jam.\n" + "Jarak dari rumah ibu ke pasar\n" + "adalah 4km. Berapa lama ibu\n" + "berjalan dari rumah ke pasar...",
            "2", "3", "1", "4"),
        mutableListOf("Adit mengisi air di ember dengan\n" + "volume 20 liter selama 1 menit\n" + "20 detik. Tentukan debit kran\n" + "dalam liter per detik...",
            "0,25 liter/detik", "2,5 liter/detik", "0,02 liter/detik", "25 liter/detik"),
        mutableListOf("Beni mengisi botol minum selama\n" + "10 detik. Debit air dispenser 80 ml\n" + "per detik. Berapa liter volume air\n" + "dalam botol tersebut...",
            "800", "90", "8", "100"),
        mutableListOf("Andi mempunyai kolam renang\n" + "dengan volume 1500 liter. Debit\n" + "air selang untuk mengisi kolam\n" + "adalah 300 liter/menit. Berapakah\n" + "waktu yang diperlukan untuk\n" + "mengisi kolam tersebut...",
            "5", "4.500", "6", "1.200"),
        mutableListOf("Edi dan Toni ingin bermain kelereng.\n" + "Edi mempunyai 24 kelereng,\n" + "sedangkan Toni mempunyai 36\n" + "kelereng. Berapakah perbandingan\n" + "kelereng yang mereka punya...",
            "2 : 3", "3 : 7", "4 : 5", "1 : 3"),
        mutableListOf("Perbandingan umur Bayu dan\n" + "ayah adalah 2:5. Dimana umur\n" + "bayu sekarang adalah 16 tahun.\n" + "Berapakah umur ayah saat ini...",
            "40", "43", "35", "25"),
        mutableListOf("Jarak dua kota sebenarnya adalah\n" + "40 km. Sedangkan jarak pada peta\n" + "adalah 15 cm. Berapakah skala\n" + "peta tersebut...",
            "3 : 8", "8 : 3", "2 : 3", "3 : 2"),
        mutableListOf("Jarak rumah Doni ke sekolah pada\n" + "peta adalah 12 cm. Peta tersebut\n" + "menggunakan skala 2:5. Berapakah\n" + "jarak sebenarnya dari rumah Doni\n" + "ke sekolah...",
            "30", "20", "25", "35"),
        mutableListOf("Jarak dari rumah Tina ke rumah\n" + "Roni adalah 5km. Pada peta\n" + "menggunakan skala 1:10.\n" + "Berapakah jarak rumah mereka\n" + "pada peta...",
            "0,5", "1,0", "1,2", "2"),
        mutableListOf("Berapa banyak rusuk pada balok...",
            "12", "6", "8", "4"),
        mutableListOf("Tabung memiliki sisi sebanyak...",
            "3", "2", "4", "1"),
        mutableListOf("Pada sebuah akuarium dapat diisi\n" + "dengan kardus kecil berbentuk\n" + "kubus. Panjang akuarium dapat\n" + "diisi 5 kubus, lebar dapat diisi 3\n" + "kubus, tinggi dapat diisi 4 kubus.\n" + "Berapa banyak kubus yang dapat\n" + "diisi ke dalam akuarium tersebut...",
            "60", "30", "50", "40"),
        mutableListOf("Aldo membeli cokelat berbentuk\n" + "prisma segitiga dengan tinggi\n" + "30 cm dan luas alasnya 15/2.\n" + "Berapakah volume cokelat tersebut...",
            "225", "30", "125", "50"),
        mutableListOf("Dani membeli sarden pada\n" + "minimarket. Kaleng sarden\n" + "tersebut berbentuk tabung\n" + "dengan volume kaleng 2.310 cm³\n" + "dan diameter 14 cm. Berapakah\n" + "tinggi kaleng tersebut...",
            "15", "20", "10", "13"),
        mutableListOf("Pada miniatur piramida alasnya\n" + "berbentuk persegi dengan panjang\n" + "sisi 12 cm dan tinggi 15 cm.\n" + "Berapakah volume miniatur\n" + "piramida tersebut...",
            "720", "39", "730", "40"),
        mutableListOf("Di kelas 4 telah dilaksanakan ujian\n" + "harian dan telah muncul hasil\n" + "ujiannya. Berikut adalah nilai dari\n" + "ujian hariannya. 79 80 78 88 85 84\n" + "89 79 76 69 70 80 98 93 73 90 86\n" + "85 83 95. Berapakah nilai tertinggi\n" + "yang diperoleh kelas tersebut...",
            "98", "99", "95", "93"),
        mutableListOf("Di kelas 4 telah dilaksanakan ujian\n" + "harian dan telah muncul hasil\n" + "ujiannya. Berikut adalah nilai dari\n" + "ujian hariannya. 79 80 78 88 85 84\n" + "89 79 76 69 70 80 98 93 73 90 86\n" + "85 83 95. Berapakah nilai terendah\n" + "yang diperoleh kelas tersebut...",
            "69", "63", "70", "73")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExamKelas5Binding.inflate(layoutInflater)
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
                val intent = Intent(this@ExamKelas5, ExamResultMinKelas5::class.java)
                intent.putExtra("RIGHT_ANSWER_COUNT", rightAnswerCount)
                startActivity(intent)
            }
            else{
                val intent = Intent(this@ExamKelas5, ExamResultKelas5::class.java)
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
        val skorKelas5 = rightAnswerCount.toString()

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