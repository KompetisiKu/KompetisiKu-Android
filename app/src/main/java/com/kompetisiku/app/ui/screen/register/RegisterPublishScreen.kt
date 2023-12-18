package com.kompetisiku.app.ui.screen.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.components.FormField
import com.kompetisiku.app.ui.components.SelectableItem
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme

val itemList = listOf(
    "Item 1",
    "Item 2",
    "Item 3",
    "Item 4",
    "Item 5",
    "Item 6",
    // Add more items as needed
)


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RegisterPublishScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimens.spaceSmall)
    ) {
        FormField(
            label = stringResource(R.string.label_register_3),
            description = stringResource(R.string.description_register_3)
        ) {
            val selectedItems = remember { mutableStateListOf<String>() }

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Dimens.spaceSmall),
                verticalArrangement = Arrangement.spacedBy(Dimens.spaceSmall)
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
                                if (selectedItems.size < 5) {
                                    selectedItems.add(item)
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewRegisterPublishScreen() {
    KompetisiKuTheme {
        Surface(
            modifier = Modifier,
            color = Colors.background
        ) {
            RegisterPublishScreen()
        }
    }
}
