package com.example.YUmarket.di.gsonAdapter

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * LocalDateTime의 타입을 gson에 등록해주는 adapter
 * @author Doyeop Kim (main)
 *
 * @since 2022/01/28
 */
class LocalDateTimeTypeAdapter : TypeAdapter<LocalDateTime>() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun write(out: JsonWriter, value: LocalDateTime) {
        out.value(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(value))
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun read(`in`: JsonReader): LocalDateTime = LocalDateTime.parse(`in`.nextString())
}