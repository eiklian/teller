package com.elianan.teller.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elianan.teller.models.Arcat
import com.elianan.teller.ui.theme.ColourFamily
import com.elianan.teller.ui.theme.Purple40
import com.elianan.teller.ui.theme.TellerTheme
import com.elianan.teller.ui.theme.Typography

@Composable

fun GemIconButton(
    onClick: () -> Unit,
    arcat: Arcat,
    modifier: Modifier = Modifier
){
    Card(
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = arcat.containerColour(),
            contentColor = arcat.onContainerColour()
        ),
//        shape = CutCornerShape(30),
        shape = MaterialTheme.shapes.large,

        modifier = modifier.wrapContentSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
//                .padding(24.dp)
                .fillMaxSize()
        ) {
            Icon(
                painterResource(arcat.iconId),
                contentDescription = "",
                Modifier.fillMaxWidth(.8f)
                    .aspectRatio(1f)
//                    .weight(30f)

            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                stringResource(arcat.nameStringId),
                style = MaterialTheme.typography.displaySmall,
                fontSize = MaterialTheme.typography.titleLarge.fontSize,
                overflow = TextOverflow.Visible,
                textAlign = TextAlign.Center,
//                fontStyle = Typography.titleMedium.fontStyle
//                modifier = Modifier.weight(15f)

            )
        }
    }
}


@Preview(uiMode = Configuration.UI_MODE_TYPE_NORMAL, showBackground = false, showSystemUi = false)
@Composable
fun PreviewGretchen() {
    TellerTheme { GemIconButton(
        onClick = {},
        arcat = Arcat.GRETCHEN
    ) }

}
