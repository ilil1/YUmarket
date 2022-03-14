package com.example.YUmarket.screen.myinfo.customerservice.email


import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.example.YUmarket.model.customerservicelist.EmailData

class EmailMethod() {

     fun sendEmail(emailFragment: EmailFragment) {
        val emaildata = EmailData(
            "gege2848@naver.com",
            emailFragment.getViewBinding().titleEdit.text.toString(),
            emailFragment.getViewBinding().contentEdit.text.toString())
//            binding.titleEdit.text.toString(),
//            binding.contentEdit.text.toString())
//        val emailAddress = "gege2848@naver.com"
//        val title = binding.titleEdit.text.toString()
//        val content = binding.contentEdit.text.toString()
        val intent = Intent(Intent.ACTION_SENDTO)
            .apply {
                type = "text/plain"
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_EMAIL, arrayOf(emaildata.emailAddress))
                putExtra(Intent.EXTRA_SUBJECT, emaildata.title )
                putExtra(Intent.EXTRA_TEXT,  emaildata.content  )
            }

        if (emaildata.title =="" || emaildata.title == null || emaildata.content == "" ||  emaildata.content  == null) {
            Toast.makeText(emailFragment.context, "제목 또는 내용을 입력해주세요", Toast.LENGTH_SHORT).show()
        }
        else {
            emailFragment.startActivity(Intent.createChooser(intent, "Send Email"))

        }

    }
}