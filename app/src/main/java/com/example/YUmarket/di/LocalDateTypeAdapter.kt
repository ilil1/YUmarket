package com.example.YUmarket.di

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * LocalDate 타입을 gson에서 parse할 수 있도록 해주는 adapter
 * @author Doyeop Kim (main)
 * @since 2022/01/28
 */
class LocalDateTypeAdapter : TypeAdapter<LocalDate>() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun write(out: JsonWriter, value: LocalDate) {
        out.value(DateTimeFormatter.ISO_LOCAL_DATE.format(value))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun read(`in`: JsonReader): LocalDate = LocalDate.parse(`in`.nextString())
}