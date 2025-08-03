package com.elianan.teller.ui.layout

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elianan.teller.R
import com.elianan.teller.ui.components.GemFab
import com.elianan.teller.ui.theme.TellerTheme
import com.elianan.teller.ui.viewModels.ReceiptViewModel




@Composable
fun ReceiptScreenRoot(
    viewModel: ReceiptViewModel
) {

    ReceiptDetailScreen(
        onFabClick = { viewModel.fab() },
        editMode = viewModel.editMode,
        cost = viewModel.cost,
        onCostChange = viewModel::onCostChange
    )

}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReceiptDetailScreen(
    onFabClick: () -> Unit,
    editMode: Boolean,
    cost: String,
    onCostChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {


    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {},
                actions = {
                    if(editMode){
                        FilledTonalButton (
                            onClick =  {},
                            shape = MaterialTheme.shapes.medium,
                            modifier = Modifier.border(
                                8.dp,
                                MaterialTheme.colorScheme.secondaryContainer,
                                MaterialTheme.shapes.medium
                            )

                        ) {
                            Text("change category")
                        }
                    }

                }
//                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        },
        floatingActionButton ={
            GemFab(
                onClick = onFabClick,
                painter = if(editMode) painterResource(R.drawable.sharp_save_24)
                    else painterResource(R.drawable.sharp_edit_24),
                contentDescription = if(editMode) "" else ""
            )
        }
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {


            TextField(
                value = cost,
                onValueChange = onCostChange,
                readOnly = !editMode,
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Decimal,
                    imeAction = ImeAction.Done
                ),
//                keyboardActions = KeyboardActions.Default.onDone
                textStyle = LocalTextStyle.current.copy(
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .wrapContentSize()

            )


//        todo choose from
//          new entry
//          tick off monthly
//          other repeat
//              search templates via label?
//          yet unpaid (from plan or otherwise)

//        todo change arcat

//        todo edit cost

//        todo change metadata
//          cat
//          label
//          date

//        todo extra financial details
//          use as template
//          setup payment plan

        }
    }


}


@Preview
@Composable
private fun ReceiptDetailScreenPreview() {


    var editMode by remember { mutableStateOf(true) }
    var cost by remember { mutableStateOf("") }


    TellerTheme {
        ReceiptDetailScreen(
            onFabClick = {
                editMode = !editMode
            },
            editMode,
            cost = cost,
            onCostChange = {
                cost = it
            }

        )
    }

}