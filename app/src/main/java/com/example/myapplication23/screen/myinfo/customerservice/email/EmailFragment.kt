package com.example.myapplication23.screen.myinfo.customerservice.email

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.drawToBitmap
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.clearFragmentResult
import com.example.myapplication23.databinding.FragmentEmailBinding
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.customerservice.CSActivity
import com.example.myapplication23.screen.myinfo.customerservice.CSCenterFragment
import com.example.myapplication23.screen.myinfo.customerservice.CSViewModel
import com.example.myapplication23.screen.myinfo.customerservice.list.CSFragment
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.Exception

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */
class EmailFragment  : BaseFragment<CSViewModel, FragmentEmailBinding>() {
    private val requestCode = 101

    override val viewModel by viewModel<CSViewModel>()


    override fun getViewBinding(): FragmentEmailBinding =
    FragmentEmailBinding.inflate(layoutInflater)


    override fun observeData() {
        initViewPager()

    }
    private fun initViewPager() = with(binding){
        binding.emailSend.setOnClickListener { sendEmail() }
    }


    private fun sendEmail() {
        val emailAddress = "gege2848@naver.com"
        val title = binding.titleEdit.text.toString()
        val content = binding.contentEdit.text
        val intent = Intent(Intent.ACTION_SENDTO)
            .apply {
                type = "text/plain"
                data = Uri.parse("mailto:")


                putExtra(Intent.EXTRA_EMAIL, arrayOf(emailAddress))
                putExtra(Intent.EXTRA_SUBJECT, title )
                putExtra(Intent.EXTRA_TEXT, content )

            }

        if (Intent.EXTRA_SUBJECT != null) {

                startActivity(Intent.createChooser(intent,"Send Email"))


        } else
        Toast.makeText(context, "제목을 입력해주세요", Toast.LENGTH_SHORT).show()
    }




    companion object{
        const val TAG = "EmailFragment"

        fun newInstance() : EmailFragment {
            return EmailFragment().apply {

            }
        }
    }


}