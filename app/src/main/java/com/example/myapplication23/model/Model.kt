package com.example.myapplication23.model

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

abstract class Model(
    open val id : Long,
    open val type : CellType
) {
    companion object {
        val DIFF_CALLBACK = object: DiffUtil.ItemCallback<Model>() {
            override fun areItemsTheSame(oldItem: Model, newItem: Model): Boolean {
                return oldItem.id == newItem.id && oldItem.type == newItem.type
            }

            // TODO equal?
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: Model, newItem: Model): Boolean {
                return oldItem == newItem  //참조객체가 같은지 즉 메모리의 주소가 같은지 확인
                                            //카테고리에 따라 다시 시작하면서 id가 같은경우가 존재할
                                            //수가 있는데 그럴경우 참조객체를 검사해서 같은 카테고리인지
                                            //확인하는 느낌
                                            // 문자열의 경우 두 개의 문자열의 value가 같다면 하나의 메모리에서
                                    //value를 reference하기때문에 === 검사를 했을 때 true가 나온다.
            }

        }
    }
}