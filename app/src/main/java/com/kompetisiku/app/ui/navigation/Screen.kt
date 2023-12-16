package com.kompetisiku.app.ui.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object OnBoarding : Screen("onboarding")
    object RegisterEntry : Screen("register_entry")
    object RegisterPublish : Screen("register_publish")
    object Login : Screen("login")
    object ResetPassword : Screen("reset_password")
}