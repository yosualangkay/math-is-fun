package org.pa.mathisfun.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.database.FirebaseDatabase
import org.pa.mathisfun.R
import org.pa.mathisfun.Saran
import org.pa.mathisfun.menu.Notification.Companion.CHANNEL1

class HalamanSaran : AppCompatActivity(), View.OnClickListener {

    private lateinit var etNama : EditText
    private lateinit var etKelas : EditText
    private lateinit var btnKirim : Button
    private lateinit var etAsal : EditText
    private lateinit var etSaran : EditText

    private lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_saran)

        val actionbar = supportActionBar
        actionbar!!.title="Saran Materi"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        notificationManager = NotificationManagerCompat.from(this)

        etNama = findViewById(R.id.etNama)
        etKelas = findViewById(R.id.etKelas)
        btnKirim = findViewById(R.id.btnKirim)
        etAsal = findViewById(R.id.etSekolah)
        etSaran = findViewById(R.id.etMateri)

        btnKirim = findViewById(R.id.btnKirim)

        btnKirim.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        saveData()
    }

    private fun saveData(){
        val nama = etNama.text.toString().trim()
        val kelas = etKelas.text.toString().trim()
        val asal = etAsal.text.toString().trim()
        val saran = etSaran.text.toString().trim()

        if(nama.isEmpty()){
            etNama.error = "Nama Tidak Boleh Kosong"
            return
        }
        if(kelas.isEmpty()){
            etKelas.error = "Kelas Tidak Boleh Kosong"
            return
        }
        if(asal.isEmpty()){
            etKelas.error = "Asal Sekolah Tidak Boleh Kosong"
            return
        }
        if(saran.isEmpty()){
            etSaran.error = "Saran Tidak Boleh Kosong"
            return
        }

        val judulNotif = "Saran Materi"
        val pesanNotif = "Saran kamu terkirim"
        val builder = NotificationCompat.Builder(this, Notification.CHANNEL1)
            .setSmallIcon(R.drawable.mif)
            .setContentTitle(judulNotif)
            .setContentText(pesanNotif)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_MESSAGE)

        val notif = builder.build()
        notificationManager.notify(1, notif)



        val ref = FirebaseDatabase.getInstance().getReference("Saran")

        val materiId = ref.push().key

        val mtr = Saran(materiId,nama,kelas,asal,saran)

        if(materiId != null){
            ref.child(materiId).setValue(mtr).addOnCompleteListener{
                AlertDialog.Builder(this)
                    .setMessage("Terima kasih telah memberikan saran. Saran kamu akan segera kami proses")
                    .setPositiveButton("OK") {dialogInterface, i -> startActivity(Intent(this, MainActivity::class.java))}
                    .setCancelable(false).show()
            }
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}