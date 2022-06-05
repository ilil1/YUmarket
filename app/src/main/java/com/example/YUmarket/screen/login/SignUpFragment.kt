package com.example.YUmarket.screen.login


import android.os.Bundle
import android.util.Log
import com.example.YUmarket.databinding.FragmentSignupBinding
import com.example.YUmarket.screen.base.BaseFragment
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment : BaseFragment<FragmentSignupBinding>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val email = binding.editEmail.text.toString()
        val password = binding.editpassword.text.toString()

        Log.d("SignUpFragment","Email is " + email)
        Log.d("SignUpFragment", "password is + $password")


        // create a user with firebase
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                if(!it.isSuccessful) return@addOnCompleteListener

                // else if sucessful
                Log.d("Sing","Successfully created user with uid: ${it.result.user?.uid}")
            }





    }

    override fun getViewBinding(): FragmentSignupBinding =
        FragmentSignupBinding.inflate(layoutInflater)

    override fun observeData() {}

    override fun initViews() {
        super.initViews()
        // get email and password

    }
}