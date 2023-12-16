package com.kompetisiku.app.ui.activity.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.components.AppButton
import com.kompetisiku.app.ui.components.ProgressBar
import com.kompetisiku.app.ui.navigation.Screen
import com.kompetisiku.app.ui.screen.register.RegisterEntryScreen
import com.kompetisiku.app.ui.screen.register.RegisterPublishScreen
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterForm(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Colors.primary
                ),
                title = {
                    Text(
                        text = stringResource(R.string.title_register),
                        color = White,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            modifier = Modifier.size(Dimens.iconLarge),
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = stringResource(R.string.icon_back)
                        )
                    }
                },
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .shadow(
                        elevation = Dimens.elevationSmall,
                        shape = RectangleShape
                    )
                    .background(White)
                    .padding(
                        Dimens.paddingHorizontalMedium,
                        Dimens.paddingVerticalLarge
                    )
            ) {
                if (currentRoute == Screen.RegisterEntry.route) {
                    AppButton(
                        containerColor = Colors.secondary,
                        text = stringResource(R.string.button_continue),
                        imageVector = Icons.Rounded.ArrowForward,
                        large = true,
                        onClick = {
                            navController.navigate(Screen.RegisterPublish.route)
                        }
                    )
                } else {
                    AppButton(
                        containerColor = Colors.secondary,
                        text = stringResource(R.string.button_register),
                        large = true,
                        onClick = {

                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            ProgressBar(maxProgress = 2)
            NavHost(
                navController = navController,
                startDestination = Screen.RegisterEntry.route
            ) {
                composable(Screen.RegisterEntry.route) {
                    RegisterEntryScreen()
                }
                composable(Screen.RegisterPublish.route) {
                    RegisterPublishScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterForm() {
    KompetisiKuTheme {
        RegisterForm()
    }
}