package com.example.androidweek_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next2: Button = findViewById(R.id.next0)
        next2.setOnClickListener { swip() }


    }

    fun swip() {
        val intent: Intent = Intent(this, SigninActivity::class.java)
        startActivity(intent)
    }
}