package com.kompetisiku.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.BuildConfig
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.Gray400
import com.kompetisiku.app.ui.theme.KompetisiKuTheme

@Composable
fun AppListItem(
    modifier: Modifier = Modifier,
    leadingIcon: ImageVector,
    trailingIcon: ImageVector,
    tint: Color? = null,
    headingContent: @Composable () -> Unit,
) {
    Row(
        modifier = modifier
            .padding(
                Dimens.paddingHorizontalMedium,
                Dimens.paddingVerticalSmall
            ),
        horizontalArrangement = Arrangement.spacedBy(Dimens.spaceMedium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = leadingIcon,
            contentDescription = null,
            tint = tint ?: Gray400
        )
        Column(
            Modifier.weight(1f)
        ) {
            headingContent()
        }
        Icon(
            imageVector = trailingIcon,
            contentDescription = null,
            tint = tint ?: Gray400
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAppListItem() {
    KompetisiKuTheme {
        AppListItem(
            leadingIcon = Icons.Rounded.Favorite,
            trailingIcon = Icons.Default.KeyboardArrowRight,
        ) {
            Text(
                text = stringResource(R.string.app_version, BuildConfig.VERSION_NAME),
                color = Gray400,
                maxLines = 1,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}