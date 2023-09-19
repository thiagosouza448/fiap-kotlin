package br.com.example.cardapiou.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@Composable
fun LoadingScreen(
    onAction: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            Modifier.align(Alignment.Center)
        )
    }
    LaunchedEffect(Unit) {
        delay(3000)
        onAction()
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun LoadingPreview() {
    LoadingScreen{}
}