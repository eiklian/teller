package com.elianan.teller.ui.components

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elianan.teller.R
import com.elianan.teller.ui.theme.TellerTheme

@Composable
fun GemFab(
    onClick: () -> Unit,
    painter: Painter,
    contentDescription: String,
    modifier: Modifier = Modifier
) {

    FloatingActionButton (
        onClick = onClick,
//        todo
//          animate click: scale out then in
//          change elevation
        shape = MaterialTheme.shapes.small,
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
        modifier = modifier
//            .border(
//                width = 4.dp,
//                shape = MaterialTheme.shapes.small,
//                color = MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.2f)
//            )
            .size(72.dp)
            .border(
                width = 12.dp,
                shape = MaterialTheme.shapes.small,
                color = MaterialTheme.colorScheme.tertiaryContainer
            )

//            .background(
//                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.2f)
//            )

    ) {
        Icon(
            painter, contentDescription,
            Modifier
//                .background(
//                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.4f),
//                    shape = MaterialTheme.shapes.extraSmall
//                )
                .size(30.dp)
//                .padding(4.dp)


        )

    }

}


@Preview
@Composable
private fun GemFabPreview() {
    TellerTheme {
        Scaffold(
            floatingActionButton = {
                GemFab(
                    onClick = {},
                    painter = painterResource(R.drawable.sharp_mountain_flag_24),
                    contentDescription = ""
                )
            }
        ) {
            LoremIpsum(
                textStyle = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.onBackground
                ),
                modifier = Modifier.padding(it)
            )
        }

    }
}


