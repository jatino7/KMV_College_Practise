package com.o7solutions.kmv_college_practise

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RelativeActivity : AppCompatActivity() {


    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_relative)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var email = intent.getStringExtra("email")
        Toast.makeText(this, email, Toast.LENGTH_SHORT).show()


        var nameET = findViewById<EditText>(R.id.nameET)
//        var submitBTN =
        var name = nameET.text.toString()
    }
}