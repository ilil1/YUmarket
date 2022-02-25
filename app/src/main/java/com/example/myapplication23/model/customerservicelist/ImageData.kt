package com.example.myapplication23.model.customerservicelist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageData(
    val csTitle : String,
    val csContent : String,
    val csAuthor: String,
    val csId: Long
) : Parcelable
