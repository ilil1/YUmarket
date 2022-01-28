package com.example.myapplication23.model.customerservicelist

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication23.data.repository.myinfo.CSRepository
import com.example.myapplication23.model.CellType
import com.example.myapplication23.model.Model
import com.example.myapplication23.screen.myinfo.customerservice.list.CSCategory

/**
 * @author HeeTae Heo(main),
 * Geonwoo Kim, Doyeop Kim, Namjin Jeong, Eunho Bae (sub)
 * @since
 * @throws
 * @description
 */


data class CSModel(
    override val id:Long,
    override val type: CellType = CellType.CUSTOMER_SERVICE_CELL,
    val csInfoId: Long,
    val csCategory: CSCategory,
    val csTitle: String,
    val csAuthor:String,
    val csContent:String

    ): Model(id,type) {

    fun CSModel(csRepository: CSRepository){
        id
        csTitle
        csAuthor
        csInfoId
        csContent

    }







    companion object {
        val DIFF_CALLBACK = object: DiffUtil.ItemCallback<CSModel>() {
            override fun areItemsTheSame(oldItem: CSModel, newItem: CSModel): Boolean {
                return oldItem.id == newItem.id && oldItem.type == newItem.type
            }

            // TODO equal?
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: CSModel, newItem: CSModel): Boolean {
                return oldItem == newItem
            }

        }
    }

    }
