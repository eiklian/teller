package com.elianan.teller.ui.components

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.elianan.teller.R

@Composable
fun LoremIpsum(
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.bodyLarge
    ) {

    Text(
        text = stringResource(R.string.lorem_ipsum),
        style = textStyle,
        modifier = modifier.verticalScroll(rememberScrollState())
    )

}