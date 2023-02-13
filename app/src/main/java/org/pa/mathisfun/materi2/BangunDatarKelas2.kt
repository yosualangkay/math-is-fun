package org.pa.mathisfun.materi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import org.pa.mathisfun.Materi
import org.pa.mathisfun.MyAdapter
import org.pa.mathisfun.R

class BangunDatarKelas2 : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var  materiRecyclerView: RecyclerView
    private lateinit var materiArrayList: ArrayList<Materi>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bangun_datar_kelas2)

        materiRecyclerView = findViewById(R.id.isiMateri)
        materiRecyclerView.layoutManager = LinearLayoutManager(this)
        materiRecyclerView.setHasFixedSize(true)

        materiArrayList = arrayListOf()
        getMateriData()

    }

    private fun getMateriData() {

        dbref = FirebaseDatabase.getInstance().getReference("BangunDatarKelas2")

        dbref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {
                    for (materiSnapshot in snapshot.children) {

                        val materi = materiSnapshot.getValue(Materi::class.java)
                        materiArrayList.add(materi!!)
                    }

                    materiRecyclerView.adapter = MyAdapter(materiArrayList)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}