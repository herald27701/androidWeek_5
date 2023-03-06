package com.example.androidweek_5

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.fragment.findNavController
import com.example.androidweek_5.R
import com.example.androidweek_5.databinding.ActivityOnboard3Binding


class OnboardActivity3 : Fragment() {
    lateinit var binding: ActivityOnboard3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = ActivityOnboard3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.next3.setOnClickListener{
            val controller = findNavController()
            controller.navigate(R.id.action_Onboard3Fragment_to_WelcomeFragment)
        }
    }

}