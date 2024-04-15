// MalayDetails.kt
package com.example.bookcharms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class EngDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eng_details)
        val getData = intent.getParcelableExtra<EngData>("android")
        if (getData != null) {
            val detailTitle: TextView = findViewById(R.id.detailTitleEng)
            val detailDesc: TextView = findViewById(R.id.detailDescEng)
            val detailImage: ImageView = findViewById(R.id.detailImageEng)
            detailTitle.text = getData.dataTitleE
            detailDesc.text = getData.dataDescE
            detailImage.setImageResource(getData.dataDetailImageE)
        }
    }
}