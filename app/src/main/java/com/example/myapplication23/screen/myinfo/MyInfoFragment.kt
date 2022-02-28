package com.example.myapplication23.screen.myinfo

import android.app.Activity.RESULT_OK
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.myapplication23.R
import com.example.myapplication23.databinding.FragmentMyInfoBinding
import com.example.myapplication23.screen.MainActivity
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.customerservice.center.CSCenterActivity
import com.example.myapplication23.screen.myinfo.customerservice.configuration.ConfigurationFragment
import com.example.myapplication23.screen.myinfo.customerservice.personal.PersonalFragment
import com.example.myapplication23.screen.myinfo.customerservice.terms.TermsFragment
import java.lang.Exception


/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */
@RequiresApi(Build.VERSION_CODES.O)
class MyInfoFragment  : BaseFragment< FragmentMyInfoBinding>()  {


    private lateinit var getResultImage : ActivityResultLauncher<Intent>


    private fun popUp() {
        requireContext().let { it1 -> PopUpMethod().popUp(it1) }
    }


    private val check = true;

    override fun getViewBinding() :FragmentMyInfoBinding =
        FragmentMyInfoBinding.inflate(layoutInflater)

    override fun observeData()  {

        /**
         * 추후 로그인 acesss->로 기능작동 하도록 initView()뒤로 이동예정
         */
    }
    companion object {
        const val TAG = "MyInfoFragment"

        fun newInstance() : MyInfoFragment {
            return MyInfoFragment().apply{

            }
        }
    }

    override fun initViews() = with(view)  {
        super.initViews()

        binding.terms.setOnClickListener {  view?.findViewById<TextView>(R.id.terms)!!.setOnClickListener {
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_myInfoFragment_to_termsFragment) }
        } }

        binding.profileImageChange.setOnClickListener { loadImage()}

        binding.darkSwitch.setOnClickListener { darkMode() }


        binding.noticeText.setOnClickListener { popUp() }

      binding.centerTextview.setOnClickListener { openCSCenter() }
     //   binding.setting.setOnClickListener { openSetting() }
      //  binding.personalTextview.setOnClickListener { openPersonal() }
     //   binding.back.setOnClickListener { back() }




        getResultImage = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
            result -> if(result.resultCode == RESULT_OK){
            val dataUri : Uri? = result.data?.data
            try {
                val bitmap : Bitmap = MediaStore.Images.Media.getBitmap(context?.contentResolver,dataUri)
                binding.profileImage.setImageBitmap(bitmap)
            }  catch (e: Exception) {
                Toast.makeText(context,"$e",Toast.LENGTH_SHORT).show()
            }
        }
        }

    }

    private fun loadImage(){

        var intent_image = Intent()
        intent_image.type = "image/*"
        intent_image.action = Intent.ACTION_GET_CONTENT

        getResultImage.launch(intent_image)
//        startActivityForResult(Intent.createChooser(intent_image,"Load Picture"),galley)
    }

    private fun openSetting(){
        activity?.let {
            var intent = Intent(context, ConfigurationFragment::class.java)
            startActivity(intent)
        }
    }

//    private fun openTerms(){
//        requireActivity().supportFragmentManager.beginTransaction().replace(TermsFragment(),
//            TAG).commit()
//    }

    private fun openPersonal(){
        activity?.let {
            var intent = Intent(context, PersonalFragment::class.java)
            startActivity(intent)
        }
    }

    private fun back(){
        activity?.let{
            var intent = Intent(context,MainActivity::class.java)
            startActivity(intent)
        }
    }




//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(galley == requestCode){
//            if(resultCode == RESULT_OK){
//                val dataUri : Uri? = data?.data
//                try {
//                    val bitmap : Bitmap = MediaStore.Images.Media.getBitmap(context?.contentResolver,dataUri)
//                    binding.profileImage.setImageBitmap(bitmap)
//                }  catch (e: Exception) {
//                    Toast.makeText(context,"$e",Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }

    private fun darkMode(){
        if(check  == binding.darkSwitch.isChecked){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
    private fun darkPopUp(){
        val alertDialog = AlertDialog.Builder(context)
            .setTitle("주의")
            // 다크모드 사용시 어플의 재시작으로 저장되어있던 데이터가 사라질 수 있다는 경고 식의 dialog 생성후
            // 사용자가 선택하여 사용할 수 있도록 도와줌
    }


    private fun openCSCenter(){
        activity?.let {
            var intent = Intent(context, CSCenterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showFragment(fragment: Fragment, tag: String) {
        requireActivity().supportFragmentManager.beginTransaction().add(fragment, tag).commit()
    }
}