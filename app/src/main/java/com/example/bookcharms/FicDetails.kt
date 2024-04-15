// FicDetails.kt
package com.example.bookcharms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class FicDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fic_details)
        val getData = intent.getParcelableExtra<FicData>("android")
        if (getData != null) {
            val detailTitle: TextView = findViewById(R.id.detailTitleFic)
            val detailDesc: TextView = findViewById(R.id.detailDescFic)
            val detailImage: ImageView = findViewById(R.id.detailImageFic)
            detailTitle.text = getData.dataTitleF
            detailDesc.text = getData.dataDescF
            detailImage.setImageResource(getData.dataDetailImageF)
        }
    }
}
