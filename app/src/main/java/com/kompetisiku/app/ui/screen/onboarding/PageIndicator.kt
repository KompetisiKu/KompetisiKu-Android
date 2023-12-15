package com.kompetisiku.app.ui.screen.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.ui.theme.Blue200
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    activePage: Int,
    activeColor: Color = MaterialTheme.colorScheme.secondary,
    defaultColor: Color = Blue200
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(Dimens.spaceLarge)
    ) {
        repeat(pageSize) { page ->
            Box(
                modifier = Modifier
                    .width(Dimens.pageIndicatorWidth)
                    .height(Dimens.pageIndicatorHeight)
                    .background(color = if (page == activePage) activeColor else defaultColor)
            )
        }
    }
}

@Preview
@Composable
fun PreviewPageIndicator() {
    KompetisiKuTheme {
        PageIndicator(pageSize = 3, activePage = 0)
    }
}