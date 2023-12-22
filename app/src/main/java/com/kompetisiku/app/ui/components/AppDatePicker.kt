package com.kompetisiku.app.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.theme.Black300
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Gray200
import com.kompetisiku.app.ui.theme.Gray400
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.DatePickerDefaults
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun AppDatePicker(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    supportingText: String = "",
    isError: Boolean = false,
) {
    val dateDialogState = rememberMaterialDialogState()

    Box {
        OutlinedTextField(
            modifier = modifier
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
                    imageVector = Icons.Default.DateRange,
                    contentDescription = null
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
        Box(
            modifier = modifier
                .matchParentSize()
                .alpha(0f)
                .clickable {
                    dateDialogState.show()
                }
        )
    }

    MaterialDialog(
        dialogState = dateDialogState,
        buttons = {
            positiveButton(
                text = stringResource(R.string.apply),
                textStyle = LocalTextStyle.current.copy(
                    color = Colors.primary,
                )
            )
            negativeButton(
                text = stringResource(R.string.cancel),
                textStyle = LocalTextStyle.current.copy(
                    color = Colors.error,
                )
            )
        }
    ) {
        datepicker(
            initialDate = LocalDate.now(),
            title = placeholder,
            colors = DatePickerDefaults.colors(
                headerBackgroundColor = Colors.primary,
                dateActiveBackgroundColor = Colors.primary,
            ),
            allowedDateValidator = { date ->
                date.isBefore(LocalDate.now().plusDays(1))
            },
            yearRange = 1900..LocalDate.now().year
        ) {
            onValueChange(
                DateTimeFormatter
                    .ofPattern("dd MMM yyyy")
                    .format(it)
            )
        }
    }
}

@Preview
@Composable
fun PreviewAppDatePicker() {
    KompetisiKuTheme {
        AppDatePicker(
            value = "",
            onValueChange = { },
            placeholder = stringResource(R.string.dummy_text)
        )
    }
}