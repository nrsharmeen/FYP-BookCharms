// MalayPage.kt
package com.example.bookcharms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MalayPage : AppCompatActivity() {
    private lateinit var recyclerViewM: RecyclerView
    private lateinit var dataListM: ArrayList<MalayData>
    lateinit var imageListM: Array<Int>
    lateinit var titleListM: Array<String>
    lateinit var descListM: Array<String>
    lateinit var detailImageListM: Array<Int>
    private lateinit var myAdapterM: MalayAdapter
    private lateinit var searchViewM: SearchView
    private lateinit var searchListM: ArrayList<MalayData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_malay_page)
        imageListM = arrayOf(
            R.drawable.bukuliterasi,
            R.drawable.asastekno,
            R.drawable.seeyouat,
            R.drawable.hikayat,
            R.drawable.minimalis,
            R.drawable.seni,
            R.drawable.asrama,
            R.drawable.adamhawa,
            R.drawable.suamiku
        )
        titleListM = arrayOf(
            "Buku Literasi Undang-Undang Untukmu Guru oleh Dato' Hazizah Kassim",
            "Asas Teknologi Elektrik oleh Azrul Bin Mahfurdz",
            "See You At The Top - Edisi Bahasa Melayu oleh Zig Ziglar",
            "Hikayat Alam Melayu by Awan Wafdan",
            "Minimalis oleh Faridah Ghazali",
            "Seni Berfikir Yang Hilang oleh Hasrizal Abdul Jamil",
            "Asrama oleh Muhammad Fatrim",
            "Adam dan Hawa oleh Aisya Sofea",
            "Suamiku Paling Sweet oleh Anjell",
        )
        descListM = arrayOf(
            getString(R.string.literasi),
            getString(R.string.asas),
            getString(R.string.seeyou),
            getString(R.string.hikayat),
            getString(R.string.minimalis),
            getString(R.string.seni),
            getString(R.string.asramas),
            getString(R.string.adamhawas),
            getString(R.string.suamikus)
        )
        detailImageListM = arrayOf(
            R.drawable.bukuliterasi,
            R.drawable.asastekno,
            R.drawable.seeyouat,
            R.drawable.hikayat,
            R.drawable.minimalis,
            R.drawable.seni,
            R.drawable.asrama,
            R.drawable.adamhawa,
            R.drawable.suamiku
        )

        recyclerViewM = findViewById(R.id.recyclerViewMal)
        searchViewM = findViewById(R.id.searchMalay)
        recyclerViewM.layoutManager = LinearLayoutManager(this)
        recyclerViewM.setHasFixedSize(true)
        dataListM = arrayListOf()
        searchListM = arrayListOf()
        getData()
        searchViewM.clearFocus()
        searchViewM.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchViewM.clearFocus()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                searchListM.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()) {
                    dataListM.forEach {
                        if (it.dataTitleM.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            searchListM.add(it)
                        }
                    }
                    recyclerViewM.adapter!!.notifyDataSetChanged()
                } else {
                    searchListM.clear()
                    searchListM.addAll(dataListM)
                    recyclerViewM.adapter!!.notifyDataSetChanged()
                }
                return false
            }
        })
        myAdapterM = MalayAdapter(searchListM)
        recyclerViewM.adapter = myAdapterM
        myAdapterM.onItemClick = {
            val intent = Intent(this, MalayDetails::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }
    }

    private fun getData() {
        for (i in imageListM.indices) {
            val dataClass = MalayData(imageListM[i], titleListM[i], descListM[i], detailImageListM[i])
            dataListM.add(dataClass)
        }
        searchListM.addAll(dataListM)
        recyclerViewM.adapter = MalayAdapter(searchListM)
    }
}



