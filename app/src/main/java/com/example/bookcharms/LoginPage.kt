package com.example.bookcharms

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.auth.FirebaseAuth

class LoginPage : AppCompatActivity() {

    //initialize all component
    private lateinit var btnLog: Button
    private lateinit var btnreset: Button
    private lateinit var email: EditText
    private lateinit var password: EditText


    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth

    //declare the firebase
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        //declare the component
        btnLog = findViewById<Button>(R.id.loginbutton2)
        btnreset = findViewById<Button>(R.id.btnreset)
        email = findViewById<EditText>(R.id.emailLogin)
        password = findViewById<EditText>(R.id.passLogin)


        firebaseDatabase = FirebaseDatabase.getInstance()
        databaseReference = firebaseDatabase.reference.child("Customer")


        // call the logIn function when login button is clicked
        btnLog.setOnClickListener {
            logIn(email.text.toString(), password.text.toString())
        }


        btnreset.setOnClickListener {
            email.setText(" ")
            password.setText(" ")
        }
    }

    private fun logIn(email: String, password: String) {
        databaseReference.orderByChild("customerEmail").equalTo(email)
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        for (custSnapshot in dataSnapshot.children) {
                            val model = custSnapshot.getValue(Model::class.java)

                            if (model != null && model.customerPassword == password) {
                                Toast.makeText(
                                    this@LoginPage,
                                    "Login Successful",
                                    Toast.LENGTH_LONG
                                ).show()

                                // Start DashboardUser activity upon successful login
                                startActivity(Intent(this@LoginPage, HomePage::class.java))

                                // Finish the current activity
                                finish()
                                return
                            }
                        }
                    }

                    Toast.makeText(this@LoginPage, "Login Failed", Toast.LENGTH_LONG).show()
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    Toast.makeText(
                        this@LoginPage,
                        "Database Error: ${databaseError.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }
}
