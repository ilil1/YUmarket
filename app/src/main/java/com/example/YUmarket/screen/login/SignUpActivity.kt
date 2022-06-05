package com.example.YUmarket.screen.login


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.YUmarket.databinding.ActivitySignupBinding
import com.example.YUmarket.screen.base.BaseActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.*
import java.util.concurrent.TimeUnit

class SignUpActivity : BaseActivity<ActivitySignupBinding>() {

    var number:String=""
    private var doubleBackToExit = false
    //create instance of firebae auth
    lateinit var auth: FirebaseAuth
    // get storedVerificationId
    //we will use this match the sent otp from firebase
    private var checkPhone = 0
    lateinit var  storedVerificationId:String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks:
            PhoneAuthProvider.OnVerificationStateChangedCallbacks


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun getViewBinding(): ActivitySignupBinding =
        ActivitySignupBinding.inflate(layoutInflater)

    override fun observeData() {}

    override fun initViews() = with(binding) {
        super.initViews()
        // auth
        auth = FirebaseAuth.getInstance()



        binding.confirm.visibility = View.INVISIBLE
        binding.confirmButton.visibility = View.INVISIBLE

        binding.signBtn.setOnClickListener {
            performRegister()
        }

        sendBtn.setOnClickListener {
            sendotp()
            val phone = editphone.text.toString()
            if(phone.isNotEmpty()) {
                confirm.visibility = View.VISIBLE
                confirmButton.visibility = View.VISIBLE
            }else{
                Toast.makeText(this@SignUpActivity,"전화번호를 입력해주세요",Toast.LENGTH_SHORT).show()
            }
        }

        //callback functuon for Phone Auth
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
               checkPhone = 1
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(this@SignUpActivity,"Error Phone Message$e",Toast.LENGTH_LONG).show()
            }

            //On code is sent by the firebase this method is called
            override fun onCodeSent(verificationId:String,token:PhoneAuthProvider.ForceResendingToken) {
                Log.d("Msg","onCodeSent:$verificationId")
                storedVerificationId = verificationId
                resendToken = token
            }

        }

        val otp = confirm.text.toString()
        if(otp.isNotEmpty()){
            val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(
                storedVerificationId.toString(),otp)
            signInWithPhoneAuthCredential(credential)
        }else{
            Toast.makeText(this@SignUpActivity,"Enter CheckNumer",Toast.LENGTH_SHORT).show()
        }


        back.setOnClickListener {
            back()
        }

    }

    //verifies if the code matches sent by firebase
    //if success start the new activity in our case we move LoginActivity

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential){
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this){task ->
                if(task.isSuccessful){
                    val intent = Intent(this,LoginActivity::class.java)
                    startActivity(intent)

                }else{
                    //Sign in failed
                    if(task.exception is FirebaseAuthInvalidCredentialsException){
                        Toast.makeText(this,"error",Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }



    private fun performRegister(){
        val email = binding.editEmail.text.toString()
        val password = binding.editpassword.text.toString()
        val username = binding.editname.text.toString()
        if (email.isEmpty() || password.isEmpty() || username.isEmpty()) {
            Toast.makeText(this, "이메일,비밀번호,이름 중에 비어져있는게 있습니다.", Toast.LENGTH_SHORT).show()
        }

        Log.d("SignUpFragment", "Email is " + email)
        Log.d("SignUpFragment", "password is + $password")


        // create a user with firebase
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (!it.isSuccessful) return@addOnCompleteListener

                // else if sucessful
                Log.d("Sing", "Successfully created user with uid: ${it.result.user?.uid}")
            }
            .addOnFailureListener {
                Log.d("Sign", "Faild to create user: ${it.message}")
                Toast.makeText(this, "Faild to create user: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun sendotp(){
        number = binding.editphone.text.toString()

        //get the phone number from edit text and append the country code
        if(number.isNotEmpty()){
            number = "+82$number"
            sendVerificationCode(number)
        }else{
            Toast.makeText(this,"Enter mobile number",Toast.LENGTH_LONG).show()
        }
    }

    //this method sends the verification code
    //and starts the callback of verification
    //which is implemented above in onCreate

    private fun sendVerificationCode(number:String){
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(number)//Phone number to verify
            .setTimeout(60L,TimeUnit.SECONDS)// Timeout
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
        Log.d("MGS","Auth started")
    }

    private fun back(){
        val intent = Intent(this,LoginActivity::class.java)
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


//    companion object {
//        const val TAG = "SingUpFragment"
//
//        fun newInstance(): SignUpActivity {
//            return SignUpActivity().apply {
//
//            }
//        }
//    }
}