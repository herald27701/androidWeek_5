package com.example.androidweek_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidweek_5.R
import com.example.androidweek_5.databinding.ActivityWelcomeBinding

class WelcomeActivity : Fragment() {
    private lateinit var binding: ActivityWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityWelcomeBinding.inflate(inflater, container, false)
        return binding.root

        // Add your code to interact with the views here

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.next0.setOnClickListener{
            val controller = findNavController()
            controller.navigate(R.id.WelcomeFragment_to_SignIn) }

    }


//    override fun onCreateView(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_welcome)
//
//        val next2: Button = findViewById(R.id.next0)
//        next2.setOnClickListener { swip() }
//
//
//    }
//
//    fun swip() {
//        val intent: Intent = Intent(this, SigninActivity::class.java)
//        startActivity(intent)
//    }
//}

}