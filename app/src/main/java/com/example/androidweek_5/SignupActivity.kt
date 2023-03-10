package com.example.androidweek_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidweek_5.R
import com.example.androidweek_5.databinding.SignupLayoutBinding
import androidx.navigation.fragment.findNavController


class SignupActivity : Fragment() {
    private lateinit var binding: SignupLayoutBinding

    private lateinit var ViewModel:doSignUp
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return super.onCreateView(inflater, container, savedInstanceState)
//    }(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(inflater, R.layout.signup_layout, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        binding.signupButton.setOnClickListener {signup_lientay()}
        ViewModel = ViewModelProvider(this).get(doSignUp::class.java)

        listenerSuccessEvent()
        listenerErrorEvent()
    }

    fun signup_lientay()
    {
        val email_signup:String = binding.newEmailInput.text.toString().trim()
        val password_signup:String = binding.newPasswordInput.text.toString().trim()
        ViewModel.checkEmailAndPassword(email_signup, password_signup)
    }

    private fun listenerSuccessEvent() {
        ViewModel.isSuccessEvent.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess) {
                val email = binding.newEmailInput.text.toString().trim()
                val password = binding.newPasswordInput.text.toString().trim()
                val intent = Intent(activity, ProfileActivity::class.java)
                val bundle = Bundle()
                bundle.putParcelable(Constants.KEY_USER, Student(email, password))
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun listenerErrorEvent() {
        ViewModel.isErrorEvent.observe(viewLifecycleOwner) { errMsg ->
            Toast.makeText(activity, errMsg, Toast.LENGTH_SHORT).show()
        }
    }
}