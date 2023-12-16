package com.kompetisiku.app.ui.navigation

import androidx.annotation.DrawableRes
import com.kompetisiku.app.R

data class OnBoardingPage(
    val title: Int,
    val description: Int,
    @DrawableRes val image: Int,
)

val onBoardingPages = listOf(
    OnBoardingPage(
        title = R.string.title_onboarding_1,
        description = R.string.decription_onboarding_1,
        image = R.drawable.onboarding_1
    ),
    OnBoardingPage(
        title = R.string.title_onboarding_2,
        description = R.string.decription_onboarding_2,
        image = R.drawable.onboarding_2
    ),
    OnBoardingPage(
        title = R.string.title_onboarding_3,
        description = R.string.decription_onboarding_3,
        image = R.drawable.onboarding_3
    )
)