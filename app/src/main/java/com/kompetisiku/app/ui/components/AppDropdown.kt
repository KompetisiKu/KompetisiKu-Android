package com.kompetisiku.app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.theme.Black300
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Gray200
import com.kompetisiku.app.ui.theme.Gray400
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDropdown(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    supportingText: String = "",
    isError: Boolean = false,
    isExpanded: Boolean = false,
    items: List<String>,
    onItemSelected: (String) -> Unit,
    onExpandedChange: (Boolean) -> Unit,
    onDismissRequest: () -> Unit
) {
    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = isExpanded,
        onExpandedChange = onExpandedChange,
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor()
                .clip(ShapeDefaults.Small),
            value = value,
            onValueChange = { },
            readOnly = true,
            shape = ShapeDefaults.Small,
            placeholder = {
                Text(text = placeholder)
            },
            trailingIcon = {
                Icon(
                    modifier = Modifier.rotate(if (isExpanded) 180f else 0f),
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                )
            },
            supportingText = {
                if (isError) {
                    Text(
                        text = "* $supportingText",
                        color = Colors.error
                    )
                }
            },
            isError = isError,
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Gray200,
                focusedBorderColor = Colors.primary,
                unfocusedContainerColor = White,
                focusedContainerColor = White,
                unfocusedLeadingIconColor = Gray400,
                focusedLeadingIconColor = Gray400,
                unfocusedTextColor = Black300,
                focusedTextColor = Black300,
                unfocusedTrailingIconColor = Gray400,
                focusedTrailingIconColor = Gray400,
                unfocusedPlaceholderColor = Gray400,
                focusedPlaceholderColor = Gray400,
            ),
        )

        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = onDismissRequest
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(text = item)
                    },
                    onClick = {
                        onItemSelected(item)
                        onExpandedChange(false)
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewAppDropdown() {
    KompetisiKuTheme {
        AppDropdown(
            value = "",
            placeholder = stringResource(R.string.dummy_text),
            supportingText = stringResource(R.string.dummy_text),
            items = listOf("Item 1", "Item 2", "Item 3"),
            onItemSelected = {},
            onExpandedChange = {},
            onDismissRequest = {}
        )
    }
}