package com.kompetisiku.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.theme.Black500
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White

@Composable
fun FieldItemContainer(
    modifier: Modifier = Modifier,
    label: String,
    description: String? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Column(
        modifier = modifier
            .background(White)
            .padding(vertical = Dimens.paddingVerticalLarge),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimens.spaceMedium)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.paddingHorizontalMedium),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(Dimens.spaceSmall)
        ) {
            Text(
                text = label,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.titleMedium
            )
            if (description != null) {
                Text(
                    text = description,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            content()
        }
        if (trailingContent != null) {
            trailingContent()
        }
    }
}

@Preview
@Composable
fun PreviewFieldItemContainer() {
    KompetisiKuTheme {
        FieldItemContainer(
            label = stringResource(R.string.account_settings),
        ) {
            AppListItem(
                modifier = Modifier
                    .clickable {  },
                leadingIcon = Icons.Rounded.Favorite,
                trailingIcon = Icons.Rounded.KeyboardArrowRight
            ) {
                Text(
                    text = stringResource(R.string.wishlist_competition),
                    color = Black500,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}