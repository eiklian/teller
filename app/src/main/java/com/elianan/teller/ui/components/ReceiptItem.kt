package com.elianan.teller.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.elianan.teller.data.entities.Receipt
import com.elianan.teller.data.models.Arcat
import com.elianan.teller.ui.theme.TellerTheme

@Composable
fun ReceiptItem(
    receipt: Receipt,
    onClick: (Receipt) -> Unit,
    modifier: Modifier = Modifier
) {

    val catName = receipt.subCat?.name ?: stringResource(receipt.arcat.nameStringId)



    val costString = buildAnnotatedString {
        withStyle(
            style = MaterialTheme.typography.titleMedium.toSpanStyle()
        ) {
            append("£")
            append(receipt.cost.toString())
            append("0")
        }
        if (receipt.label != null) {
            withStyle(
                style = MaterialTheme.typography.labelMedium.toSpanStyle()
            ) {
                append("  for ${receipt.label}")
            }
        }

    }


    Column(
        verticalArrangement = Arrangement.spacedBy((-6).dp),
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = {
                onClick(receipt)
            })

    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy((-16).dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            GemIcon(
                painterRes = receipt.subCat?.painterId ?: receipt.arcat.iconId,
                contentDescription = "",
                arcat = receipt.arcat,
                size = 56.dp,
                modifier = Modifier.zIndex(2f)

            )

            Surface(
                color = MaterialTheme.colorScheme.surfaceContainerLow,
                modifier = Modifier
                    .zIndex(1f)
                    .fillMaxWidth()

            ) {
                Text(
                    costString,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(8.dp)
                        .padding(start = 24.dp)
                )

            }

        }

        Text(
            text = receipt.paid.toString(),
            style = MaterialTheme.typography.labelSmall,
            textAlign = TextAlign.End,
            modifier = Modifier
                .align(Alignment.End)
                .padding(horizontal = 16.dp)
        )


    }






}


@Preview(showSystemUi = true)
@Composable
private fun ReceiptItemPreview() {

    TellerTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.fillMaxSize()
        ) {
            ReceiptItem(
                Receipt(
                    arcat = Arcat.GREBE
                ).copy(label = "so much super cool epic funsies"),
                onClick = {},
                modifier = Modifier.padding(vertical = 60.dp, horizontal = 16.dp)
            )

        }




    }

}