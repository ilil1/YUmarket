package com.example.YUmarket.screen.login

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import com.example.YUmarket.R
import com.example.YUmarket.databinding.ActivityLoginBinding
import com.example.YUmarket.screen.MainActivity
import com.example.YUmarket.screen.base.BaseActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity :BaseActivity<ActivityLoginBinding>(){


    private var doubleBackToExit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.login.setOnClickListener {
            val email = binding.editId.text.toString()
            val password = binding.editPassword.text.toString()

            //Log.d("Login","Attept login with email/pw: $email/***")

           FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password)
               .addOnCompleteListener{it ->
                   if(it.isSuccessful){
                       Toast.makeText(this,"위드마켓에 오신것을 환영합니다.",Toast.LENGTH_SHORT).show()
                       startActivity(Intent(this,MainActivity::class.java))
                       finish()
                   }else{
                       Toast.makeText(this,"이메일 및 비밀번호를 확인해주세요",Toast.LENGTH_SHORT).show()
                   }
               }

        }

        binding.sign.setOnClickListener {
            registerMove()
        }



    }


    override fun getViewBinding(): ActivityLoginBinding  =
        ActivityLoginBinding.inflate(layoutInflater)

    override fun observeData() {}


    private fun registerMove(){
        val intent = Intent(this,SignUpActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onBackPressed() {


        if (doubleBackToExit) {
            finishAffinity()
        } else {
            Toast.makeText(this, "종료하서려면 뒤로가기를 한번더 눌러주세요", Toast.LENGTH_SHORT).show()
            doubleBackToExit = true
            runDelayed(1500L) {
                doubleBackToExit = false
            }
        }
    }
    private fun runDelayed(millis: Long, function: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed(function, millis)
    }

}