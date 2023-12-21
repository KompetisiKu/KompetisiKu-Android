package com.kompetisiku.app.ui.components

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White

@Composable
fun ProgressBarPercentage(
    modifier: Modifier = Modifier,
    progress: Int = 1,
    maxProgress: Int,
    label: String,
) {
    val animatedProgress = remember { Animatable(initialValue = 0f) }

    LaunchedEffect(progress) {
        animatedProgress.animateTo(progress.toFloat() / maxProgress, animationSpec = tween(1000))
    }

    Column(
        modifier
            .background(Colors.primaryContainer)
            .padding(
                Dimens.paddingHorizontalMedium,
                Dimens.paddingVerticalMedium
            ),
        verticalArrangement = Arrangement.spacedBy(Dimens.spaceExtraSmall)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(Dimens.spaceSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
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
                text = ((progress.toFloat() / maxProgress * 100).toInt()).toString() + "%",
                color = White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Text(
            text = label,
            color = White,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
fun PreviewProgressBarPercentage() {
    KompetisiKuTheme {
        ProgressBarPercentage(progress = 1, maxProgress = 2, label = stringResource(R.string.profile_progress))
    }
}