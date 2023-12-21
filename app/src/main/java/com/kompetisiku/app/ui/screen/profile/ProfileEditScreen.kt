package com.kompetisiku.app.ui.screen.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.components.AppDatePicker
import com.kompetisiku.app.ui.components.AppDropdown
import com.kompetisiku.app.ui.components.AppTextField
import com.kompetisiku.app.ui.components.FieldContainer
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme

@Composable
fun ProfileEditScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(Dimens.spaceSmall)
    ) {
        FieldContainer(
            label = stringResource(R.string.label_profile_1),
            description = stringResource(R.string.description_profile_1)
        ) {
            AppTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                placeholder = stringResource(R.string.username),
                keyboardType = KeyboardType.Text
            )
            AppTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                placeholder = stringResource(R.string.email),
                keyboardType = KeyboardType.Email
            )
        }
        FieldContainer(
            label = stringResource(R.string.label_profile_2),
            description = stringResource(R.string.description_profile_2)
        ) {
            AppTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                placeholder = stringResource(R.string.first_name),
                keyboardType = KeyboardType.Text
            )
            AppTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                placeholder = stringResource(R.string.last_name),
                keyboardType = KeyboardType.Text
            )
            AppDropdown(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                placeholder = stringResource(R.string.gender),
                items = listOf(),
                onItemSelected = {},
                onExpandedChange = {},
                onDismissRequest = {}
            )

            val date = remember {
                mutableStateOf("")
            }

            AppDatePicker(
                modifier = Modifier.fillMaxWidth(),
                value = date.value,
                onValueChange = { date.value = it },
                placeholder = stringResource(R.string.birth_date)
            )
            AppTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = {},
                placeholder = stringResource(R.string.phone_number),
                keyboardType = KeyboardType.Phone
            )
            AppDropdown(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                placeholder = stringResource(R.string.city_of_domicile),
                items = listOf(),
                onItemSelected = {},
                onExpandedChange = {},
                onDismissRequest = {}
            )
            AppDropdown(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                placeholder = stringResource(R.string.current_education),
                items = listOf(),
                onItemSelected = {},
                onExpandedChange = {},
                onDismissRequest = {}
            )
            AppDropdown(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                placeholder = stringResource(R.string.last_education),
                items = listOf(),
                onItemSelected = {},
                onExpandedChange = {},
                onDismissRequest = {}
            )
        }
    }
}

@Preview
@Composable
fun PreviewProfileEditScreen() {
    KompetisiKuTheme {
        ProfileEditScreen()
    }
}