package com.o7solutions.kmv_college_practise

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    lateinit var submitBTN : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        submitBTN = findViewById<Button>(R.id.submitBTN)


//        submitBTN.setOnClickListener {
//            Toast.makeText(this, "Submit button  pressed", Toast.LENGTH_LONG).show()
//
//        }



        start()
    }


    fun start() {

        submitBTN.setOnClickListener {
            var intent = Intent(this, RelativeActivity::class.java).apply {

                putExtra("email","jatin@gmail.com")
            }
            startActivity(intent)
            finish()
        }
    }
}