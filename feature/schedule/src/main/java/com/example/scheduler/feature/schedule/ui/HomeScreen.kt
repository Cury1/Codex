package com.example.scheduler.feature.schedule.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    onOpenSettings: () -> Unit,
    onEventSelected: (Long) -> Unit,
    onCreateEvent: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Your schedule",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onEventSelected(1L) }) {
            Text(text = "View sample event")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onCreateEvent) {
            Text(text = "Create new event")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = onOpenSettings) {
            Text(text = "Settings")
        }
    }
}
