// EngPage.kt
package com.example.bookcharms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class EnglishPage : AppCompatActivity() {
    private lateinit var recyclerViewE: RecyclerView
    private lateinit var dataListE: ArrayList<EngData>
    lateinit var imageListE: Array<Int>
    lateinit var titleListE: Array<String>
    lateinit var descListE: Array<String>
    lateinit var detailImageListE: Array<Int>
    private lateinit var myAdapterE: EngAdapter
    private lateinit var searchViewE: SearchView
    private lateinit var searchListE: ArrayList<EngData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_english_page)
        imageListE = arrayOf(
            R.drawable.educated,
            R.drawable.foundations,
            R.drawable.teacherman,
            R.drawable.subtle,
            R.drawable.sapiens,
            R.drawable.crawdad,
            R.drawable.itendswu,
            R.drawable.station
        )
        titleListE = arrayOf(
            "Educated by Tara Westover",
            "Foundations of Educational Research by Victoria Elliot",
            "Teacher Man by Frank McCourt",
            "The Subtle Art of Not Giving a Fck by  Mark Manson",
            "Sapiens by Yuval Noah Harari",
            "Where the Crawdads Sing by Delia Owens",
            "It Ends with Us by Colleen Hoover",
            "Station Eleven by Emily St. John Mandel"
        )
        descListE = arrayOf(
            getString(R.string.educate),
            getString(R.string.foundation),
            getString(R.string.teacherma),
            getString(R.string.subtl),
            getString(R.string.sapien),
            getString(R.string.crawda),
            getString(R.string.itendsw),
            getString(R.string.statio)
        )
        detailImageListE = arrayOf(
            R.drawable.educated,
            R.drawable.foundations,
            R.drawable.teacherman,
            R.drawable.subtle,
            R.drawable.sapiens,
            R.drawable.crawdad,
            R.drawable.itendswu,
            R.drawable.station
        )

        recyclerViewE = findViewById(R.id.recyclerViewEng)
        searchViewE = findViewById(R.id.searchEnglish)
        recyclerViewE.layoutManager = LinearLayoutManager(this)
        recyclerViewE.setHasFixedSize(true)
        dataListE = arrayListOf()
        searchListE = arrayListOf()
        getData()
        searchViewE.clearFocus()
        searchViewE.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchViewE.clearFocus()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                searchListE.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()) {
                    dataListE.forEach {
                        if (it.dataTitleE.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            searchListE.add(it)
                        }
                    }
                    recyclerViewE.adapter!!.notifyDataSetChanged()
                } else {
                    searchListE.clear()
                    searchListE.addAll(dataListE)
                    recyclerViewE.adapter!!.notifyDataSetChanged()
                }
                return false
            }
        })
        myAdapterE = EngAdapter(searchListE)
        recyclerViewE.adapter = myAdapterE
        myAdapterE.onItemClick = {
            val intent = Intent(this, EngDetails::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }
    }

    private fun getData() {
        for (i in imageListE.indices) {
            val dataClass = EngData(imageListE[i], titleListE[i], descListE[i], detailImageListE[i])
            dataListE.add(dataClass)
        }
        searchListE.addAll(dataListE)
    }
}




