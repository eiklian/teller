package com.elianan.teller.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.elianan.teller.R

@Composable
fun LoremIpsum(
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    includePadding: Boolean = true
    ) {

    Text(
        text = stringResource(R.string.lorem_ipsum),
        style = textStyle,
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(all = if(includePadding) 12.dp else 0.dp)
    )

}