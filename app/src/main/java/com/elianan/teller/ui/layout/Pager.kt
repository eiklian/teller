package com.elianan.teller.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.tooling.preview.Preview
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
            TextButton (
                onClick = { targetedTab = 0 }
                ) {
                Text("History",
                    fontStyle = Typography.labelSmall.fontStyle
                )
            }

            TextButton(
                onClick = { targetedTab = 1}
            ) {
                Text("Log",
                    fontStyle = Typography.labelSmall.fontStyle)
            }

            TextButton(
                onClick = { targetedTab = 2 }
            ) { Text("Budget",
                fontStyle = Typography.labelSmall.fontStyle) }

        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when(page){
                0 -> {
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis pretium consectetur. Suspendisse sapien magna, tincidunt vel sagittis ac, pharetra eget erat. Nunc tempus volutpat purus, et ullamcorper orci ornare ut. Praesent consequat, orci nec elementum pretium, elit arcu vulputate ipsum, ac cursus nulla felis ut enim. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Cras at ante facilisis, dapibus risus sed, lobortis mauris. Quisque id augue diam. Duis quis nulla eget mi hendrerit interdum. Sed hendrerit sollicitudin orci, sed molestie ligula bibendum non. Donec tortor nisl, vehicula eget lectus vitae, dictum bibendum elit.",
                        fontStyle = Typography.headlineLarge.fontStyle
                    )
                }
                1 -> {HomePage()}
                2 -> {}
            }
        }
    }

}


@Composable
fun TabButton(modifier: Modifier = Modifier) {
    TextButton(
        onClick = {  },
        modifier = Modifier,
    ) {
        Text("Log")
    }
    
}



@Preview(showBackground = false, showSystemUi = true)
@Composable
private fun HomePagerPreview() {
    TellerTheme { HomePager() }

}