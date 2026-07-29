package com.example.smartbankapplication.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smartbankapplication.ui.components.AccountCard
import com.example.smartbankapplication.ui.components.TransactionItem
import com.example.smartbankapplication.viewmodel.BankViewModel


@Composable
fun DashboardScreen(
    viewModel: BankViewModel
) {


    val uiState = viewModel.uiState


    var amountText by remember {
        mutableStateOf("")
    }


    val account = uiState.account ?: return



    LazyColumn(

        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(8.dp)

    ) {


        item {


            AccountCard(
                account = account
            )


        }



        item {


            TextField(

                value = amountText,

                onValueChange = {
                    amountText = it
                },

                label = {
                    Text(
                        text = "Amount"
                    )
                },

                modifier = Modifier
                    .fillMaxWidth()

            )


        }



        item {


            Row {


                Button(

                    onClick = {

                        val amount = amountText.toDoubleOrNull()

                        if (amount != null) {

                            viewModel.deposit(amount)

                            amountText = ""

                        }

                    }

                ) {


                    Text(
                        text = "Deposit"
                    )


                }



                Spacer(

                    modifier = Modifier
                        .width(8.dp)

                )



                Button(

                    onClick = {

                        val amount = amountText.toDoubleOrNull()

                        if (amount != null) {

                            viewModel.withdraw(amount)

                            amountText = ""

                        }

                    }

                ) {


                    Text(
                        text = "Withdraw"
                    )


                }


            }


        }



        item {


            Text(

                text = "Recent Transactions",

                style = MaterialTheme.typography.titleLarge,

                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        bottom = 8.dp
                    )

            )


        }



        if (account.transactions.isEmpty()) {


            item {


                Text(

                    text = "No transactions yet",

                    style = MaterialTheme.typography.bodyLarge

                )


            }


        } else {


            items(account.transactions) { transaction ->


                TransactionItem(

                    transaction = transaction

                )


            }


        }


    }


}