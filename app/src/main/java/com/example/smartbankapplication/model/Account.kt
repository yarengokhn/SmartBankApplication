package com.example.smartbankapplication.model

data class Account(

    val accountNumber: String,

    val owner: User, //Object Composition

    val accountType: AccountType,

    val balance: Double,

    val currency: String,  // val --> read-only

    val isActive: Boolean,

    // eski yaklaşım val transactions: MutableList<Transaction> = mutableListOf()
    val transactions: List<Transaction> = emptyList()
)
