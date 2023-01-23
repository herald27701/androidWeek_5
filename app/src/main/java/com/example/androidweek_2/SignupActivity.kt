package com.example.androidweek_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.authapp.User
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class SignupActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_layout)

        auth = Firebase.auth

        val new_fullname: EditText = findViewById(R.id.new_name)
        val new_email: EditText = findViewById(R.id.new_email_input)
        val new_number: EditText = findViewById(R.id.new_number)
        val new_password: EditText = findViewById(R.id.new_password_input)

        val signupClick: Button = findViewById(R.id.signup_button)
        signupClick.setOnClickListener { signupEnter(new_fullname, new_email, new_number, new_password) }
    }

    private fun signupEnter(new_fullname: EditText, new_email: EditText, new_number: EditText, new_password: EditText)
    {
        val name: String = new_fullname.text.toString().trim()
        val email: String = new_email.text.toString().trim()
        val number: String = new_number.text.toString().trim()
        val password: String = new_password.text.toString().trim()

        if (name.isEmpty())
        {
            new_fullname.setError("Name is require")
            new_fullname.requestFocus()
            return
        }

        if (email.isEmpty())
        {
            new_email.setError("Email is require")
            new_email.requestFocus()
            return
        }

        if (number.isEmpty())
        {
            new_number.setError("Number is require")
            new_number.requestFocus()
            return
        }

        if (password.isEmpty())
        {
            new_password.setError("Password is require")
            new_password.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(OnCompleteListener <AuthResult> { task ->
                if (task.isSuccessful)
                {
                    val user = User(name, email, number, password)

                    FirebaseAuth.getInstance().currentUser?.let {
                        FirebaseDatabase.getInstance().getReference("Users")
                            .child(it.uid).setValue(user).addOnCompleteListener ( OnCompleteListener <Void> {
                                if (task.isSuccessful)
                                {
                                    Toast.makeText(this, "Signup Success", Toast.LENGTH_SHORT).show()
                                }
                                else
                                {
                                    Toast.makeText(this, "Signup Failed", Toast.LENGTH_SHORT).show()
                                }
                            } )
                    }
                }
            })
    }
}