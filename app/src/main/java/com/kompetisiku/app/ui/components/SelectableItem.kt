package com.kompetisiku.app.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.theme.Blue600
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.Gray200
import com.kompetisiku.app.ui.theme.Gray400
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White

@Composable
fun SelectableItem(
    modifier: Modifier = Modifier,
    value: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier
            .border(
                width = Dimens.borderButton,
                color = if (selected) Blue600 else Gray200,
                shape = MaterialTheme.shapes.extraLarge
            )
            .clip(MaterialTheme.shapes.extraLarge)
            .background(if (selected) Colors.primary else White)
            .clickable {
                println("Item clicked: $value, isSelected: $selected")
                onClick()
            }
            .padding(
                Dimens.paddingHorizontalMedium,
                Dimens.paddingVerticalSmall
            )
    ) {
        Text(
            text = value,
            color = if (selected) White else Gray400,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
fun PreviewSelectableItem() {
    KompetisiKuTheme {
        var isSelected by remember { mutableStateOf(false) }

        SelectableItem(
            value = stringResource(R.string.dummy_text),
            selected = isSelected,
            onClick = {
                isSelected = !isSelected
            }
        )
    }
}