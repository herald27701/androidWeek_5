package com.example.androidweek_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidweek_3.databinding.SignupLayoutBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: SignupLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_layout)


    }
}