package com.example.androidweek_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton: Button = findViewById(R.id.login_button)
        loginButton.setOnClickListener{ login() }
    }

    private fun login()
    {
        var username: EditText = findViewById(R.id.email_input)
        var password: EditText = findViewById(R.id.password_input)
        if ("@gmail.com" in username.getText().toString())
        {
            Toast.makeText(this, "correct  format", Toast.LENGTH_SHORT).show()
        }
        else
        {
            Toast.makeText(this, "wrong email format", Toast.LENGTH_SHORT).show()
        }
    }
}