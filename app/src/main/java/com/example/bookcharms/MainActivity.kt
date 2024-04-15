package com.example.bookcharms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //initialize all component
    //var = variable
    private lateinit var btnlogin : Button
    private lateinit var btnsignup : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //declare all component
        btnlogin = findViewById<Button>(R.id.loginbutton)
        btnsignup = findViewById<Button>(R.id.signupbutton2)

        //function for button login
        //val = static variable
        //Intent = function for linking to other page/activity
        btnlogin.setOnClickListener {
            val i = Intent (this, LoginPage::class.java)
            startActivity(i)}

        //function for button sign up
        //val = static variable
        //Intent = function for linking to other page/activity
        btnsignup.setOnClickListener {
            val i = Intent (this, SignUpPage::class.java)
            startActivity(i)}

    }
}