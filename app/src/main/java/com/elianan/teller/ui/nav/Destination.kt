package com.elianan.teller.ui.nav

import com.elianan.teller.data.models.Arcat
import kotlinx.serialization.Serializable


@Serializable
sealed interface Destination {
    @Serializable
    object Home: Destination;
    @Serializable
    data class ReceiptDetail(
        val arcat: Arcat,
        val isNew: Boolean,
        val receiptId: Long?
    ) : Destination
}