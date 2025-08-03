package com.elianan.teller.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Budget(
    @PrimaryKey(autoGenerate = true)
    val budgetId: Long,
    val gretchen: Float,
    val gremlin: Float,
    val label: String?

)