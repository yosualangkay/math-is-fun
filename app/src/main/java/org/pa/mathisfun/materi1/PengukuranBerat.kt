package org.pa.mathisfun.materi1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import org.pa.mathisfun.Materi
import org.pa.mathisfun.MyAdapter
import org.pa.mathisfun.R

class PengukuranBerat : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var  materiRecyclerView: RecyclerView
    private lateinit var materiArrayList: ArrayList<Materi>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pengukuran_berat)

        materiRecyclerView = findViewById(R.id.isiMateri)
        materiRecyclerView.layoutManager = LinearLayoutManager(this)
        materiRecyclerView.setHasFixedSize(true)

        materiArrayList = arrayListOf()
        getMateriData()

    }

    private fun getMateriData() {

        dbref = FirebaseDatabase.getInstance().getReference("PengukuranBerat")

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