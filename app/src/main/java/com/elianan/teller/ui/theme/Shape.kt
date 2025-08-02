package com.elianan.teller.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Shapes
import androidx.compose.ui.graphics.RectangleShape


val Diamond = CutCornerShape(50)

val PointedGem = CutCornerShape(40)

val EvenGem= CutCornerShape(33)

val Octagon = CutCornerShape(25)

val SquareGem = CutCornerShape(20)



val FixedGem = CutCornerShape(16.dp)



val gemShapes = Shapes(
    extraSmall = CutCornerShape(0),
    small = SquareGem,
    medium = Octagon,
    large = EvenGem,
    extraLarge = PointedGem
)


@Preview(showSystemUi = true, showBackground = false)
@Composable
private fun ShapesPreview() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize()
    ) {
        Card(shape = Diamond){ Text("diamond", modifier = Modifier.padding(16.dp)) }

        Card(shape = PointedGem){ Text("pointed gem", modifier = Modifier.padding(16.dp)) }

        Card(shape = EvenGem){ Text("even gem", modifier = Modifier.padding(16.dp)) }

        Card(shape = Octagon) { Text("octagon", modifier = Modifier.padding(16.dp)) }

        Card(shape = SquareGem) { Text("square gem", modifier = Modifier.padding(16.dp)) }
    }

}