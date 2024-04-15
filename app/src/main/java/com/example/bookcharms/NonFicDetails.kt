package com.example.bookcharms

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NonFicDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_non_fic_details)
        val getData = intent.getParcelableExtra<NonFicData>("android")
        if (getData != null) {
            val detailTitle: TextView = findViewById(R.id.detailTitleNonFic)
            val detailDesc: TextView = findViewById(R.id.detailDescNonFic)
            val detailImage: ImageView = findViewById(R.id.detailImageNonFic)
            detailTitle.text = getData.dataTitleNF
            detailDesc.text = getData.dataDescNF
            detailImage.setImageResource(getData.dataDetailImageNF)
        }
    }
}