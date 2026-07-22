package com.example.smartbankapplication.service

import com.example.smartbankapplication.model.Account

class BankService {

    fun deposit(
        account: Account,
        amount: Double
    ): Boolean {

        if (amount <= 0) {
            return false
        }
        if (!account.isActive) {
            return false
        }

        account.balance += amount
        return true
    }

    fun withdraw(
        account: Account,
        amount: Double
    ): Boolean {
        if (amount <= 0) {
            return false
        }
        if (!account.isActive) {
            return false
        }
        if (account.balance < amount) {
            return false
        }

        account.balance -= amount

        return true
    }


}