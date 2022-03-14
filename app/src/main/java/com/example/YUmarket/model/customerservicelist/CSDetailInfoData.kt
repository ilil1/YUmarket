package com.example.YUmarket.model.customerservicelist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CSDetailInfoData(
    val csTitle : String,
    val csContent : String,
    val csAuthor: String,
) : Parcelable
