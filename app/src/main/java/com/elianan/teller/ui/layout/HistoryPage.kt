package com.elianan.teller.ui.layout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elianan.teller.ui.components.LoremIpsum
import com.elianan.teller.ui.theme.TellerTheme

@Composable
fun HistoryPage(modifier: Modifier = Modifier) {

    LoremIpsum()

}


@Preview
@Composable
private fun HistoryPagePreview() {
    TellerTheme {
        HistoryPage()
    }

}