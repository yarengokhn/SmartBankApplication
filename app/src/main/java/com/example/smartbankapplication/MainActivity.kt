package com.example.smartbankapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.smartbankapplication.model.Account
import com.example.smartbankapplication.model.AccountType
import com.example.smartbankapplication.model.User
import com.example.smartbankapplication.service.BankService
import com.example.smartbankapplication.ui.theme.SmartBankApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val user = User(
            id = 1,
            firstName = "Yaren",
            lastName = "Gökhan",
            email = "yarengokhn@gmail.com",
            phoneNumber = "044444444444",
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

        Log.d(
            "SMART_BANK",
            account.toString()
        )

        val bankService = BankService() //object creation

        val result = bankService.deposit(
            account,
            1000.0

        )

        val withdrawResult = bankService.withdraw(
            account,
            2000.0
        )

        Log.d(
            "SMART_BANK",
            "Deposit success: $result"
        )

        Log.d(
            "SMART_BANK",
            "Withdraw: $withdrawResult"
        )

        setContent {
            SmartBankApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SmartBankApplicationTheme {
        Greeting("Android")
    }
}
