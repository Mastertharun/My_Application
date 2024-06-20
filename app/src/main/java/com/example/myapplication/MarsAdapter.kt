package com.example.myapplication


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.myapplication.network.MarsPhoto

class MarsAdapter(var listMarsPhotos: List<MarsPhoto>) :RecyclerView.Adapter<MarsAdapter.MarsViewHolder>() {

    class MarsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var TextView:TextView = itemView.findViewById(android.R.id.text1)
        var textView:TextView = itemView.findViewById(R.id.tvUrl)
        var marsImageView:ImageView = itemView.findViewById(R.id.ivPhoto)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        var rowdescription = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1,parent,false)
        var rowPlank = LayoutInflater.from(parent.context).inflate(R.layout.row_layout_item,parent,false)
        return  MarsViewHolder(rowPlank)
    }

    override fun getItemCount(): Int {
        return listMarsPhotos.size
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        holder.textView.setText(listMarsPhotos.get(position).imgSrc)

        var url:String = listMarsPhotos.get(position).imgSrc
        holder.textView.setText(url)
        holder.marsImageView.load(url)
    }
}