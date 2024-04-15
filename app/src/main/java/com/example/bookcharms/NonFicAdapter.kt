package com.example.bookcharms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NonFicAdapter(private val dataListNF: ArrayList<NonFicData>): RecyclerView.Adapter<NonFicAdapter.ViewHolderClassNF>() {
    var onItemClick: ((NonFicData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClassNF {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_nonfic, parent, false)
        return ViewHolderClassNF(itemView)
    }
    override fun onBindViewHolder(holder: ViewHolderClassNF, position: Int) {
        val currentItemNF = dataListNF[position]
        holder.rvImageNF.setImageResource(currentItemNF.dataImageNF)
        holder.rvTitleNF.text = currentItemNF.dataTitleNF
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItemNF)
        }
    }
    override fun getItemCount(): Int {
        return dataListNF.size
    }
    class ViewHolderClassNF(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImageNF:ImageView = itemView.findViewById(R.id.imageNonFic)
        val rvTitleNF:TextView = itemView.findViewById(R.id.titleNonFic)
    }
}