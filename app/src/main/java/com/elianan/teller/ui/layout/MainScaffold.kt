package com.elianan.teller.ui.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elianan.teller.R
import com.elianan.teller.ui.components.LoremIpsum
import com.elianan.teller.ui.theme.TellerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(
    showFab: Boolean,
    onFabClick: () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable (PaddingValues) -> Unit
) {

    Scaffold(

        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                ),
                title = {
                    Text(stringResource(R.string.app_name))
                }
            )

        },

        floatingActionButton = {
            if (showFab) {
                FloatingActionButton(
                    onClick = onFabClick,
                    shape = MaterialTheme.shapes.small

                ) {
                    Icon(
                        painterResource(R.drawable.sharp_analytics_24),
                        contentDescription = "analytics"
                        )
                }

            }
        },

        content = content
    )





}


@Preview
@Composable
private fun MainScaffoldPreview() {
    TellerTheme {
        MainScaffold(
            showFab = true,
            onFabClick = {},
            content = {
                LoremIpsum(
                    modifier = Modifier.padding(it))
            }
        )
    }



}