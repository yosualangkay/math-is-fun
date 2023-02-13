package org.pa.mathisfun


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MateriAdapter(
    materiList: MutableList<String>,
    private val listener: (String) -> Unit
): RecyclerView.Adapter<MateriAdapter.ViewHolder>() {

    private var materi : MutableList<String> =  materiList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return  ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemMateri.text = materi[position]
        holder.itemMateri.setOnClickListener {
            listener(materi[position])
        }


    }

    override fun getItemCount(): Int {
        return materi.size
    }

    inner class ViewHolder (itemView:View): RecyclerView.ViewHolder(itemView){
        var itemMateri : TextView

        init{
            itemMateri = itemView.findViewById(R.id.namaMateri)

            itemView.setOnClickListener{
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "Diklik ${materi[position]}", Toast.LENGTH_LONG).show()
//                var i = Intent(context, MateriActivity::class.java)
//                context.startActivity(i)
            }
        }


    }
}

//holder.itemView.setOnClickListener{
//    if (data[position] == "Bilangan Cacah")
//        Toast.makeText(holder.itemView.context, "Bilangan Cacah", Toast.LENGTH_SHORT).show()
//    if (data[position] == "Bangun Datar")
//        Toast.makeText(holder.itemView.context, "Bangun Datar", Toast.LENGTH_SHORT).show()
//}