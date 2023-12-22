package com.kompetisiku.app.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.theme.Blue600
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    containerColor: Color = Colors.primary,
    text: String? = null,
    textColor: Color = White,
    borderColor: Color = Blue600,
    large: Boolean = false,
    onClick: () -> Unit,
    content: @Composable (() -> Unit)? = null
) {
    Button(
        modifier = modifier,
        border = BorderStroke(
            width = Dimens.borderButton,
            color = borderColor
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
        ),
        contentPadding = if (large) PaddingValues(
                Dimens.buttonPaddingHorizontalMedium,
                Dimens.buttonPaddingVerticalMedium
        ) else PaddingValues(
            Dimens.buttonPaddingHorizontalSmall,
            Dimens.buttonPaddingVerticalSmall
        ),
        onClick = { onClick() }
    ) {
        if (text != null) {
            Text(
                text = text,
                color = textColor,
                textAlign = TextAlign.Center,
                style = if (large) MaterialTheme.typography.bodyLarge else MaterialTheme.typography.bodyMedium
            )
        }
        if (content != null) {
            content()
        }
    }
}

@Preview
@Composable
fun AppButtonPreview() {
    KompetisiKuTheme {
        AppButton(text = stringResource(R.string.dummy_text), onClick = { })
    }
}