package com.abelvolpi.nfc_app.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ReceiveScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "ReceiveScreen", modifier = Modifier.align(Alignment.Center))
    }
}

@Preview(showBackground = true)
@Composable
fun ReceiveScreenPreview() {
    ReceiveScreen()
}
