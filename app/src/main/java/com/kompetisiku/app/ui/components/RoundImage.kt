package com.kompetisiku.app.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.theme.KompetisiKuTheme

@Composable
fun RoundImage(
    modifier: Modifier = Modifier,
    image: Painter
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier
            .aspectRatio(1f, matchHeightConstraintsFirst = true)
            .clip(CircleShape)
    )
}

@Preview
@Composable
fun PreviewRoundImage() {
    KompetisiKuTheme {
        RoundImage(image = painterResource(R.drawable.image_placeholder))
    }
}