package com.example.bookcharms

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.auth.FirebaseAuth

class SignUpPage : AppCompatActivity() {

    //declare to connect with database
    private lateinit var dbRef: DatabaseReference
    //initial all component
    private lateinit var reset: Button
    private lateinit var signup: Button
    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText

    // create Firebase authentication object
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_page)

        //reference the component
        reset = findViewById<Button>(R.id.resetbtn)
        signup = findViewById<Button>(R.id.signupbtn)
        name = findViewById<EditText>(R.id.etName)
        email = findViewById<EditText>(R.id.eTemail)
        password = findViewById<EditText>(R.id.eTpass)

        //popup message when click button add record
        Toast.makeText(this, "Submit", Toast.LENGTH_LONG).show()

        signup.setOnClickListener {
            //call function saveEmployeeData
            //parameter - change the input data to string
            saveData(name.text.toString(), email.text.toString(), password.text.toString())
        }


        reset.setOnClickListener {
            name.setText (" ")
            email.setText (" ")
            password.setText (" ")
        }
    }
    //create the function saveData
    // this function send data to firebase
    //n = name
    //p = password
    //e = email
    private fun saveData(n:String, e:String, p:String)
    {
        //getInstance = get object
        // Customer refer to table
        //Customer can change to other name
        // link database named Customer
        dbRef = FirebaseDatabase.getInstance().getReference("Customer")
        //produce auto generate customer 1d
        //!! refer must had record or id cannot null
        val customerId = dbRef.push().key!!

        //customer 1s a object
        //push the data to database
        //customerId will autogenerate
        //data will output by user
        //input name, password, email
        val em = Model(n, customerId, e, p)

        //setting to push data inside table
        dbRef.child(customerId).setValue(em)
            //success record, it will popup success
            .addOnCompleteListener {
                Toast.makeText (this,"Success", Toast.LENGTH_LONG).show()
                //fail to record. it will popup failure
            }.addOnFailureListener {
                Toast.makeText(this, "Failure", Toast.LENGTH_LONG).show()
            }

        //declare variable i to connect to next pages/activity
        val i = Intent( this, LoginPage::class.java)
        startActivity(i)
    }
}
