package com.kompetisiku.app.ui.activity.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.kompetisiku.app.ui.components.BottomBar
import com.kompetisiku.app.ui.components.ProgressBarPercentage
import com.kompetisiku.app.ui.navigation.Screen
import com.kompetisiku.app.ui.screen.home.HomeScreen
import com.kompetisiku.app.ui.screen.profile.ProfileEditScreen
import com.kompetisiku.app.ui.screen.profile.ProfileScreen
import com.kompetisiku.app.ui.theme.Black300
import com.kompetisiku.app.ui.theme.Black500
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import com.kompetisiku.app.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val validRoutes = setOf(Screen.Home.route, Screen.Profile.route)

    Scaffold(
        modifier = modifier,
        contentWindowInsets = WindowInsets(Dimens.paddingDefault),
        topBar = {
            if (currentRoute == Screen.ProfileEdit.route) {
                Column {
                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = White
                        ),
                        title = {
                            Text(
                                text = stringResource(R.string.profile_edit),
                                color = Black500,
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
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = stringResource(R.string.icon_back),
                                    tint = Black300
                                )
                            }
                        },
                    )
                    ProgressBarPercentage(
                        modifier = Modifier.fillMaxWidth(),
                        progress = 1,
                        maxProgress = 2,
                        label = stringResource(R.string.profile_progress)
                    )
                }
            }
        },
        bottomBar = {
            if (currentRoute in validRoutes) {
                BottomBar(navController = navController)
            }
            if (currentRoute == Screen.ProfileEdit.route) {
                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = Dimens.elevationSmall,
                            shape = RectangleShape
                        )
                        .background(White)
                        .navigationBarsPadding()
                        .padding(
                            Dimens.paddingHorizontalMedium,
                            Dimens.paddingVerticalLarge
                        )
                ) {
                    AppButton(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(R.string.button_save_changes),
                        onClick = {
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            NavHost(
                navController = navController,
                startDestination = Screen.Home.route,
            ) {
                composable(
                    route = Screen.Home.route
                ) {
                    HomeScreen()
                }
                composable(
                    route = Screen.Profile.route
                ) {
                    ProfileScreen(navController = navController)
                }
                composable(
                    route = Screen.ProfileEdit.route
                ) {
                    ProfileEditScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterForm() {
    KompetisiKuTheme {
        MainNavigation()
    }
}