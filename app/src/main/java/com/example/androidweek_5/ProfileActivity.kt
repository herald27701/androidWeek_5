package com.example.androidweek_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.androidweek_5.databinding.ActivityProfileBinding

class ProfileActivity : Fragment() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: doProfile
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
//        viewModel = ViewModelProvider(this).get(doProfile::class.java)
//
//        val bundle = intent.extras
//        bundle?.let {
//            val student : Student? = it.getParcelable(Constants.KEY_USER)
//            student?.let {
//                binding.newEmailInput.setText("${student.username}")
//            }
//        }
//
//        binding.signupButton.setOnClickListener { signupEnter() }
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.activity_profile, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(doProfile::class.java)

        val bundle = arguments
        bundle?.let {
            val student: Student? = it.getParcelable(Constants.KEY_USER)
            student?.let {
                binding.newEmailInput.setText("${student.username}")
            }
        }

        //private fun signupEnter() here
        binding.signupButton.setOnClickListener {
            val new_fullname: String = binding.newName.text.toString().trim()
            val new_email: String = binding.newEmailInput.text.toString().trim()
            val new_number: String = binding.newNumber.text.toString().trim()

            val bundle = Bundle()
            bundle.putString("name", new_fullname)
            bundle.putString("mail", new_email)
            bundle.putString("num", new_number)
            val intent: Intent = Intent(requireContext(), printProfileActivity::class.java)
            intent.putExtras(bundle)
            //startActivity(intent)
            val controller = findNavController()
            controller.navigate(R.id.action_profileActivity_to_printProfileActivity)
        }
    }


}