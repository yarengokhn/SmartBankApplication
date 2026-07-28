package com.example.smartbankapplication.model

data class Account(

    val accountNumber: String,

    val owner: User, //Object Composition

    val accountType: AccountType,

    var balance: Double, //var means  mutable(changeable)

    val currency: String,  // val --> read-only

    val isActive: Boolean,

    val transactions: MutableList<Transaction> = mutableListOf()

)
