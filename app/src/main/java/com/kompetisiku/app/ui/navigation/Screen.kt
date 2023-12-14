package com.kompetisiku.app.ui.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object OnBoarding : Screen("onboarding")
    object Register : Screen("register")
    object Login : Screen("login")
    object ResetPassword : Screen("reset_password")
}