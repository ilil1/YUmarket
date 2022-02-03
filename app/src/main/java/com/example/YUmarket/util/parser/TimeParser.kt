package com.example.YUmarket.util.parser

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalTime

/**
 * LocalTime, LocalDateTime을 파싱하는데 사용하는 클래스
 * @author Doyeop Kim (main),
 * Geonwoo Kim, Heetae Heo, Namjin Jeong, Eunho Bae (sub)
 * @since 2022/01/31
 */
@RequiresApi(Build.VERSION_CODES.O)
sealed class TimeParser {

    class LocalTimeParser(val time: String) {
        companion object {
            fun execute(time: String): LocalTime {
                var hour: Int = 0
                var min = 0
                var sec = 0

                time.split(":").forEachIndexed { i, time ->
                    when(i) {
                        0 -> hour = time.toInt()
                        1 -> min = time.toInt()
                        2 -> sec = time.toInt()
                    }
                }

                return LocalTime.of(hour, min, sec)
            }
        }
    }

    class LocalDateTImeParser(val time: String) {

    }
}