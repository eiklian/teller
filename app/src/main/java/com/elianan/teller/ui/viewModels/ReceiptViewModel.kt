package com.elianan.teller.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.elianan.teller.data.entities.Receipt
import com.elianan.teller.ui.nav.Destination

class ReceiptViewModel(
    initialReceiptInfo: Destination.ReceiptDetail
): ViewModel() {


    var editMode: Boolean by mutableStateOf(true)
        private set


    var receiptInfo: Receipt? by mutableStateOf<Receipt?>(null)
        private set


    var cost: String by mutableStateOf("")
    private set

    init {

        receiptInfo = Receipt(initialReceiptInfo)

        cost = (if(initialReceiptInfo.isNew) 5f else 0f).toString()

        editMode = initialReceiptInfo.isNew

        //        todo load receipt info

    }


    fun fab(){
        editMode = !editMode
    }

    fun onCostChange(newCost: String){
//        todo format / validate
        this.cost = newCost

    }


}
