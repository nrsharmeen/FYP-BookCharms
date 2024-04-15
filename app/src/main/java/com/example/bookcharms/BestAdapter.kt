package com.example.bookcharms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BestAdapter(private val dataListB: ArrayList<BestData>): RecyclerView.Adapter<BestAdapter.ViewHolderClassB>() {
    var onItemClick: ((BestData) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClassB {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_best, parent, false)
        return ViewHolderClassB (itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderClassB, position: Int) {
        val currentItemB = dataListB[position]
        holder.rvImageB.setImageResource(currentItemB.dataImageB)
        holder.rvTitleB.text = currentItemB.dataTitleB
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(currentItemB)
        }
    }

    override fun getItemCount(): Int {
        return dataListB.size
    }

    class ViewHolderClassB(itemView: View): RecyclerView.ViewHolder(itemView) {
        val rvImageB: ImageView = itemView.findViewById(R.id.imageBest)
        val rvTitleB: TextView = itemView.findViewById(R.id.titleBest)
    }
}
