package com.kompetisiku.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun ProgressBar(
    modifier: Modifier = Modifier,
    progress: Int = 1,
    maxProgress: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Colors.primaryContainer)
            .padding(
                Dimens.paddingHorizontalExtraSmall,
                Dimens.paddingVerticalExtraSmall
            ),
        horizontalArrangement = Arrangement.spacedBy(
            Dimens.spaceSmall,
            Alignment.CenterHorizontally
        ),
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
            progress = progress.toFloat() / maxProgress,
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
fun PreviewProgressBar() {
    KompetisiKuTheme {
        ProgressBar(progress = 1, maxProgress = 2)
    }
}