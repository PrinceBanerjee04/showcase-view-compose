package com.example.showcaseview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SampleShowcase() {
    var showShowcase by remember { mutableStateOf(true) }

    Box(Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { /* Do something */ }) {
                Text("Button 1")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { /* Do something */ }) {
                Text("Button 2")
            }
        }

        if (showShowcase) {
            ShowcaseView(
                targetContent = {
                    Button(onClick = { /* Do something */ }) {
                        Text("Button 2")
                    }
                },
                showcaseContent = {
                    Box(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(8.dp)
                    ) {
                        Text("This is Button 2", color = Color.Black)
                    }
                }
            )
        }
    }
}
