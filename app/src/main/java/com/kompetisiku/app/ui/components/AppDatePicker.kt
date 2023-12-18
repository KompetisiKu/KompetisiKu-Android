package com.kompetisiku.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.theme.Black300
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Gray200
import com.kompetisiku.app.ui.theme.Gray400
import com.kompetisiku.app.ui.theme.Gray50
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun AppDatePicker(
    modifier: Modifier = Modifier,
    formattedDate: String,
    placeholder: String,
    supportingText: String = "",
    isError: Boolean = false,
) {
    val dateDialogState = rememberMaterialDialogState()

    OutlinedTextField(
        modifier = modifier
            .clip(ShapeDefaults.Small),
        value = formattedDate,
        onValueChange = { },
        readOnly = true,
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
            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                tint = Gray400
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
            unfocusedContainerColor = White,
            focusedContainerColor = Gray50
        ),
    )

    MaterialDialog(
        dialogState = dateDialogState,
        buttons = {
            positiveButton(
                text = stringResource(R.string.apply)
            )
            negativeButton(
                text = stringResource(R.string.cancel)
            )
        }
    ) {
        datepicker(
            initialDate = LocalDate.now(),
            title = placeholder,
        ) {

        }
    }
}

@Preview
@Composable
fun PreviewAppDatePicker() {
    KompetisiKuTheme {
        val pickedDate by remember {
            mutableStateOf(LocalDate.now())
        }
        val formattedDate by remember {
            derivedStateOf {
                DateTimeFormatter
                    .ofPattern("dd MMM yyyy")
                    .format(pickedDate)
            }
        }

        AppDatePicker(
            formattedDate = formattedDate,
            placeholder = stringResource(R.string.dummy_text)
        )
    }
}