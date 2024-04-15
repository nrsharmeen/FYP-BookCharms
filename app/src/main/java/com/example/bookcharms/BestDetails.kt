// MalayDetails.kt
package com.example.bookcharms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class BestDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_best_details)
        val getData = intent.getParcelableExtra<BestData>("android")
        if (getData != null) {
            val detailTitle: TextView = findViewById(R.id.detailTitleBest)
            val detailDesc: TextView = findViewById(R.id.detailDescBest)
            val detailImage: ImageView = findViewById(R.id.detailImageBest)
            detailTitle.text = getData.dataTitleB
            detailDesc.text = getData.dataDescB
            detailImage.setImageResource(getData.dataDetailImageB)
        }
    }
}