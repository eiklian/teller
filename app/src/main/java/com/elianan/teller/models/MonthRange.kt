package com.elianan.teller.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.YearMonth
import java.time.temporal.ChronoUnit

data class MonthRange(
    val rangeStart: YearMonth,
    val rangeEnd: YearMonth
) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun length(): Int {
        return (rangeStart.until(rangeEnd, ChronoUnit.MONTHS) + 1L).toInt()
    }

}
