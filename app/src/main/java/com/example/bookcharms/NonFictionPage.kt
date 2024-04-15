package com.example.bookcharms

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class NonFictionPage : AppCompatActivity() {
    private lateinit var recyclerViewNF: RecyclerView
    private lateinit var dataListNF: ArrayList<NonFicData>
    lateinit var imageListNF:Array<Int>
    lateinit var titleListNF:Array<String>
    lateinit var descListNF: Array<String>
    lateinit var detailImageListNF: Array<Int>
    private lateinit var myAdapterNF: NonFicAdapter
    private lateinit var searchViewNF: SearchView
    private lateinit var searchListNF: ArrayList<NonFicData>
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_non_fiction_page)
        imageListNF = arrayOf(
            R.drawable.hikayat,
            R.drawable.minimalis,
            R.drawable.seni,
            R.drawable.subtle,
            R.drawable.sapiens)
        titleListNF = arrayOf(
            "Hikayat Alam Melayu by Awan Wafdan",
            "Minimalis oleh Faridah Ghazali",
            "Seni Berfikir Yang Hilang oleh Hasrizal Abdul Jamil",
            "The Subtle Art of Not Giving a Fck by  Mark Manson",
            "Sapiens by Yuval Noah Harari")
        descListNF = arrayOf(
            getString(R.string.hikayat),
            getString(R.string.minimalis),
            getString(R.string.seni),
            getString(R.string.subtle),
            getString(R.string.sapiens))
        detailImageListNF = arrayOf(
            R.drawable.hikayat,
            R.drawable.minimalis,
            R.drawable.seni,
            R.drawable.subtle,
            R.drawable.sapiens)

        recyclerViewNF = findViewById(R.id.recyclerViewnonfic)
        searchViewNF = findViewById(R.id.searchNonfic)
        recyclerViewNF.layoutManager = LinearLayoutManager(this)
        recyclerViewNF.setHasFixedSize(true)
        dataListNF = arrayListOf<NonFicData>()
        searchListNF = arrayListOf<NonFicData>()
        getData()
        searchViewNF.clearFocus()
        searchViewNF.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchViewNF.clearFocus()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                searchListNF.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    dataListNF.forEach{
                        if (it.dataTitleNF.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            searchListNF.add(it)
                        }
                    }
                    recyclerViewNF.adapter!!.notifyDataSetChanged()
                } else {
                    searchListNF.clear()
                    searchListNF.addAll(dataListNF)
                    recyclerViewNF.adapter!!.notifyDataSetChanged()
                }
                return false
            }
        })
        myAdapterNF = NonFicAdapter(searchListNF)
        recyclerViewNF.adapter = myAdapterNF
        myAdapterNF.onItemClick = {
            val intent = Intent(this, NonFicDetails::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }
    }
    private fun getData() {
        for (i in imageListNF.indices) {
            val dataClass = NonFicData(imageListNF[i], titleListNF[i], descListNF[i], detailImageListNF[i])
            dataListNF.add(dataClass)
        }
        searchListNF.addAll(dataListNF)
        recyclerViewNF.adapter = NonFicAdapter(searchListNF)
    }
}