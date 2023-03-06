package com.example.androidweek_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.androidweek_5.R

class printProfileActivity : Fragment() {
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
        val view = inflater.inflate(R.layout.activity_print_profile, container, false)

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

        return view
    }
}