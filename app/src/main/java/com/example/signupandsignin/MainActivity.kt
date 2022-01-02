package com.example.signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.signupandsignin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val databaseHelper by lazy { DatabaseHelper(applicationContext) }
    private lateinit var user: Details


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.loginButton.setOnClickListener {

            val phoneNumber = binding.phoneET.text.toString()
            val password = binding.passwordET.text.toString()

            if (phoneNumber == null || password == null) {
                //All fields required
                Toast.makeText(this, "fill in all the fields ", Toast.LENGTH_LONG).show()

            } else {
                user = databaseHelper.getData(phoneNumber)!!


                if (user.name == "") {
                    Toast.makeText(
                        this@MainActivity,
                        "User doesn't exist, please sign up",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {
                    if (password == user.password) {
                        val intent = Intent(this@MainActivity, detailsActivity::class.java)
                        intent.putExtra("user", user)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@MainActivity, "Wrong password", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }

            binding.signupTextView.setOnClickListener {
                val intent = Intent(this, signupActivity::class.java)
                // start your next activity
                startActivity(intent)
            }
        }
    }
}