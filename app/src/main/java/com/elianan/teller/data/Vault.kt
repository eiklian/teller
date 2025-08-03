package com.elianan.teller.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.elianan.teller.data.entities.ReceiptDao
import com.elianan.teller.data.entities.Budget
import com.elianan.teller.data.entities.MonthStats
import com.elianan.teller.data.entities.Receipt
import com.elianan.teller.data.entities.SubCat


@Database(
    version = 1,
    entities = [
        Receipt::class,
        SubCat::class,
        Budget::class,
        MonthStats::class
    ]
)
@TypeConverters(Converters::class)
abstract class Vault: RoomDatabase() {

//    abstract fun exampleDao(): ExampleDao


    abstract fun receiptDao(): ReceiptDao


    companion object{
        fun build(applicationContext: Context): Vault {
            return Room.databaseBuilder(
                context = applicationContext,
                klass = Vault::class.java,
                name = "teller-vault"
            ).build()
        }
    }

}