package com.elianan.teller.ui.viewModels

import com.elianan.teller.data.models.Arcat

data class ReceiptView(
    val receiptId: Long,
    val arcat: Arcat,
    val iconId: Int
)
