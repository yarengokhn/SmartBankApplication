package com.example.smartbankapplication.ui.state

import com.example.smartbankapplication.model.Account

//Ekranın ihtiyacı olan her şey tek bir state objesinde bulunur.
//Single Source of Truth
data class BankUiState(
    val account: Account? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
