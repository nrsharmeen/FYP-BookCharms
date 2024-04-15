package com.example.bookcharms

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class HomePage : AppCompatActivity() {

    //initialize all component
    //var = variable
    private lateinit var bestseller : Button
    private lateinit var preferences : Button
    private lateinit var profilepage : Button
    private lateinit var topauthor : Button
    private lateinit var logout : Button

    // Declare Firebase components
    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        // Initialize Firebase authentication
        auth = FirebaseAuth.getInstance()

        //declare all component
        bestseller = findViewById<Button>(R.id.bestsellerbtn)
        preferences = findViewById<Button>(R.id.preferencesbtn)
        profilepage = findViewById<Button>(R.id.myProfilebtn)
        topauthor = findViewById<Button>(R.id.topauthor)
        logout = findViewById<Button>(R.id.logoutbtn)


        //function for button
        //val = static variable
        //Intent = function for linking to other page/activity
        bestseller.setOnClickListener {
            val i = Intent (this, BestsellerPage::class.java)
            startActivity(i)}

        //function for button
        //val = static variable
        //Intent = function for linking to other page/activity
        preferences.setOnClickListener {
            val i = Intent (this, DashboardUser::class.java)
            startActivity(i)}

        //function for button
        //val = static variable
        //Intent = function for linking to other page/activity
        profilepage.setOnClickListener {
            val i = Intent (this, MyProfilePage::class.java)
            startActivity(i)}

        //function for button
        //val = static variable
        //Intent = function for linking to other page/activity
        topauthor.setOnClickListener {
            val i = Intent (this, TopauthorPage::class.java)
            startActivity(i)}

        //function for button
        //val = static variable
        //Intent = function for linking to other page/activity
        logout.setOnClickListener {
            val i = Intent (this, LoginPage::class.java)
            startActivity(i)}


    }
}