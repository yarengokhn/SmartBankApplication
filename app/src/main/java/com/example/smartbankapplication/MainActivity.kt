package com.example.smartbankapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.example.smartbankapplication.model.Account
import com.example.smartbankapplication.model.AccountType
import com.example.smartbankapplication.model.User
import com.example.smartbankapplication.ui.components.AccountCard
import com.example.smartbankapplication.ui.theme.SmartBankApplicationTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()


        val user = User(
            id = 1,
            firstName = "Yaren",
            lastName = "Gökhan",
            email = "yaren@test.com",
            phoneNumber = "0555555555",
            age = 24,
            isActive = true
        )


        val account = Account(

            accountNumber = "TR111111111",

            owner = user,

            accountType = AccountType.SAVINGS,

            balance = 5000.0,

            currency = "EUR",

            isActive = true

        )


        setContent {

            SmartBankApplicationTheme {

                AccountCard(
                    account = account
                )

            }

        }

    }
}