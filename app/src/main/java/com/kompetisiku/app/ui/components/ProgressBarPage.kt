package com.kompetisiku.app.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White

@Composable
fun ProgressBarPage(
    modifier: Modifier = Modifier,
    progress: Int = 1,
    maxProgress: Int
) {
    val animatedProgress = remember { Animatable(initialValue = 0f) }

    LaunchedEffect(progress) {
        animatedProgress.animateTo(progress.toFloat() / maxProgress, animationSpec = tween(1000))
    }

    Row(
        modifier = modifier
            .background(Colors.primaryContainer)
            .padding(
                Dimens.paddingHorizontalExtraSmall,
                Dimens.paddingVerticalExtraSmall
            ),
        horizontalArrangement = Arrangement.spacedBy(Dimens.spaceSmall),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.padding(
                Dimens.paddingHorizontalMedium,
                Dimens.paddingDefault
            ),
            text = progress.toString(),
            color = White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
        LinearProgressIndicator(
            modifier = Modifier
                .weight(1f)
                .size(Dimens.progressBarHeight)
            ,
            progress = animatedProgress.value,
            color = Colors.secondary,
            trackColor = White,
            strokeCap = StrokeCap.Round,
        )
        Text(
            modifier = Modifier.padding(
                Dimens.paddingHorizontalMedium,
                Dimens.paddingDefault
            ),
            text = maxProgress.toString(),
            color = White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview
@Composable
fun PreviewProgressBarPage() {
    KompetisiKuTheme {
        ProgressBarPage(progress = 1, maxProgress = 2)
    }
}