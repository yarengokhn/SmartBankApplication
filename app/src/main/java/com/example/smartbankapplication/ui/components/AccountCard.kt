package com.example.smartbankapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartbankapplication.model.Account
import com.example.smartbankapplication.model.AccountType
import com.example.smartbankapplication.model.User
import com.example.smartbankapplication.ui.theme.SmartBankApplicationTheme


@Composable
fun AccountCard(
    account: Account
) {


    Card(

        modifier = Modifier
            .padding(16.dp),


        shape = RoundedCornerShape(20.dp),


        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )

    ) {


        Column(

            modifier = Modifier
                .padding(20.dp)

        ) {


            Text(
                text = account.accountType.name,

                style = MaterialTheme.typography.labelMedium,

                color = MaterialTheme.colorScheme.secondary
            )


            Text(
                text = "${account.balance} ${account.currency}",
                style = MaterialTheme.typography.displaySmall,
                color = MaterialTheme.colorScheme.primary

            )


            Text(
                text = account.accountNumber,

                style = MaterialTheme.typography.bodyMedium,

                color = MaterialTheme.colorScheme.onSurface
            )


            Text(
                text = "${account.owner.firstName} ${account.owner.lastName}",

                style = MaterialTheme.typography.titleMedium,

                color = MaterialTheme.colorScheme.onSurface
            )

        }

    }

}

@Preview(showBackground = true)
@Composable
fun AccountCardPreview() {

    val previewUser =
        User(
            id = 1,
            firstName = "Yaren",
            lastName = "Gökhan",
            email = "yaren@example.com",
            phoneNumber = "0555555555",
            age = 24,
            isActive = true
        )


    val previewAccount =
        Account(
            accountNumber = "TR000",
            owner = previewUser,
            accountType = AccountType.SAVINGS,
            balance = 1000.0,
            currency = "TL",
            isActive = true
        )


    SmartBankApplicationTheme {

        AccountCard(
            account = previewAccount
        )

    }
}