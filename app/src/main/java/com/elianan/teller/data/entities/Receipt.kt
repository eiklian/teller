package com.elianan.teller.data.entities

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.elianan.teller.data.models.Arcat
import com.elianan.teller.data.entities.SubCat
import com.elianan.teller.data.models.MonthRange
import com.elianan.teller.ui.nav.Destination
import java.time.YearMonth
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalAccessor
import java.util.GregorianCalendar

@Entity
data class Receipt(

    @PrimaryKey(autoGenerate = true)
    val receiptId: Long,

    val arcat: Arcat,

    val subCatId: Long?,

    val label: String?,

    val cost: Float,


    val paid: GregorianCalendar?,
    val plan: MonthRange?,


) {

    @Ignore var subCat: SubCat? = null



    @RequiresApi(Build.VERSION_CODES.O)
    fun monthPaid(): YearMonth? {
        return YearMonth.from(paid as TemporalAccessor?)
    }


    constructor(arcat: Arcat): this(
        receiptId = 0L,
        arcat = arcat,
//        subCat = null,
        label = null,
        subCatId = null,
        cost = 5f,
//        todo make default cost a global const
        paid = null,
        plan = null
    )

    constructor(destinationInfo: Destination.ReceiptDetail): this(
        receiptId = destinationInfo.receiptId ?: 0L,
        arcat = destinationInfo.arcat,
//        subCat = null,
        label = null,
        subCatId = null,
        cost = if(destinationInfo.isNew) 5f else 0f,
        paid = null,
        plan = null
    )










}