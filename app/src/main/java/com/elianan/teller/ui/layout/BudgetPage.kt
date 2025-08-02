package com.elianan.teller.ui.layout

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elianan.teller.R
import com.elianan.teller.ui.components.GemFab
import com.elianan.teller.ui.components.LoremIpsum
import com.elianan.teller.ui.theme.TellerTheme

@Composable
fun BudgetPage(
    onBudgetFab: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            Spacer(modifier = Modifier.size(0.dp))
        },
        bottomBar = {
            Spacer(modifier = Modifier.size(0.dp))
        },
        floatingActionButton = {
            GemFab(
                onClick = onBudgetFab,
                painter = painterResource(R.drawable.sharp_analytics_24),
                contentDescription = "analyse"
            )
        },
        modifier = Modifier.fillMaxSize()

    ) {
        LoremIpsum(
            modifier = Modifier.padding(it)
        )
    }
}


@Preview
@Composable
private fun BudgetPagePreview() {

    TellerTheme {
        BudgetPage(
            onBudgetFab = {}
        )
    }

}