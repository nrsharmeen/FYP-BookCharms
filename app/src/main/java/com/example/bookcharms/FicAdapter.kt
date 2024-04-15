package com.example.bookcharms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FicAdapter(private val dataListF: ArrayList<FicData>): RecyclerView.Adapter<FicAdapter.ViewHolderClassF>() {
    var onItemClick: ((FicData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClassF {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_fic, parent, false)
        return ViewHolderClassF(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolderClassF, position: Int) {
        val currentItemF = dataListF[position]
        holder.rvImageF.setImageResource(currentItemF.dataImageF)
        holder.rvTitleF.text = currentItemF.dataTitleF
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItemF)
        }
    }
    override fun getItemCount(): Int {
        return dataListF.size
    }
    class ViewHolderClassF(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImageF:ImageView = itemView.findViewById(R.id.imageFic)
        val rvTitleF:TextView = itemView.findViewById(R.id.titleFic)
    }
}