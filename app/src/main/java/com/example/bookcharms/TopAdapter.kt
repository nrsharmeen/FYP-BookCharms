package com.example.bookcharms

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class TopAdapter(private var topList: List<TopData>) :
    RecyclerView.Adapter<TopAdapter.TopViewHolder>() {

    inner class TopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val logo: ImageView = itemView.findViewById(R.id.logoIvtop)
        val titleTv: TextView = itemView.findViewById(R.id.titleTvtop)
        val langDescTv: TextView = itemView.findViewById(R.id.langDesctop)
        val constraintLayout: ConstraintLayout = itemView.findViewById(R.id.constraintLayouttop)

        fun collapseExpandedView(){
            langDescTv.visibility = View.GONE
        }
    }

    fun setFilteredList(topList: List<TopData>) {
        this.topList = topList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_top, parent, false)
        return TopViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopViewHolder, position: Int) {

        val topData = topList[position]
        holder.logo.setImageResource(topData.logo)
        holder.titleTv.text = topData.title
        holder.langDescTv.text = topData.desc

        val isExpandable: Boolean = topData.isExpandable
        holder.langDescTv.visibility = if (isExpandable) View.VISIBLE else View.GONE

        holder.constraintLayout.setOnClickListener {
            isAnyItemExpanded(position)
            topData.isExpandable = !topData.isExpandable
            notifyItemChanged(position , Unit)
        }

    }

    private fun isAnyItemExpanded(position: Int){
        val temp = topList.indexOfFirst {
            it.isExpandable
        }
        if (temp >= 0 && temp != position){
            topList[temp].isExpandable = false
            notifyItemChanged(temp , 0)
        }
    }

    override fun onBindViewHolder(
        holder: TopViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {

        if(payloads.isNotEmpty() && payloads[0] == 0){
            holder.collapseExpandedView()
        }else{
            super.onBindViewHolder(holder, position, payloads)

        }
    }

    override fun getItemCount(): Int {
        return topList.size
    }
}