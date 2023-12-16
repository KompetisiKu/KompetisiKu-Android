package com.kompetisiku.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun AppIconButton(
    modifier: Modifier = Modifier,
    containerColor: Color = Colors.primary,
    text: String,
    imageVector: ImageVector,
    fillMaxWidth: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = if (fillMaxWidth) modifier
            .fillMaxWidth() else modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor
        ),
        contentPadding = PaddingValues(
            Dimens.buttonPaddingHorizontalMedium,
            Dimens.buttonPaddingVerticalMedium
        ),
        onClick = { onClick() }
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(Dimens.spaceSmall)
        ) {
            Text(
                text = text,
                color = White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge
            )
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
fun AppIconButtonPreview() {
    KompetisiKuTheme {
        AppIconButton(text = stringResource(R.string.dummy_text), imageVector = Icons.Rounded.ArrowForward,onClick = { })
    }
}