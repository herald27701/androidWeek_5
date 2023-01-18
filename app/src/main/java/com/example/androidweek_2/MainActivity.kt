package com.example.androidweek_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

//val appdb = AppDatabase()
var account = mutableMapOf<String, String>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_layout)

        val loginButton: Button = findViewById(R.id.login_button)
        loginButton.setOnClickListener{ login() }

        val signupButton:TextView = findViewById(R.id.signup_link)
        signupButton.setOnClickListener { signup() }
    }

    override fun onResume()
    {
        super.onResume()
        val loginButton: Button = findViewById(R.id.login_button)
        loginButton.setOnClickListener{ login() }

        val signupButton:TextView = findViewById(R.id.signup_link)
        signupButton.setOnClickListener { signup() }
    }

    private fun login()
    {
        val username: EditText = findViewById(R.id.email_input)
        val password: EditText = findViewById(R.id.password_input)
        if (account.containsKey(username.text.toString()) == true)
        {
            Toast.makeText(this, "TK Da ton tai", Toast.LENGTH_SHORT).show()
            account.forEach{
                println("AAA ${it.key} : ${it.value}")
            }
        }
        else
        {
            Toast.makeText(this, "TK Chua Dang Ky", Toast.LENGTH_SHORT).show()
            account.forEach{
                println("AAA ${it.key} : ${it.value}")
            }
        }
    }

    private fun signup()
    {
        val intent: Intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }
}