package com.example.signupandsignin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.signupandsignin.databinding.ActivityDetailsBinding

class detailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getSerializableExtra("user") as Details

        binding.apply {
            tvName.text = user?.name
            tvLocation.text = user?.location
            tvPassword.text = user?.password
            tvPhone.text = user?.phone
        }

    }
}