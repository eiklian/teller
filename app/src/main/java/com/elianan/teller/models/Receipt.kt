package com.elianan.teller.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.YearMonth
import java.time.temporal.TemporalAccessor
import java.util.GregorianCalendar

data class Receipt(
    val receiptId: Long,

    val arcat: Arcat,
    val category: Category?,


    val paid: GregorianCalendar?,
    val plan: MonthRange?
) {
    @RequiresApi(Build.VERSION_CODES.O)
    fun monthPaid(): YearMonth? {
        return YearMonth.from(paid as TemporalAccessor?)
    }
}
