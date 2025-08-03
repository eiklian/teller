package com.elianan.teller.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import com.elianan.teller.data.models.MonthRange
import java.time.Month
import java.time.Year
import java.time.YearMonth
import java.util.Calendar
import java.util.GregorianCalendar

class Converters {

    @TypeConverter
    fun gregCalToLong(gregCal: GregorianCalendar?): Long? {
        return gregCal?.timeInMillis
    }

    @TypeConverter
    fun longToGregCal(timeMillis: Long?): GregorianCalendar? {
        return if (timeMillis != null) {
            GregorianCalendar().apply { timeInMillis = timeMillis }
        } else null

    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun yearMonthToPair(yearMonth: YearMonth?): Pair<Int, Month>? {
        return if (yearMonth != null) {
            Pair(yearMonth.year, yearMonth.month)
        } else null
    }


    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun pairToYearMonth(ints: Pair<Int, Month>?): YearMonth? {

        if (ints != null) {
            var ym = YearMonth.now()
            ym = ym.withYear(ints.first)
            ym = ym.withMonth(ints.second.value)

            return ym
        }
        return null

    }


    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun yearMonthToStr(yearMonth: YearMonth): String {
        return "${yearMonth.year}" + "-" +
                "${yearMonth.monthValue}"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun strToYearMonth(string: String): YearMonth {
        val parts = string.split("-").map {
            it -> it.toIntOrNull()
        }

        var ym = YearMonth.now()

        if (parts.size == 2) {
            parts[0]?.let { ym = ym.withYear(it) }
            parts[1]?.let {
                ym = ym.withMonth(it)
            }
        }
        return ym
    }



    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun monthRangeToStr(monthRange: MonthRange): String{
        val returnStr =
            "${monthRange.start.year}" + "-" +
            "${monthRange.start.monthValue}" + "-" +
            "${monthRange.end.year}" + "-" +
            "${monthRange.end.monthValue}" + "-"
        return returnStr
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun strToMonthRange(string: String): MonthRange? {
        val parts = string.split("-").map {
            str -> str.toIntOrNull().also { if (it == null) return@strToMonthRange null }
        }
        if (parts.size == 4 ) {

            return MonthRange(
                start = YearMonth.now().withYear(parts[0]!!).withMonth(parts[1]!!),
                end = YearMonth.now().withYear(parts[2]!!).withMonth(parts[3]!!)
            )

        }
        return null
    }







}