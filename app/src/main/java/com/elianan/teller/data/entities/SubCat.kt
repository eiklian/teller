package com.elianan.teller.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elianan.teller.data.models.Arcat

@Entity
data class SubCat(

    @PrimaryKey(autoGenerate = true)
    val categoryId: Long = 0L,

    val name: String,
    val arcat: Arcat,
    val painterId: Int

) {


}