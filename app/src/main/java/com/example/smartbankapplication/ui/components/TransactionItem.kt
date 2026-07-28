package com.example.smartbankapplication.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smartbankapplication.model.Transaction
import com.example.smartbankapplication.model.TransactionType
import com.example.smartbankapplication.ui.theme.SmartBankApplicationTheme

@Composable
fun TransactionItem(
    transaction: Transaction
) {

    val isDeposit = transaction.type == TransactionType.DEPOSIT

    val amountText =
        if (isDeposit) {
            "+ ${transaction.amount} TL"
        } else {
            "- ${transaction.amount} TL"
        }

    val amountColor =
        if (isDeposit) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.error
        }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),

        verticalAlignment = Alignment.CenterVertically

    ) {
        Box(
            modifier = Modifier.size(28.dp),
            contentAlignment = Alignment.Center
        ) {

            Icon(
                imageVector = if (isDeposit) {
                    Icons.Default.Add
                } else {
                    Icons.Default.Remove
                },
                contentDescription = null,
                tint = amountColor,
                modifier = Modifier.size(20.dp)
            )

        }
        Column(
            modifier = Modifier
                .weight(1f)
        ) {

            Text(
                text = transaction.description,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = transaction.type.name,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.secondary
            )

        }
        Spacer(
            modifier = Modifier.width(8.dp)
        )
        Text(
            text = amountText,
            style = MaterialTheme.typography.titleMedium,
            color = amountColor
        )
    }

}

@Preview(showBackground = true)
@Composable
fun TransactionItemPreview() {
    val previewTransaction = Transaction(
        id = 1,
        amount = 1000.0,
        type = TransactionType.DEPOSIT,
        description = "Money deposited"
    )

    SmartBankApplicationTheme {
        TransactionItem(
            transaction = previewTransaction
        )
    }
}
