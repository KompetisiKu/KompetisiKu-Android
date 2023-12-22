package com.kompetisiku.app.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.Gray200
import com.kompetisiku.app.ui.theme.Gray400
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White

@Composable
fun FilterList(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(Dimens.spaceSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            content()
        }
        AppButton(
            containerColor = White,
            borderColor = Gray200,
            onClick = onClick
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.filter),
                contentDescription = null,
                tint = Gray400
            )
        }
    }
}

@Preview
@Composable
fun PreviewFilterList() {
    KompetisiKuTheme {
        val itemList = listOf("Item 1", "Item 2", "Item 3")
        val selectedItems = remember { mutableStateListOf<String>() }

        FilterList(
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