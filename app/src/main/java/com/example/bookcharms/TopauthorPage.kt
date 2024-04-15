package com.example.bookcharms

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class TopauthorPage : AppCompatActivity() {

    private lateinit var recyclerViewT: RecyclerView
    private lateinit var searchViewT: SearchView
    private var topList = ArrayList<TopData>()
    private lateinit var adapter: TopAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_topauthor_page)

        recyclerViewT = findViewById(R.id.recyclerViewtop)
        searchViewT = findViewById(R.id.searchtopauthor)

        recyclerViewT.setHasFixedSize(true)
        recyclerViewT.layoutManager = LinearLayoutManager(this)
        addDataToList()
        adapter = TopAdapter(topList)
        recyclerViewT.adapter = adapter

        searchViewT.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<TopData>()
            for (i in topList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(this, "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        topList.add(
            TopData(
                "Anjell | Malay Author",
                R.drawable.anjell,
                "Anjell is a pen name chosen by Malaysia's no.1 bestselling novelist.  Her novels include Eksperimen Cinta, Suamiku Paling Sweet, Tundukan Playboy Itu, Heronya Seorang Cinderella, Dr. Alpha Male, Dheo's, Dia Tetap Sempurna, and King Haidar are listed as bestsellers and everyone's favorite read. All of Anjell's novels belong in the adult and contemporary romance genre. All of Anjell's novels have modern-day fairytale vibes. Two of her novels, Tundukan Playboy Itu and Hero Seorang Cinderella have already been adapted into a TV series drama.")
        )
        topList.add(
            TopData(
                "Syamnuriezmil | Malay Author",
                R.drawable.syam,
                "Syamnuriezmil, Malaysia's acclaimed fiction author, consistently delivers captivating novels like Isteri Untuk Disewa, Wishlist, and Suamiku Encik Perfect 10, all adapted into hit movies. Known for her modern-day fairytales and compelling storytelling, she's a favorite among readers nationwide."            )
        )
        topList.add(
            TopData(
                "Acik Lana| Malay Author",
                R.drawable.person2,
                "Acik Lana, renowned in Malaysian fiction circles, is celebrated for her enthralling novels like Red Velvt and Chandelier, both of which have been turned into successful movies."            )
        )
        topList.add(
            TopData(
                "J.K. Rowling | English Author",
                R.drawable.jk,
                "J.K. Rowling is the British author who created the popular and critically acclaimed Harry Potter series (seven books published between 1997 and 2007), about a lonely orphan who discovers that he is actually a wizard and enrolls in the Hogwarts School of Witchcraft and Wizardry."
            )
        )
        topList.add(
            TopData(
                "Colleen Hoover | English Author",
                R.drawable.col,
                "American author who became a publishing phenomenon in the early 21st century and is known for hugely popular books that typically feature romance and dramatic plot twists."
            )
        )
        topList.add(
            TopData(
                "Agatha Christie | English Author",
                R.drawable.aga,
                    "Agatha Christie is acknowledged as the all time best-selling fiction author. It is estimated that she has sold over 2 billion copies of her books. " +
                            "Her book sales are only exceeded by The Bible and the works of William Shakespeare."
            )
        )
    }
}