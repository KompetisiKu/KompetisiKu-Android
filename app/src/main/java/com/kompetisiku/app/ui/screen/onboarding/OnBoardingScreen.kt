package com.kompetisiku.app.ui.screen.onboarding

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.activity.register.RegisterActivity
import com.kompetisiku.app.ui.components.AppButton
import com.kompetisiku.app.ui.components.OnBoardingPage
import com.kompetisiku.app.ui.navigation.pages
import com.kompetisiku.app.ui.theme.Dimens
import com.kompetisiku.app.ui.theme.KompetisiKuTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    activity: ComponentActivity
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        val pagerState = rememberPagerState(initialPage = 0) {
            pages.size
        }

        val buttonState = remember {
            derivedStateOf {
                when(pagerState.currentPage) {
                    0 -> R.string.button_continue
                    1 -> R.string.button_continue
                    2 -> R.string.button_create_account
                    else -> R.string.button_continue
                }
            }
        }

        HorizontalPager(state = pagerState) { index ->
            OnBoardingPage(page = pages[index])
        }

        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    Dimens.paddingHorizontalMedium,
                    Dimens.paddingVerticalLarge
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(Dimens.spaceLarge)
        ) {
            val scope = rememberCoroutineScope()

            if (pagerState.currentPage == 2) {
                AppButton(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    text = stringResource(buttonState.value),
                    large = true,
                    onClick = {
                        activity.startActivity(Intent(activity, RegisterActivity::class.java))
                    }
                )
            } else {
                AppButton(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    text = stringResource(buttonState.value),
                    imageVector = Icons.Rounded.ArrowForward,
                    large = true,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(
                                page = pagerState.currentPage + 1
                            )
                        }
                    }
                )
            }

            PageIndicator(
                pageSize = pages.size,
                activePage = pagerState.currentPage
            )
        }
    }
}

@Preview
@Composable
fun PreviewOnBoardingScreen() {
    KompetisiKuTheme {
        OnBoardingScreen(activity = ComponentActivity())
    }
}