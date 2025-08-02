package com.elianan.teller.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.elianan.teller.R
import com.elianan.teller.ui.components.LoremIpsum
import com.elianan.teller.ui.theme.TellerTheme
import com.elianan.teller.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePager(modifier: Modifier = Modifier) {

    val pagerState = rememberPagerState(
        initialPage = 1,
        pageCount = { 3 }
    )
    var targetedTab by remember {
        mutableIntStateOf(pagerState.settledPage)
    }

    LaunchedEffect(targetedTab) {
        pagerState.scrollToPage(targetedTab)
    }

    Column(
        modifier = modifier
    ){
        TabRow (pagerState.currentPage
        ) {
            TabButton (
                label = "History",
                onClick = {
                    if (targetedTab  == 0) {
//                        TODO: scroll to top
                    } else targetedTab = 0

                }
                )

            TabButton(
                label = "Log",
                onClick = { targetedTab = 1}
            )

            TabButton(
                label = "Budget",
                onClick = { targetedTab = 2 }
            )

        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when(page){
                0 -> {
                    LoremIpsum()
                }
                1 -> {
                    HomePage()
                }
                2 -> {
                    LoremIpsum()
                }
            }
        }
    }

}


@Composable
fun TabButton(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.extraSmall,
        modifier = Modifier,
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
//            fontStyle = Typography.labelMedium.fontStyle,
//            fontFamily = Typography.headlineSmall.fontFamily
        )
    }
    
}



@Preview(showBackground = false, showSystemUi = true)
@Composable
private fun HomePagerPreview() {
    TellerTheme { HomePager() }

}