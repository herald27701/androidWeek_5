package com.example.androidweek_3

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel

class doSignUp : ViewModel()
{
    fun checkEmailAndPassword(email: String, password: String, context: Context)
    {
        val isValidEmail = isEmailValid(email)
        val isValidPassword = isPasswordValid(password)
        if (!isValidEmail) {
            Toast.makeText(context, "email không hợp lệ",Toast.LENGTH_SHORT).show()
            return
        }
        if (!isValidPassword) {
            Toast.makeText(context, "Hãy nhập 8 tới 10 kí tự",Toast.LENGTH_SHORT).show()
            return
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


    private fun isPasswordValid(password: String): Boolean {
        return password.length in 8..10
    }

}