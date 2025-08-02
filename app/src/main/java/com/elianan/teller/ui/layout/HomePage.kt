package com.elianan.teller.ui.layout

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elianan.teller.models.Arcat
import com.elianan.teller.ui.components.GemIconButton
import com.elianan.teller.ui.theme.TellerTheme
import com.elianan.teller.ui.theme.Typography

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
                .padding(buttonPadding)


        ) {
            Card(
                onClick = {},
                colors = CardDefaults.cardColors(
                    containerColor = Arcat.GRELD.containerColour(),
                    contentColor = Arcat.GRELD.onContainerColour()
                ),

                modifier = modifier.wrapContentSize()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.padding(16.dp)
                        .fillMaxSize()
                ) {
                    Icon(
                        painterResource(Arcat.GRELD.iconId),
                        contentDescription = "",
                        Modifier.fillMaxSize()
                            .weight(0.2f)
                    )
                    Text(
                        stringResource(Arcat.GRELD.nameStringId),
                        fontStyle = Typography.titleMedium.fontStyle,
                        modifier = Modifier.weight(0.8f)
                            .wrapContentSize()

                    )
                }
            }

            GemIconButton(
                onClick = {},
                Arcat.GRELD,
                modifier = modifier.padding(buttonPadding)
            )
        }


    }
}


@Preview(
    uiMode = Configuration.UI_MODE_TYPE_NORMAL,
    showSystemUi = false, showBackground = true
)
@Composable
private fun HomePagePreview() {

    TellerTheme { HomePage() }



}