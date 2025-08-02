package com.elianan.teller.ui.layout

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.util.copy
import com.elianan.teller.R
import com.elianan.teller.models.Arcat
import com.elianan.teller.ui.components.GemFab
import com.elianan.teller.ui.components.LoremIpsum
import com.elianan.teller.ui.theme.Diamond
import com.elianan.teller.ui.theme.TellerTheme
import com.elianan.teller.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePager(

    onHistoryItemClick: () -> Unit,
    onArcatClick: (Arcat) -> Unit,


    modifier: Modifier = Modifier
) {

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
                    HistoryPage()
                }
                1 -> {
                    HomePage(
                        onArcatClick = onArcatClick
                    )
                }
                2 -> {

                    BudgetPage(
                        onBudgetFab = {}
                    )

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
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(8.dp),


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
    TellerTheme { HomePager(
        onArcatClick = {},
        onHistoryItemClick = {}
    ) }

}