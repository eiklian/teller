package com.elianan.teller.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.elianan.teller.R
import com.elianan.teller.data.models.Arcat
import com.elianan.teller.ui.theme.TellerTheme

@Composable
fun GemIcon(
    arcat: Arcat,
    painterRes: Int,
    contentDescription: String,

    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    size: Dp = 48.dp,
    paddingRatio: Int = 5,

) {


    Surface(
        shape = shape,
        color = arcat.containerColour(),
        contentColor = arcat.colour(),
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(painterRes),
            contentDescription = contentDescription,
            modifier = Modifier
                .size(size)
                .padding(size/paddingRatio)
        )
    }





}


@Preview(showSystemUi = true)
@Composable
private fun GemIconPreview() {

    TellerTheme {

        LoremIpsum()

        GemIcon(
            painterRes = R.drawable.sharp_price_change_24,
            arcat = Arcat.GRENT,
            contentDescription = "",
            modifier = Modifier.padding(60.dp)
        )

        GemIcon(
            painterRes = R.drawable.sharp_ramen_dining_24,
            arcat = Arcat.GREMLIN,
            contentDescription = "",
            size = 72.dp,
            shape = MaterialTheme.shapes.large,
            paddingRatio = 4,
            modifier = Modifier.padding(120.dp)
        )


    }

}