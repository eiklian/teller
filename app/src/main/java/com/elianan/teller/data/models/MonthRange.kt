package com.elianan.teller.data.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.YearMonth
import java.time.temporal.ChronoUnit

data class MonthRange(
    val start: YearMonth,
    val end: YearMonth
) {



    @RequiresApi(Build.VERSION_CODES.O)
    fun planLength(): Int {
        return (start.until(end, ChronoUnit.MONTHS) + 1L).toInt()

    }


}