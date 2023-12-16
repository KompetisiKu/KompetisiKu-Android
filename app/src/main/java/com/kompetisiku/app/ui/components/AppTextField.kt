package com.kompetisiku.app.ui.components

import android.view.inputmethod.EditorInfo
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.theme.Black300
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Gray200
import com.kompetisiku.app.ui.theme.Gray400
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White

@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: String = "",
    isError: Boolean = false,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        modifier = modifier.clip(ShapeDefaults.Small),
        value = value,
        onValueChange = onValueChange,
        shape = ShapeDefaults.Small,
        textStyle = LocalTextStyle.current.copy(
            color = Black300,
        ),
        placeholder = {
            Text(
                text = placeholder,
                color = Gray400
            )
        },
        trailingIcon = {
            if (trailingIcon != null) {
                trailingIcon()
            }
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
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                EditorInfo.IME_ACTION_NEXT
            }
        ),
        singleLine = true,
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedBorderColor = Gray200,
            focusedBorderColor = Colors.primary,
            unfocusedContainerColor = White
        ),
    )
}

@Preview
@Composable
fun PreviewAppTextField() {
    KompetisiKuTheme {
        AppTextField(
            value = "",
            onValueChange = { },
            placeholder = stringResource(R.string.dummy_text),
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.visibility_24px),
                    contentDescription = null,
                    tint = Gray400
                )
            },
            supportingText = stringResource(R.string.dummy_text),
            keyboardType = KeyboardType.Text
        )
    }
}