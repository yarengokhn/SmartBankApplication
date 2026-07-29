package com.example.smartbankapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.smartbankapplication.ui.screens.DashboardScreen
import com.example.smartbankapplication.ui.theme.SmartBankApplicationTheme
import com.example.smartbankapplication.viewmodel.BankViewModel


class MainActivity : ComponentActivity() {


    private val viewModel: BankViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {

            SmartBankApplicationTheme {

                DashboardScreen(viewModel)

            }

        }
    }
}