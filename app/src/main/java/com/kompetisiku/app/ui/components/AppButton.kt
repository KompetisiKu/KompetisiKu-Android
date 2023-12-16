package com.kompetisiku.app.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    containerColor: Color = Colors.primary,
    text: String,
    imageVector: ImageVector? = null,
    large: Boolean = false,
    fillMaxWidth: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = if (fillMaxWidth) modifier
            .fillMaxWidth() else modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor
        ),
        contentPadding = if (large) {
            PaddingValues(
                Dimens.buttonPaddingHorizontalMedium,
                Dimens.buttonPaddingVerticalMedium
            )
        } else PaddingValues(),
        onClick = { onClick() }
    ) {
        Text(
            text = text,
            color = White,
            textAlign = TextAlign.Center,
            style = if (large) MaterialTheme.typography.bodyLarge else MaterialTheme.typography.bodyMedium
        )
        if (imageVector != null) {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                tint = White
            )
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