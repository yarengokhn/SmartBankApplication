package com.example.smartbankapplication.repository

import com.example.smartbankapplication.model.Account
import com.example.smartbankapplication.service.BankService

class BankRepository {

    private val bankService = BankService()

    suspend fun deposit(
        account: Account,
        amount: Double
    ): Account? {

        return bankService.deposit(
            account,
            amount
        )

    }

    //threadı kilitlemez beklerken dieğer işler yürütülür
    suspend fun withdraw(
        account: Account,
        amount: Double
    ): Account? {

        return bankService.withdraw(
            account,
            amount
        )

    }

}