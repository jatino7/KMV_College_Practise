package com.o7solutions.kmv_college_practise.Firebase

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.o7solutions.kmv_college_practise.R
import com.o7solutions.kmv_college_practise.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {


    private var auth = FirebaseAuth.getInstance()
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.submitBTN.setOnClickListener {
            auth.signInWithEmailAndPassword(
                binding.email.text.toString(),
                binding.password.text.toString()
            )
                .addOnSuccessListener {
                    Toast.makeText(this, "Account Creation successful!", Toast.LENGTH_SHORT).show()
//                    send user to another activity
                }
                .addOnFailureListener{ e->
                    Toast.makeText(this, e.localizedMessage, Toast.LENGTH_SHORT).show()
                }
        }
    }
}