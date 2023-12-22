package com.kompetisiku.app.ui.components

import android.view.inputmethod.EditorInfo
import androidx.compose.foundation.clickable
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.theme.Black300
import com.kompetisiku.app.ui.theme.Gray200
import com.kompetisiku.app.ui.theme.Gray400
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White

@Composable
fun AppSearchBar(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: @Composable () -> Unit,
    trailingIcon: @Composable () -> Unit,
    onClick: (() -> Unit)? = null
) {
    OutlinedTextField(
        modifier = modifier
            .clip(ShapeDefaults.ExtraLarge)
            .clickable {
                if (onClick != null) {
                    onClick()
                }
            },
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        shape = ShapeDefaults.ExtraLarge,
        placeholder = {
            Text(
                text = placeholder,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                EditorInfo.IME_ACTION_SEARCH
            }
        ),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Gray200,
            focusedBorderColor = Gray200,
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
}

@Preview
@Composable
fun PreviewAppSearchBar() {
    KompetisiKuTheme {
        var value by remember { mutableStateOf("") }

        AppSearchBar(
            value = value,
            onValueChange = {value = it},
            placeholder = stringResource(R.string.search_activities),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Search,
                    contentDescription = null
                )
            },
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable {
                        value = ""
                    },
                    imageVector = Icons.Rounded.Close,
                    contentDescription = stringResource(R.string.icon_close)
                )
            }
        )
    }
}