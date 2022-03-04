package com.example.myapplication23.screen.myinfo.customerservice.personal

import androidx.navigation.Navigation
import com.example.myapplication23.R
import com.example.myapplication23.databinding.FragmentPersonalBinding
import com.example.myapplication23.screen.base.BaseFragment

class PersonalFragment: BaseFragment<FragmentPersonalBinding>() {

    override fun getViewBinding(): FragmentPersonalBinding =
        FragmentPersonalBinding.inflate(layoutInflater)

    override fun observeData() = with(binding) {

    }

    override fun initViews() {

        binding.configurationLeft.setOnClickListener {
            back()

        }
    }

    private fun back(){
        view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_personalFragment_to_myInfoFragment)}

        view?.let{it1 ->
            Navigation.findNavController(it1).popBackStack()
        }
    }

}
