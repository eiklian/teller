package com.elianan.teller.data.entities

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.elianan.teller.data.entities.Receipt
import kotlinx.coroutines.flow.Flow


@Dao
interface ReceiptDao {

    @Insert(onConflict = REPLACE)
    fun update(vararg receipt: Receipt)

    @Delete
    fun delete(vararg receipt: Receipt)


    @Query(
        "SELECT * FROM receipt WHERE receiptId LIKE :receiptId"
    )
    fun loadFromId(receiptId: Long): Receipt


    @Query(
        "SELECT * FROM receipt WHERE paid IS NOT NULL " +
                "ORDER BY paid DESC"
    )
    fun pastReceipts(): Flow<Receipt>










}