package com.o7solutions.kmv_college_practise.Firebase

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.o7solutions.kmv_college_practise.R
import com.o7solutions.kmv_college_practise.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private var auth = FirebaseAuth.getInstance()
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.submitBTN.setOnClickListener {
            auth.createUserWithEmailAndPassword(
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