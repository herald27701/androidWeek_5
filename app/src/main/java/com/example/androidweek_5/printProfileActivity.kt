package com.example.androidweek_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.androidweek_5.R
import com.example.androidweek_5.databinding.ActivityPrintProfileBinding
class printProfileActivity : Fragment() {
    lateinit var binding: ActivityPrintProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_print_profile)
//
//        val name:TextView = findViewById(R.id.final_name)
//        val email:TextView = findViewById(R.id.final_email)
//        val number:TextView = findViewById(R.id.final_number)
//        val bundle = intent.extras
//        bundle?.let {
//            val new_fullname = bundle.getString("name", "unknown")
//            val new_email = bundle.getString("mail", "unknown")
//            val new_number = bundle.getString("num", "unknown")
//            name.text = new_fullname
//            email.text = new_email
//            number.text = new_number
//        }
//
//    }
//

    //activity to fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ActivityPrintProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name: TextView = view.findViewById(R.id.final_name)
        val email: TextView = view.findViewById(R.id.final_email)
        val number: TextView = view.findViewById(R.id.final_number)
        val bundle = arguments // different between activity and fragment
        bundle?.let {
            val new_fullname = bundle.getString("name", "unknown")
            val new_email = bundle.getString("mail", "unknown")
            val new_number = bundle.getString("num", "unknown")
            name.text = new_fullname
            email.text = new_email
            number.text = new_number
        }

        binding.signOut.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_printProfileActivity_to_welcomeActivity1)
        }
    }
}