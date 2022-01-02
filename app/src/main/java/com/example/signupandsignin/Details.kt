package com.example.signupandsignin
import java.io.Serializable

data class Details (val name: String, val phone: String, val location: String, val password: String) :
    Serializable