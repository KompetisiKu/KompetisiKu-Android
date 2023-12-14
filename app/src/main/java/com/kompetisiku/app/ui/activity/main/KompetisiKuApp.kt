package com.kompetisiku.app.ui.activity.main

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kompetisiku.app.ui.navigation.Screen
import com.kompetisiku.app.ui.screen.onboarding.OnBoardingScreen
import com.kompetisiku.app.ui.screen.welcome.WelcomeScreen

@Composable
fun KompetisiKuApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route,
    ) {
        composable(Screen.Welcome.route) {
            WelcomeScreen(
                navigateToOnBoarding = {
                    navController.navigate(Screen.OnBoarding.route)
                }
            )
        }
        composable(Screen.OnBoarding.route) {
            OnBoardingScreen()
        }
    }
}