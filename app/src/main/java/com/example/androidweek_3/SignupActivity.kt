package com.example.androidweek_3

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import android.os.Bundle
<<<<<<< HEAD
=======
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
>>>>>>> origin/week3NgHQuocHuy
import com.example.androidweek_3.databinding.SignupLayoutBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var binding: SignupLayoutBinding
<<<<<<< HEAD
=======
    private lateinit var ViewModel:doSignUp
>>>>>>> origin/week3NgHQuocHuy
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.signup_layout)

        binding.signupButton.setOnClickListener {signup_lientay()}
        ViewModel = ViewModelProvider(this).get(doSignUp::class.java)
    }

    fun signup_lientay()
    {
        val email_signup:String = binding.newEmailInput.text.toString().trim()
        val password_signup:String = binding.newPasswordInput.text.toString().trim()
        ViewModel.checkEmailAndPassword(email_signup, password_signup, this)
    }
}