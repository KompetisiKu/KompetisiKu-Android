package com.kompetisiku.app.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.components.FilterList
import com.kompetisiku.app.ui.components.SelectableItem
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Colors.primary)
                .padding(
                    Dimens.paddingHorizontalMedium,
                    Dimens.paddingVerticalMedium
                ),
        ) {
            Text(
                text = stringResource(R.string.greetings, "Irsal Fathi Farhat"),
                color = White,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        val itemList = listOf("Item 1", "Item 2", "Item 3")
        val selectedItems = remember { mutableStateListOf<String>() }

        FilterList(
            modifier = Modifier
                .background(White)
                .padding(
                    Dimens.paddingHorizontalMedium,
                    Dimens.paddingVerticalSmall
                ),
            onClick = {},
        ) {
            repeat(itemList.size) { index ->
                val item = itemList[index]
                SelectableItem(
                    value = item,
                    selected = selectedItems.contains(item),
                    onClick = {
                        if (selectedItems.contains(item)) {
                            selectedItems.remove(item)
                        } else {
                            if (selectedItems.size < 3) {
                                selectedItems.add(item)
                            }
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    KompetisiKuTheme {
        HomeScreen()
    }
}