package com.elianan.teller.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elianan.teller.models.Arcat
import com.elianan.teller.ui.theme.TellerTheme
import com.elianan.teller.ui.viewModels.ReceiptDetailViewModel

@Composable
fun ReceiptDetailScreen(
    receiptDetailViewModel: ReceiptDetailViewModel,
    modifier: Modifier = Modifier
) {

    Column {  }

}


@Preview
@Composable
private fun ReceiptDetailScreenPreview() {

    TellerTheme {
        ReceiptDetailScreen(

            receiptDetailViewModel = ReceiptDetailViewModel(
                editMode = true,
                arcat = Arcat.GRETCHEN
            )

        )
    }

}