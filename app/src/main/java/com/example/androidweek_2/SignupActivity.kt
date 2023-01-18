package com.example.androidweek_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_layout)

        val signupButton: Button = findViewById(R.id.signup_button)
        signupButton.setOnClickListener{ signup() }

    }

    fun updateinfo(input_email:String, input_password:String)
    {
        account.put(input_email, input_password)
    }

    private fun signup()
    {
        val new_username: EditText = findViewById(R.id.email_input)
        val new_password: EditText = findViewById(R.id.password_input)
        if ("@gmail.com" in new_username.text.toString())
        {
            Toast.makeText(this, "correct email format", Toast.LENGTH_SHORT).show()
            //appdb.updateinfo(new_username.toString(), new_password.toString())
            updateinfo(new_username.text.toString(), new_password.text.toString())
            //val intent: Intent = Intent(this, AppDatabase::class.java)
            //startActivity(intent)
        }
        else
        {
            Toast.makeText(this, "wrong email format", Toast.LENGTH_SHORT).show()
        }
        //finish()
    }
}