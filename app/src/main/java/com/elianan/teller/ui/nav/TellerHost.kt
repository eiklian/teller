package com.elianan.teller.ui.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import androidx.navigation.toRoute
import com.elianan.teller.ui.layout.HomePager
import com.elianan.teller.ui.layout.ReceiptScreenRoot
import com.elianan.teller.ui.viewModels.ReceiptViewModel

@Composable
fun TellerHost(
    controller: NavHostController,
    paddingValues: PaddingValues
) {

    NavHost(
        controller, startDestination = Destination.Home,
//        typeMap = mapOf<KType, NavType<*>>(
//            Pair(Receipt, NavType.SerializableType<Receipt>)
//
//        ),
        modifier = Modifier.padding(paddingValues)) {
        composable<Destination.Home> {

            HomePager(
                onArcatClick = {
                    controller.goToNew(
                        Destination.ReceiptDetail(
                            arcat = it,
                            isNew = true,
                            receiptId = null
                        )
                    )
                },
                onHistoryItemClick = {}
            )
        }

        composable<Destination.ReceiptDetail> { backStackEntry ->
            val receiptDetail = backStackEntry.toRoute<Destination.ReceiptDetail>()
            ReceiptScreenRoot(
                viewModel = ReceiptViewModel(
                    initialReceiptInfo = receiptDetail,
                )
            )
        }

    }



}


fun NavHostController.goHome(){
    navigate(
        Destination.Home,
        navOptions {
            launchSingleTop = true
            popUpTo(Destination.Home) {
                inclusive = true
            }

        }
    )
}



fun NavHostController.goToNew(route: Destination) {
    navigate(route) {
        launchSingleTop = true
    }
}
