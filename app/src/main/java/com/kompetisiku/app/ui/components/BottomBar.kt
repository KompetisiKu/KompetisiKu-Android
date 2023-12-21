package com.kompetisiku.app.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.kompetisiku.app.R
import com.kompetisiku.app.ui.navigation.NavigationItem
import com.kompetisiku.app.ui.navigation.Screen
import com.kompetisiku.app.ui.theme.Colors
import com.kompetisiku.app.ui.theme.Gray400
import com.kompetisiku.app.ui.theme.White

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavigationBar(
        modifier = modifier,
        containerColor = White,
        contentColor = Gray400,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(R.string.menu_home),
                icon = ImageVector.vectorResource(R.drawable.home),
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(R.string.menu_activities),
                icon = ImageVector.vectorResource(R.drawable.activities),
                screen = Screen.Activities
            ),
            NavigationItem(
                title = stringResource(R.string.menu_certificates),
                icon = ImageVector.vectorResource(R.drawable.certificate),
                screen = Screen.Certificates
            ),
            NavigationItem(
                title = stringResource(R.string.menu_profile),
                icon = ImageVector.vectorResource(R.drawable.profile),
                screen = Screen.Profile
            ),
        )

        navigationItems.map { item ->
            val selected = currentRoute == item.screen.route
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigate(item.screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Colors.primary,
                    unselectedIconColor = Gray400,
                    selectedTextColor = Colors.primary,
                    indicatorColor = White,
                    unselectedTextColor = Gray400,
                ),
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        color = if (selected) Colors.primary else Gray400,
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodySmall
                    )
                },
            )
        }
    }
}