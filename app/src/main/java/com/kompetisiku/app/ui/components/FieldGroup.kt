package com.kompetisiku.app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme

@Composable
fun FormGroup(
    modifier: Modifier = Modifier,
    label: String,
    description: String? = null,
    content: @Composable () -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(Dimens.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(Dimens.spaceSmall)
        ) {
            Text(
                text = label,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.titleMedium
            )
            if (description != null) {
                Text(
                    text = description,
                    textAlign = TextAlign.Start,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.spaceSmall)
        ) {
            content()
        }
    }
}

@Preview
@Composable
fun PreviewFormGroup() {
    KompetisiKuTheme {
        FormGroup(
            label = stringResource(R.string.label_register_1),
            description = stringResource(R.string.description_register_1)
        ) {
            AppTextField(
                modifier = Modifier.fillMaxWidth(),
                value = "",
                onValueChange = { },
                placeholder = stringResource(R.string.dummy_text),
                keyboardType = KeyboardType.Text
            )
        }
    }
}