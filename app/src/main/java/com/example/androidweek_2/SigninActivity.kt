package com.example.androidweek_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SigninActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_layout)

        val loginButton: Button = findViewById(R.id.login_button)
        loginButton.setOnClickListener{ login() }

        val signupButton:TextView = findViewById(R.id.signup_link)
        signupButton.setOnClickListener { signup() }
    }

    private fun login()
    {
        val username: EditText = findViewById(R.id.email_input)
        val password: EditText = findViewById(R.id.password_input)
        if ("username@gmail.com" in username.text.toString().trim() && "123456" in password.text.toString().trim())
        {
            Toast.makeText(this, "correct email", Toast.LENGTH_SHORT).show()
            val intent: Intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
        else
        {
            Toast.makeText(this, "wrong email", Toast.LENGTH_SHORT).show()
        }
    }

    private fun signup()
    {
        val intent: Intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }
}