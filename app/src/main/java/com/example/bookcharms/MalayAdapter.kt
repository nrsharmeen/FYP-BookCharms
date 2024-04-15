package com.example.bookcharms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MalayAdapter(private val dataListM: ArrayList<MalayData>): RecyclerView.Adapter<MalayAdapter.ViewHolderClassM>() {
    var onItemClick: ((MalayData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClassM {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_malay, parent, false)
        return ViewHolderClassM (itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClassM, position: Int) {
        val currentItemM = dataListM[position]
        holder.rvImageM.setImageResource(currentItemM.dataImageM)
        holder.rvTitleM.text = currentItemM.dataTitleM
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItemM)
        }
    }

    override fun getItemCount(): Int {
        return dataListM.size
    }

    class ViewHolderClassM(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImageM: ImageView = itemView.findViewById(R.id.imageMalay)
        val rvTitleM: TextView = itemView.findViewById(R.id.titleMalay)
    }
}
