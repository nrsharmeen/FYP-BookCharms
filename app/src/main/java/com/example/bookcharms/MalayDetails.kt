// MalayDetails.kt
package com.example.bookcharms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MalayDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_malay_details)
        val getData = intent.getParcelableExtra<MalayData>("android")
        if (getData != null) {
            val detailTitle: TextView = findViewById(R.id.detailTitleMalay)
            val detailDesc: TextView = findViewById(R.id.detailDescMalay)
            val detailImage: ImageView = findViewById(R.id.detailImageMalay)
            detailTitle.text = getData.dataTitleM
            detailDesc.text = getData.dataDescM
            detailImage.setImageResource(getData.dataDetailImageM)
        }
    }
}