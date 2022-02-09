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
): Model(id,type)


