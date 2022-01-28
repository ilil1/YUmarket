package com.example.myapplication23.screen.myinfo.customerservice

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.myapplication23.R
import com.example.myapplication23.databinding.FragmentCsCenterBinding
import com.example.myapplication23.screen.base.BaseFragment
import com.example.myapplication23.screen.myinfo.customerservice.email.EmailFragment
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */

class CSCenterFragment : BaseFragment<CSViewModel,FragmentCsCenterBinding>(){



    override val viewModel by viewModel<CSViewModel>()

    override fun getViewBinding(): FragmentCsCenterBinding =
        FragmentCsCenterBinding.inflate(layoutInflater)


    override fun observeData() {
        initViewPager()
    }

    private fun initViewPager() = with(binding){
        binding.questionCenter.setOnClickListener{
            transfer(CSFragment())
        }

        binding.centerNumber.setOnClickListener {
            permissionCheck()
            callYU()
        }

        binding.pollution.setOnClickListener {
            permissionCheck()
            foodSafecall()
        }

        binding.emailCenter.setOnClickListener {
            emailBox(EmailFragment())
        }
    }


    private fun YUcall(){

        val myuri =Uri.parse("tel:00011112222")
        var intent = Intent(Intent.ACTION_CALL,myuri)
        startActivity(intent)
    }

    private fun foodcall(){

        val myuri =Uri.parse("tel:1399")
        var intent = Intent(Intent.ACTION_CALL,myuri)
        startActivity(intent)
    }

    private fun callYU() {
        val items = "000-1111-2222"
        val alertDialog = AlertDialog.Builder(context)
            .setTitle("YU Market")
            .setMessage(items)
            .setPositiveButton("통화 걸기",
            DialogInterface.OnClickListener{
                dialog, id->
                YUcall()
            })
            .setNegativeButton("통화 취소",
                DialogInterface.OnClickListener { dialog, id->
                Toast.makeText(context,"통화를 취소했습니다.",Toast.LENGTH_SHORT).show()
                })
            .show()

    }

    private fun foodSafecall() {
        val items = "1399"
        val alertDialog = AlertDialog.Builder(context)
            .setTitle("불량식품 신고")
            .setMessage(items)
            .setPositiveButton("통화 걸기",
                DialogInterface.OnClickListener{
                        dialog, id->
                    foodcall()
                })
            .setNegativeButton("통화 취소",
                DialogInterface.OnClickListener { dialog, id->
                    Toast.makeText(context,"통화를 취소했습니다.",Toast.LENGTH_SHORT).show()
                })
            .show()

    }

    private fun emailBox(fragment: Fragment) {
        activity?.let {
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, EmailFragment.newInstance(),"myinfo")
                .commit()
        }

    }

  private fun permissionCheck()
    {   val callCheck =
        android.Manifest.permission.CALL_PHONE

        val permission =
            ContextCompat
        .checkSelfPermission(binding.centerNumber.context,android.Manifest.permission.CALL_PHONE)
        if(permission == PackageManager.PERMISSION_GRANTED){

        }
        else {
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(android.Manifest.permission.CALL_PHONE),0)
        }

    }


    private fun transfer(fragment: CSFragment) {
        activity?.let {
            var intent = Intent(context, CSCenterActivity::class.java)
            startActivity(intent)
        }
    }

    companion object{
            const val TAG = "CSCenterFragment"

            fun newInstance() : CSCenterFragment{
                return CSCenterFragment().apply {

                }
            }
    }



}


