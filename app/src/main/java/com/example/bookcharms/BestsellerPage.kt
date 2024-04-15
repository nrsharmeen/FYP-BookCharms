//BestPage.kt
package com.example.bookcharms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class BestsellerPage : AppCompatActivity() {
    private lateinit var recyclerViewB: RecyclerView
    private lateinit var dataListB: ArrayList<BestData>
    lateinit var imageListB: Array<Int>
    lateinit var titleListB: Array<String>
    lateinit var descListB: Array<String>
    lateinit var detailImageListB: Array<Int>
    private lateinit var myAdapterB: BestAdapter
    private lateinit var searchViewB: SearchView
    private lateinit var searchListB: ArrayList<BestData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bestseller_page)
        imageListB = arrayOf(
            R.drawable.suamiku,
            R.drawable.asrama,
            R.drawable.hikayat,
            R.drawable.itendswu,
            R.drawable.crawdad,
            R.drawable.split,
            R.drawable.station,
        )
        titleListB = arrayOf(
            "Suamiku Paling Sweet oleh Anjell",
            "Asrama oleh Muhammad Fatrim",
            "Hikayat Alam Melayu by Awan Wafdan",
            "It Ends with Us by Colleen Hoover",
            "Where the Crawdads Sing by Delia Owens",
            "Split oleh Nurul Ain Syuhadah",
            "Station Eleven by Emily St. John Mandel"
        )
        descListB = arrayOf(
            getString(R.string.suamikut),
            getString(R.string.asramat),
            getString(R.string.hikayatt),
            getString(R.string.itendswut),
            getString(R.string.crawdadt),
            getString(R.string.split),
            getString(R.string.stationt)
        )
        detailImageListB = arrayOf(
            R.drawable.suamiku,
            R.drawable.asrama,
            R.drawable.hikayat,
            R.drawable.itendswu,
            R.drawable.crawdad,
            R.drawable.split,
            R.drawable.station,
        )

        recyclerViewB = findViewById(R.id.recyclerViewBest)
        searchViewB = findViewById(R.id.searchBest)
        recyclerViewB.layoutManager = LinearLayoutManager(this)
        recyclerViewB.setHasFixedSize(true)
        dataListB = arrayListOf()
        searchListB = arrayListOf()
        getData()
        searchViewB.clearFocus()
        searchViewB.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchViewB.clearFocus()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                searchListB.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()) {
                    dataListB.forEach {
                        if (it.dataTitleB.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            searchListB.add(it)
                        }
                    }
                    recyclerViewB.adapter!!.notifyDataSetChanged()
                } else {
                    searchListB.clear()
                    searchListB.addAll(dataListB)
                    recyclerViewB.adapter!!.notifyDataSetChanged()
                }
                return false
            }
        })
        myAdapterB = BestAdapter(searchListB)
        recyclerViewB.adapter = myAdapterB
        myAdapterB.onItemClick = {
            val intent = Intent(this, BestDetails::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }
    }

    private fun getData() {
        for (i in imageListB.indices) {
            val dataClass = BestData(imageListB[i], titleListB[i], descListB[i], detailImageListB[i])
            dataListB.add(dataClass)
        }
        searchListB.addAll(dataListB)
        recyclerViewB.adapter = BestAdapter(searchListB)
    }
}



