package com.elianan.teller.ui.layout

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elianan.teller.models.Arcat
import com.elianan.teller.ui.components.GemIconButton

@Composable

fun HomePage(
    modifier: Modifier = Modifier
) {


    val buttonPadding = 16.dp

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxSize()
            .padding(buttonPadding/2)

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .weight(2f)
        ) {
            GemIconButton(
                onClick = {},
                Arcat.GRETCHEN,
                modifier = Modifier.weight(1f)
                    .padding(buttonPadding)
            )
            GemIconButton(
                onClick = {},
                Arcat.GREMLIN,
                modifier = Modifier.weight(1f)
                    .padding(buttonPadding)
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier.fillMaxWidth()
                .weight(2f)
        ) {
            GemIconButton(
                onClick = {},
                Arcat.GREBE,
                modifier = Modifier.weight(1f)
                    .padding(buttonPadding)

            )
            GemIconButton(
                onClick = {},
                Arcat.GRENT,
                modifier = Modifier.weight(1f)
                    .padding(buttonPadding)
            )

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(1f)

        ) {
            GemIconButton(
                onClick = {},
                Arcat.GRELD,
                modifier = modifier.padding(buttonPadding)
            )
        }


    }
}


@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL)
@Composable
private fun HomePagePreview() {

    HomePage()

}