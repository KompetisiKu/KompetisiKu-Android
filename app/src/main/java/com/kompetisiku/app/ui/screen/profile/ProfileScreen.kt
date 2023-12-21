package com.kompetisiku.app.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Create
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kompetisiku.app.BuildConfig
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.components.AppButton
import com.kompetisiku.app.ui.components.AppListItem
import com.kompetisiku.app.ui.components.FieldItemContainer
import com.kompetisiku.app.ui.components.ProgressBarPercentage
import com.kompetisiku.app.ui.components.RoundImage
import com.kompetisiku.app.ui.navigation.Screen
import com.kompetisiku.app.ui.theme.Black300
import com.kompetisiku.app.ui.theme.Black500
import com.kompetisiku.app.ui.theme.Blue100
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.Gray200
import com.kompetisiku.app.ui.theme.Gray400
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White
import com.kompetisiku.app.ui.theme.interFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Colors.primary)
                .statusBarsPadding()
                .padding(
                    Dimens.paddingHorizontalMedium,
                    Dimens.paddingVerticalMedium
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(Dimens.spaceMedium),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RoundImage(
                    modifier = Modifier.size(Dimens.profileImage),
                    image = painterResource(R.drawable.image_placeholder)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        verticalArrangement = Arrangement.spacedBy(Dimens.spaceExtraSmall)
                    ) {
                        Text(
                            text = stringResource(R.string.profile_name),
                            color = White,
                            textAlign = TextAlign.Start,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontFamily = interFamily,
                            style = MaterialTheme.typography.titleSmall
                        )
                        Text(
                            text = stringResource(R.string.profile_email),
                            color = Blue100,
                            textAlign = TextAlign.Start,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    IconButton(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(White),
                        onClick = {
                            navController.navigate(Screen.ProfileEdit.route)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Create,
                            contentDescription = stringResource(R.string.profile_edit),
                            tint = Black300
                        )
                    }
                }
            }
        }
        ProgressBarPercentage(
            modifier = Modifier.fillMaxWidth(),
            progress = 1,
            maxProgress = 2,
            label = stringResource(R.string.profile_progress)
        )
        FieldItemContainer(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.account_settings),
            trailingContent = {
                Text(
                    text = stringResource(R.string.app_version, BuildConfig.VERSION_NAME),
                    color = Gray400,
                    maxLines = 1,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        ) {
            AppListItem(
                modifier = Modifier
                    .clickable {  },
                leadingIcon = Icons.Rounded.Favorite,
                trailingIcon = Icons.Rounded.KeyboardArrowRight
            ) {
                Text(
                    text = stringResource(R.string.wishlist_competition),
                    color = Black500,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            AppListItem(
                modifier = Modifier
                    .clickable {  },
                leadingIcon = Icons.Rounded.Notifications,
                trailingIcon = Icons.Rounded.KeyboardArrowRight
            ) {
                Text(
                    text = stringResource(R.string.notification),
                    color = Black500,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            AppListItem(
                modifier = Modifier
                    .clickable {  },
                leadingIcon = ImageVector.vectorResource(R.drawable.language_24px),
                trailingIcon = Icons.Rounded.KeyboardArrowRight
            ) {
                Text(
                    text = stringResource(R.string.change_languages),
                    color = Black500,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            AppListItem(
                modifier = Modifier
                    .clickable {
                        isSheetOpen = true
                    },
                leadingIcon = ImageVector.vectorResource(R.drawable.logout_24px),
                trailingIcon = Icons.Rounded.KeyboardArrowRight
            ) {
                Text(
                    text = stringResource(R.string.logout),
                    color = Black500,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }

    if (isSheetOpen) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isSheetOpen = false
            },
            containerColor = Color.Transparent,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(BottomSheetDefaults.ExpandedShape)
                    .background(White)
                    .padding(
                        Dimens.paddingHorizontalMedium,
                        Dimens.paddingVerticalExtraLarge
                    )
            ) {
                Column {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(Dimens.spaceSmall)
                    ) {
                        Text(
                            text = stringResource(R.string.modal_title_logout),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = stringResource(R.string.modal_description_logout),
                            textAlign = TextAlign.Center,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Spacer(modifier = modifier.height(Dimens.spaceLarge))
                    AppButton(
                        modifier = Modifier.fillMaxWidth(),
                        containerColor = White,
                        borderColor = Gray200,
                        text = stringResource(R.string.button_logout),
                        textColor = Colors.primary,
                        onClick = {}
                    )
                    Spacer(modifier = modifier.height(Dimens.spaceLarge))
                    AppButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(R.string.button_no),
                        onClick = {}
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFE7F0FF)
@Composable
fun PreviewProfileScreen() {
    KompetisiKuTheme {
        ProfileScreen(navController = rememberNavController())
    }
}