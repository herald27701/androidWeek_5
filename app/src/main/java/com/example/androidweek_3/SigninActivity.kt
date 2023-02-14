package com.example.androidweek_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.androidweek_3.databinding.SigninLayoutBinding

class SigninActivity : AppCompatActivity() {
    private lateinit var binding: SigninLayoutBinding
    private lateinit var viewModel: doSignin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.signin_layout)
        viewModel = ViewModelProvider(this).get(doSignin::class.java)
        
        //val loginButton: Button = findViewById(R.id.login_button)
        binding.loginButton.setOnClickListener{ login() }
        //val signupButton:TextView = findViewById(R.id.signup_link)
        binding.signupLink.setOnClickListener { signup() }
    }

    private fun login()
    {
        val user_signin = binding.emailInput.text.toString().trim()
        val password_signin = binding.emailInput.text.toString().trim()
        viewModel.checkEmailAndPassword(user_signin, password_signin, this)
    }

    private fun signup()
    {
        val intent: Intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }
}