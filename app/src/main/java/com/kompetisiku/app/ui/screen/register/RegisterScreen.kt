package com.kompetisiku.app.ui.screen.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.ui.theme.KompetisiKuTheme

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {

    }
}

@Preview
@Composable
fun PreviewRegisterScreen() {
    KompetisiKuTheme {
        RegisterScreen()
    }
}
