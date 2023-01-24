package com.example.androidweek_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val new_fullname: EditText = findViewById(R.id.new_name)
        val new_email: EditText = findViewById(R.id.new_email_input)
        val new_number: EditText = findViewById(R.id.new_number)

        val signupClick: Button = findViewById(R.id.signup_button)
        signupClick.setOnClickListener { signupEnter(new_fullname, new_email, new_number) }
    }

    private fun signupEnter(new_fullname: EditText, new_email: EditText, new_number: EditText)
    {
        val name: String = new_fullname.text.toString().trim()
        val email: String = new_email.text.toString().trim()
        val number: String = new_number.text.toString().trim()

        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("mail", email)
        bundle.putString("num", number)
        val intent: Intent = Intent(this, printProfileActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}