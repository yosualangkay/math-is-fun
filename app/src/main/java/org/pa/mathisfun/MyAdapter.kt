package org.pa.mathisfun

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val isiList : ArrayList<Materi>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.isi_materi, parent, false)
        return  MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = isiList[position]

        holder.judulMateri.text = currentitem.judul
        holder.sub1.text = currentitem.sub1
        holder.sub2.text = currentitem.sub2
        holder.sub3.text = currentitem.sub3
        holder.sub4.text = currentitem.sub4
        holder.penjelasan1.text = currentitem.penjelasan1
        holder.penjelasan2.text = currentitem.penjelasan2
        holder.penjelasan3.text = currentitem.penjelasan3
        holder.penjelasan4.text = currentitem.penjelasan4
        holder.contohSub1.text = currentitem.contohSub1
        holder.contohSub2.text = currentitem.contohSub2
        holder.contohSub3.text = currentitem.contohSub3
        holder.contohSub4.text = currentitem.contohSub4

    }

    override fun getItemCount(): Int {
        return isiList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val judulMateri : TextView = itemView.findViewById(R.id.tvJudulMateri)
        val sub1 : TextView = itemView.findViewById(R.id.tvSub1)
        val sub2 : TextView = itemView.findViewById(R.id.tvSub2)
        val sub3 : TextView = itemView.findViewById(R.id.tvSub3)
        val sub4 : TextView = itemView.findViewById(R.id.tvSub4)
        val penjelasan1 : TextView = itemView.findViewById(R.id.tvPenjelasan1)
        val penjelasan2 : TextView = itemView.findViewById(R.id.tvPenjelasan2)
        val penjelasan3 : TextView = itemView.findViewById(R.id.tvPenjelasan3)
        val penjelasan4 : TextView = itemView.findViewById(R.id.tvPenjelasan4)
        val contohSub1 : TextView = itemView.findViewById(R.id.tvContohSub1)
        val contohSub2 : TextView = itemView.findViewById(R.id.tvContohSub2)
        val contohSub3 : TextView = itemView.findViewById(R.id.tvContohSub3)
        val contohSub4 : TextView = itemView.findViewById(R.id.tvContohSub4)


    }
}