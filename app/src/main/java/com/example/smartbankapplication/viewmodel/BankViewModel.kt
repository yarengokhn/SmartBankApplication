package com.example.smartbankapplication.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartbankapplication.model.Account
import com.example.smartbankapplication.model.AccountType
import com.example.smartbankapplication.model.Transaction
import com.example.smartbankapplication.model.TransactionType
import com.example.smartbankapplication.model.User
import com.example.smartbankapplication.repository.BankRepository
import com.example.smartbankapplication.ui.state.BankUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BankViewModel : ViewModel() {

    //StateFlow
    // _uiState değiştirilebilir
    private val _uiState = MutableStateFlow(
        BankUiState()
    )

    // uiState read only ve public
    val uiState: StateFlow<BankUiState> = _uiState.asStateFlow()

    // Veri işlemlerini Repository yönetir.
    private val repository = BankRepository()

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


        _uiState.value = _uiState.value.copy(

            account = Account(

                accountNumber = "TR111111111",

                owner = user,

                accountType = AccountType.SAVINGS,

                balance = 5000.0,

                currency = "TL",

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


        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                isLoading = true,
                error = null
            )

            val currentAccount = _uiState.value.account ?: return@launch

            val updatedAccount = repository.deposit(
                currentAccount,
                amount

            )
            if (updatedAccount != null) {
                _uiState.value = _uiState.value.copy(
                    account = updatedAccount,
                    isLoading = false

                )
            } else {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Deposit failed"

                )
            }

        }

    }


    fun withdraw(amount: Double) {
        //return yapıp burda nullsa fonksiyondan çıkarıyoruz yani henüz hiç account yoksa

        viewModelScope.launch {

            _uiState.value = _uiState.value.copy(
                isLoading = true,
                error = null
            )

            val currentAccount = _uiState.value.account ?: return@launch

            val updatedAccount = repository.withdraw(
                currentAccount,
                amount

            )
            if (updatedAccount != null) {
                _uiState.value = _uiState.value.copy(
                    account = updatedAccount,
                    isLoading = false

                )
            } else {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = "Withdrawal failed"

                )
            }

        }

    }
}