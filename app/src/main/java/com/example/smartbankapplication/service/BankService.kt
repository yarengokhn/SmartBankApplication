package com.example.smartbankapplication.service

import android.util.Log
import com.example.smartbankapplication.model.Account
import com.example.smartbankapplication.model.Transaction
import com.example.smartbankapplication.model.TransactionType
import com.example.smartbankapplication.model.User

class BankService {

    fun deposit(
        account: Account,
        amount: Double
    ): Account? {

        if (amount <= 0) {
            return null
        }
        if (!account.isActive) {
            return null
        }


        val transaction = Transaction(
            id = account.transactions.size + 1,
            amount = amount,
            type = TransactionType.DEPOSIT,
            description = "Money deposited"
        )

        return account.copy(
            balance = account.balance + amount,
            transactions = account.transactions + transaction

        )
    }

    fun withdraw(
        account: Account,
        amount: Double
    ): Account? {
        if (amount <= 0) {
            return null
        }
        if (!account.isActive) {
            return null
        }
        if (account.balance < amount) {
            return null
        }

        val transaction =
            Transaction(
                id = account.transactions.size + 1,
                amount = amount,
                type = TransactionType.WITHDRAW,
                description = "Money withdrawn"
            )


        return account.copy(
            balance = account.balance - amount,
            transactions = account.transactions + transaction
        )
    }

    fun getDepositTransactions(
        account: Account
    ): List<Transaction> {
        return account.transactions.filter {
            it.type == TransactionType.DEPOSIT
        }
    }

    fun getTotalDeposit(
        account: Account
    ): Double {

        return account.transactions
            .filter {
                it.type == TransactionType.DEPOSIT
            }
            .sumOf {
                it.amount
            }
    }

    fun getTransactionDescriptions(
        account: Account
    ): List<String> {

        return account.transactions.map {
            it.description
        }
    }

    fun findFirstWithdrawal(
        account: Account
    ): Transaction? {
        return account.transactions.find {
            it.type == TransactionType.WITHDRAW
        }
    }

    fun getWithdrawTransactions(
        account: Account
    ): List<Transaction> {

        return account.transactions.filter {
            it.type == TransactionType.WITHDRAW
        }
    }

    fun getTotalWithdraw(
        account: Account

    ): Double {
        return account.transactions
            .filter {
                it.type == TransactionType.WITHDRAW
            }
            .sumOf {
                it.amount
            }
    }

    fun printUserEmail(user: User) {
        user.email?.let { //if it is not null then run the code
            Log.d(
                "SMART_BANK",
                it
            )
        }
    }
}