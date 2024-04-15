package com.example.bookcharms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EngAdapter(private val dataListE: ArrayList<EngData>): RecyclerView.Adapter<EngAdapter.ViewHolderClassE>() {
    var onItemClick: ((EngData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClassE {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_eng, parent, false)
        return ViewHolderClassE (itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClassE, position: Int) {
        val currentItemE = dataListE[position]
        holder.rvImageE.setImageResource(currentItemE.dataImageE)
        holder.rvTitleE.text = currentItemE.dataTitleE
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItemE)
        }
    }

    override fun getItemCount(): Int {
        return dataListE.size
    }

    class ViewHolderClassE(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImageE: ImageView = itemView.findViewById(R.id.imageEng)
        val rvTitleE: TextView = itemView.findViewById(R.id.titleEng)
    }
}
