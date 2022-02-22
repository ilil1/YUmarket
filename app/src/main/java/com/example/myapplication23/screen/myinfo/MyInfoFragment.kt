package com.example.myapplication23.screen.myinfo

import android.app.Activity.RESULT_OK
import android.app.AlertDialog
import android.app.Application
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.viewModels
import com.example.myapplication23.databinding.FragmentMyInfoBinding
import com.example.myapplication23.screen.MainActivity
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.customerservice.center.CSCenterActivity
import com.example.myapplication23.screen.myinfo.customerservice.configuration.ConfigurationActivity
import com.example.myapplication23.screen.myinfo.customerservice.personal.PersonalActivity
import com.example.myapplication23.screen.myinfo.customerservice.terms.TermsActivity
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature


/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */
@RequiresApi(Build.VERSION_CODES.O)
class MyInfoFragment  : BaseFragment<MyInfoViewModel, FragmentMyInfoBinding>()  {

    override val viewModel by viewModel<MyInfoViewModel>()



    private fun popUp() {
        context?.let { it1 -> Method().popUp(it1) }
    }


    val galley = 101;
    private val check = true;

    override fun getViewBinding() =
        FragmentMyInfoBinding.inflate(layoutInflater)

    override fun observeData() = with(viewModel) {

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

    override fun initViews() = with(viewModel) {
        super.initViews()
        binding.profileImageChange.setOnClickListener { loadImage()}
        binding.darkSwitch.setOnClickListener { darkMode() }
        binding.noticeText.setOnClickListener { popUp() }
        binding.centerTextview.setOnClickListener { openCSCenter() }
        binding.setting.setOnClickListener { openSetting() }
        binding.terms.setOnClickListener { openTerms() }
        binding.personalTextview.setOnClickListener { openPersonal() }
    }

    private fun loadImage(){

        var intent_image = Intent()
        intent_image.type = "image/*"
        intent_image.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(intent_image,"Load Picture"),galley)
    }

    private fun openSetting(){
        activity?.let {
            var intent = Intent(context, ConfigurationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openTerms(){
        activity?.let {
            var intent = Intent(context, TermsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openPersonal(){
        activity?.let {
            var intent = Intent(context, PersonalActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(galley == requestCode){
            if(resultCode == RESULT_OK){
                val dataUri : Uri? = data?.data
                try {
                    val bitmap : Bitmap = MediaStore.Images.Media.getBitmap(context?.contentResolver,dataUri)
                    binding.profileImage.setImageBitmap(bitmap)
                }  catch (e: Exception) {
                    Toast.makeText(context,"$e",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
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
}