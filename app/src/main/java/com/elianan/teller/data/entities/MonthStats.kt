package com.elianan.teller.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elianan.teller.data.entities.Budget
import java.time.YearMonth

@Entity
data class MonthStats(
    @PrimaryKey
    val date: YearMonth,
    val budgetId: Long

//    receiptIds
//    relevant plans
//    total change per arcat?





)