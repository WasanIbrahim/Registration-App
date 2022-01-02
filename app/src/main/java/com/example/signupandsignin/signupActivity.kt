package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.signupandsignin.databinding.ActivityDetailsBinding
import com.example.signupandsignin.databinding.ActivitySignupBinding

class signupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    private val databaseHelper by lazy { DatabaseHelper(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.signupButton.setOnClickListener {
            //UI Elements
            val name = binding.nameET.text.toString()
            val phoneNumber = binding.phoneET.text.toString()
            val location = binding.locationET.text.toString()
            val password = binding.passwordET.text.toString()
            val newUser = Details(name,phoneNumber,location,password)

            println("here is the newuser : $newUser")

            //saving new user
            databaseHelper.saveData(newUser)

            // intent to details activity
            val intent = Intent(this, detailsActivity::class.java)
            intent.putExtra("user",newUser)
            startActivity(intent)
        }

        binding.goToLoginActivity.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // start your next activity
            startActivity(intent)
        }


    }
}