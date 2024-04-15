package com.example.bookcharms

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class DashboardUser : AppCompatActivity() {

    //initialize all component
    //var = variable
    private lateinit var education : Button
    private lateinit var nonfiction : Button
    private lateinit var fiction : Button
    private lateinit var malay : Button
    private lateinit var english : Button

    // Declare Firebase components
    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard_user)

        // Initialize Firebase authentication
        auth = FirebaseAuth.getInstance()

        //declare all component
        education = findViewById<Button>(R.id.edubtn)
        nonfiction = findViewById<Button>(R.id.nonficbtn)
        fiction = findViewById<Button>(R.id.ficbtn)
        malay = findViewById<Button>(R.id.malaybtn)
        english = findViewById<Button>(R.id.englishbtn)


        //function for button
        //val = static variable
        //Intent = function for linking to other page/activity
        education.setOnClickListener {
            val i = Intent (this, EducationPage::class.java)
            startActivity(i)}

        //function for button
        //val = static variable
        //Intent = function for linking to other page/activity
        nonfiction.setOnClickListener {
            val i = Intent (this, NonFictionPage::class.java)
            startActivity(i)}

        //function for button
        //val = static variable
        //Intent = function for linking to other page/activity
        fiction.setOnClickListener {
            val i = Intent (this, FictionPage::class.java)
            startActivity(i)}

        //function for button
        //val = static variable
        //Intent = function for linking to other page/activity
        malay.setOnClickListener {
            val i = Intent (this, MalayPage::class.java)
            startActivity(i)}

        //function for button
                //val = static variable
                //Intent = function for linking to other page/activity
                english.setOnClickListener {
                    val i = Intent (this, EnglishPage::class.java)
                    startActivity(i)}


    }
}