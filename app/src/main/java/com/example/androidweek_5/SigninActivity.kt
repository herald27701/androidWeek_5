package com.example.androidweek_5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidweek_5.R
import com.example.androidweek_5.databinding.SigninLayoutBinding


class SigninActivity : Fragment() {
    private lateinit var binding: SigninLayoutBinding
    private lateinit var viewModel: doSignin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = DataBindingUtil.setContentView(this, R.layout.signin_layout)
//        viewModel = ViewModelProvider(this).get(doSignin::class.java)
//
//        //val loginButton: Button = findViewById(R.id.login_button)
//        binding.loginButton.setOnClickListener{ login() }
//        //val signupButton:TextView = findViewById(R.id.signup_link)
//        binding.signupLink.setOnClickListener { signup() }
//
//        listenerSuccessEvent()
//        listenerErrorEvent()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.signin_layout, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(doSignin::class.java)

        binding.loginButton.setOnClickListener { login() }
        binding.signupLink.setOnClickListener { signup() }

        listenerSuccessEvent()
        listenerErrorEvent()
    }

    private fun login()
    {
        val user_signin = binding.emailInput.text.toString().trim()
        val password_signin = binding.passwordInput.text.toString().trim()
        viewModel.checkEmailAndPassword(user_signin, password_signin)
    }

    private fun signup()
    {
        val intent: Intent = Intent(requireActivity(), SignupActivity::class.java)
        startActivity(intent)
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess) {
                val email = binding.emailInput.text.toString().trim()
                val password = binding.passwordInput.text.toString().trim()
                val intent = Intent(requireActivity(), Restaurant_rv::class.java)
                val bundle = Bundle()
                bundle.putParcelable(Constants.KEY_USER, Student(email, password))
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(viewLifecycleOwner) { errMsg ->
            Toast.makeText(requireContext(), errMsg, Toast.LENGTH_SHORT).show()
        }
    }
}