package com.elianan.teller.ui.layout

import android.R.attr.start
import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elianan.teller.models.Arcat
import com.elianan.teller.ui.components.GemIconButton
import com.elianan.teller.ui.theme.TellerTheme
import com.elianan.teller.ui.theme.Typography

@Composable

fun HomePage(
    onArcatClick: (Arcat) -> Unit,
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
                onClick = {onArcatClick(Arcat.GRETCHEN)},
                Arcat.GRETCHEN,
                modifier = Modifier.weight(1f)
                    .padding(buttonPadding)
            )
            GemIconButton(
                onClick = {onArcatClick(Arcat.GREMLIN)},
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
                onClick = {onArcatClick(Arcat.GREBE)},
                Arcat.GREBE,
                modifier = Modifier.weight(1f)
                    .padding(buttonPadding)

            )
            GemIconButton(
                onClick = {onArcatClick(Arcat.GRENT)},
                Arcat.GRENT,
                modifier = Modifier.weight(1f)
                    .padding(buttonPadding)
            )

        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.weight(.8f)
                .padding(buttonPadding)


        ) {
            Card(
                onClick = {onArcatClick(Arcat.GRELD)},
                colors = CardDefaults.cardColors(
                    containerColor = Arcat.GRELD.containerColour(),
                    contentColor = Arcat.GRELD.onContainerColour()
                ),
                border = BorderStroke(width = 16.dp, color = Arcat.GRELD.containerColour()),

                modifier = modifier.fillMaxSize()

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,

                    modifier = Modifier.padding(24.dp)
                        .fillMaxHeight()
                        .fillMaxWidth(.8f)
                ) {
                    Icon(
                        painterResource(Arcat.GRELD.iconId),
                        contentDescription = "",
                        Modifier
                            .fillMaxHeight()
                            .aspectRatio(1f)
//                            .fillMaxSize()
//                            .weight(1f)
//                            .padding(start = 24.dp)
                    )
                    Text(
                        stringResource(Arcat.GRELD.nameStringId),
                        style = MaterialTheme.typography.displaySmall,
                        fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
//                            .padding(horizontal = 36.dp)
//                            .weight(3f)
//                            .wrapContentSize()

                    )




                }
            }


        }


    }
}


@Preview(
    uiMode = Configuration.UI_MODE_TYPE_NORMAL,
    showSystemUi = false, showBackground = true
)
@Composable
private fun HomePagePreview() {

    TellerTheme { HomePage(
        onArcatClick = {}
    ) }



}