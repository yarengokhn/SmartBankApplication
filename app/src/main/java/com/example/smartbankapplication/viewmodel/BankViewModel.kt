package com.example.smartbankapplication.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.smartbankapplication.model.Account
import com.example.smartbankapplication.model.AccountType
import com.example.smartbankapplication.model.Transaction
import com.example.smartbankapplication.model.TransactionType
import com.example.smartbankapplication.model.User
import com.example.smartbankapplication.service.BankService
import com.example.smartbankapplication.ui.state.BankUiState

class BankViewModel : ViewModel() {


    //İş mantığını Service'e bırakırım.
    private val bankService = BankService()


    // UI state değiştiğinde Compose ilgili composable'ları yeniden çizer.
    // Bu sürece recomposition denir.
    var uiState by mutableStateOf(
        BankUiState()
    )
        private set

    init {

        val user = User(
            id = 1,
            firstName = "Yaren",
            lastName = "Gökhan",
            email = "yaren@gmail.com",
            phoneNumber = "05555555555",
            age = 24,
            isActive = true
        )


        uiState = uiState.copy(

            account = Account(

                accountNumber = "TR111111111",

                owner = user,

                accountType = AccountType.SAVINGS,

                balance = 5000.0,

                currency = "EUR",

                isActive = true,

                transactions = listOf(
                    Transaction(
                        id = 1,
                        amount = 100.0,
                        type = TransactionType.DEPOSIT,
                        description = "Initial deposit"

                    )
                )

            )
        )

    }

    fun deposit(amount: Double) {

        val currentAccount = uiState.account ?: return

        val updatedAccount = bankService.deposit(
            currentAccount,
            amount

        )

        if (updatedAccount != null) {
            uiState = uiState.copy(
                account = updatedAccount

            )
        }
    }


    fun withdraw(amount: Double) {
        //return yapıp burda nullsa fonksiyondan çıkarıyoruz yani henüz hiç account yoksa
        val currentAccount = uiState.account ?: return

        val updatedAccount = bankService.withdraw(
            currentAccount,
            amount

        )

        if (updatedAccount != null) {
            uiState = uiState.copy(
                account = updatedAccount

            )
        }
    }
}