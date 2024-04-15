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

class EducationPage : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imageList:Array<Int>
    lateinit var titleList:Array<String>
    lateinit var descList: Array<String>
    lateinit var detailImageList: Array<Int>
    private lateinit var myAdapter: AdapterClass
    private lateinit var searchView: SearchView
    private lateinit var searchList: ArrayList<DataClass>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_education_page)
        imageList = arrayOf(
            R.drawable.bukuliterasi,
            R.drawable.asastekno,
            R.drawable.seeyouat,
            R.drawable.educated,
            R.drawable.foundations,
            R.drawable.teacherman)
        titleList = arrayOf(
            "Buku Literasi Undang-Undang Untukmu Guru oleh Dato' Hazizah Kassim",
            "Asas Teknologi Elektrik oleh Azrul Bin Mahfurdz",
            "See You At The Top - Edisi Bahasa Melayu oleh Zig Ziglar",
            "Educated by Tara Westover",
            "Foundations of Educational Research by Victoria Elliot",
            "Teacher Man by Frank McCourt")
        descList = arrayOf(
            getString(R.string.bukuliterasi),
            getString(R.string.asastekno),
            getString(R.string.seeyouat),
            getString(R.string.Educated),
            getString(R.string.Foundations),
            getString(R.string.TeacherMan))
        detailImageList = arrayOf(
            R.drawable.bukuliterasi,
            R.drawable.asastekno,
            R.drawable.seeyouat,
            R.drawable.educated,
            R.drawable.foundations,
            R.drawable.teacherman)

        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.search)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        dataList = arrayListOf<DataClass>()
        searchList = arrayListOf<DataClass>()
        getData()
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.clearFocus()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                searchList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    dataList.forEach{
                        if (it.dataTitle.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            searchList.add(it)
                        }
                    }
                    recyclerView.adapter!!.notifyDataSetChanged()
                } else {
                    searchList.clear()
                    searchList.addAll(dataList)
                    recyclerView.adapter!!.notifyDataSetChanged()
                }
                return false
            }
        })
        myAdapter = AdapterClass(searchList)
        recyclerView.adapter = myAdapter
        myAdapter.onItemClick = {
            val intent = Intent(this, EduDeetails::class.java)
            intent.putExtra("android", it)
            startActivity(intent)
        }
    }
    private fun getData() {
        for (i in imageList.indices) {
            val dataClass = DataClass(imageList[i], titleList[i], descList[i], detailImageList[i])
            dataList.add(dataClass)
        }
        searchList.addAll(dataList)
        recyclerView.adapter = AdapterClass(searchList)
    }
}