package com.example.smartbankapplication.model

data class Transaction(

    val id: Int,

    val amount: Double,

    val type: TransactionType,

    val description: String,
)
