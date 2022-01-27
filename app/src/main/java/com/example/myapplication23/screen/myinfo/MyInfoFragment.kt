package com.example.myapplication23.screen.myinfo

import android.app.Activity.RESULT_OK
import android.app.AlertDialog
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.myapplication23.R
import com.example.myapplication23.databinding.FragmentMyInfoBinding
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.customerservice.CSActivity
import com.example.myapplication23.screen.myinfo.customerservice.configuration.ConfigurationActivity
import com.example.myapplication23.screen.myinfo.customerservice.configuration.ConfigurationFragment
import com.example.myapplication23.screen.myinfo.customerservice.terms.TermsActivity
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*


/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */
@RequiresApi(Build.VERSION_CODES.O)
class MyInfoFragment : BaseFragment<MyInfoViewModel, FragmentMyInfoBinding>() {
    override val viewModel by viewModel<MyInfoViewModel>()

    /**
     *  requestCode를 설정해줘서 정상적인 기능작동인지 확인
     */
    val requestCode = 101;
    private val check = true;




    override fun getViewBinding() =
        FragmentMyInfoBinding.inflate(layoutInflater)

    override fun observeData() = with(binding) {
        initViewPager()

        /**
         * 추후 로그인 acesss->로 기능작동 하도록 initViewPager()뒤로 이동예정
         */
    }
    companion object {
        const val TAG = "MyInfoFragment"

        fun newInstance() : MyInfoFragment {
            return MyInfoFragment().apply{

            }
        }
    }




    private fun initViewPager() = with(binding) {
        binding.profileImageChange.setOnClickListener {
            loadImage()

        }
        binding.darkSwitch.setOnClickListener { darkMode() }
        binding.noticeText.setOnClickListener { popUp() }
        binding.centerTextview.setOnClickListener { openCSCenter() }
        binding.setting.setOnClickListener { openSetting() }
        binding.terms.setOnClickListener { openTerms() }
    }

    private fun loadImage(){

        var intent_image = Intent()
        intent_image.type = "image/*"
        intent_image.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(Intent.createChooser(intent_image,"Load Picture"),requestCode)

    }

    private fun openSetting(){
        activity.let {
            var intent = Intent(context, ConfigurationActivity::class.java)
            startActivity(intent)
        }
    }

    private fun openTerms(){
        activity.let {
            var intent = Intent(context, TermsActivity::class.java)
            startActivity(intent)
        }
    }


        // 추후 공부하기
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(101 == requestCode){
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
            //setDefualNightMode의 메서드가 Activity를 다시 생성하게 만든다 즉 MainActivity를 다시 만들어
            //버튼을 누르면 시작화면으로 돌아간다.


        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        }

    }

    private fun popUp(){
        val nowTime = System.currentTimeMillis()
        val date = Date(nowTime)
        val dateAndTime =
            SimpleDateFormat("MM-dd KK:mm ")
        val str_date = dateAndTime.format(date)



            val items = arrayOf("켜기", "끄기")
            var selectionItem: String? = null
            val alertDialog = AlertDialog.Builder(context)
                .setTitle("알림 설정")
                .setSingleChoiceItems(items,-1){
                    dialog,which->selectionItem = items[which]
                    while(selectionItem != null) {
                        if (selectionItem == "켜기") {
                            Toast.makeText(context, "설정 : "+str_date + "부터 알림 켜기를 설정했습니다.", Toast.LENGTH_SHORT)
                                .show()
                            break
                        }
                        if (selectionItem == "끄기") {
                            Toast.makeText(context, "설정 : " +str_date + "부터 알림 끄기를 설정했습니다.", Toast.LENGTH_SHORT)
                                .show()
                            break
                        }
                    }
                }
                .setPositiveButton("확인"){dialog,which->
                }

                .show()

    }


    override fun initViews() {
        super.initViews()

    }

    private fun openCSCenter(){
        activity.let {
            var intent = Intent(context, CSActivity::class.java)
            startActivity(intent)
        }
    }











}