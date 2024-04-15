// FictionPage.kt
package com.example.bookcharms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class FictionPage : AppCompatActivity() {
    private lateinit var recyclerViewF: RecyclerView
    private lateinit var dataListF: ArrayList<FicData>
    lateinit var imageListF: Array<Int>
    lateinit var titleListF: Array<String>
    lateinit var descListF: Array<String>
    lateinit var detailImageListF: Array<Int>
    private lateinit var myAdapterF: FicAdapter
    private lateinit var searchViewF: SearchView
    private lateinit var searchListF: ArrayList<FicData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fiction_page)
        imageListF = arrayOf(
            R.drawable.suamiku,
            R.drawable.asrama,
            R.drawable.adamhawa,
            R.drawable.crawdad,
            R.drawable.itendswu,
            R.drawable.station
        )
        titleListF = arrayOf(
            "Suamiku Paling Sweet oleh Anjell",
            "Asrama oleh Muhammad Fatrim",
            "Adam dan Hawa oleh Aisya Sofea",
            "Where the Crawdads Sing by Delia Owens",
            "It Ends with Us by Colleen Hoover",
            "Station Eleven by Emily St. John Mandel"
        )
        descListF = arrayOf(
            getString(R.string.asrama),
            getString(R.string.adamhawa),
            getString(R.string.suamiku),
            getString(R.string.itsendwu),
            getString(R.string.crawdad),
            getString(R.string.station)
        )
        detailImageListF = arrayOf(
            R.drawable.suamiku,
            R.drawable.asrama,
            R.drawable.adamhawa,
            R.drawable.crawdad,
            R.drawable.itendswu,
            R.drawable.station
        )

        recyclerViewF = findViewById(R.id.recyclerViewfic)
        searchViewF = findViewById(R.id.searchFic)
        recyclerViewF.layoutManager = LinearLayoutManager(this)
        recyclerViewF.setHasFixedSize(true)
        dataListF = arrayListOf()
        searchListF = arrayListOf()
        getData()
        searchViewF.clearFocus()
        searchViewF.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchViewF.clearFocus()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                searchListF.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()) {
                    dataListF.forEach {
                        if (it.dataTitleF.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            searchListF.add(it)
                        }
                    }
                    recyclerViewF.adapter!!.notifyDataSetChanged()
                } else {
                    searchListF.clear()
                    searchListF.addAll(dataListF)
                    recyclerViewF.adapter!!.notifyDataSetChanged()
                }
                return false
            }
        })
        myAdapterF = FicAdapter(searchListF)
        recyclerViewF.adapter = myAdapterF
        myAdapterF.onItemClick = {
            val intent = Intent(this, FicDetails::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }
    }

    private fun getData() {
        for (i in imageListF.indices) {
            val dataClass = FicData(imageListF[i], titleListF[i], descListF[i], detailImageListF[i])
            dataListF.add(dataClass)
        }
        searchListF.addAll(dataListF)
        recyclerViewF.adapter = FicAdapter(searchListF)
    }
}
