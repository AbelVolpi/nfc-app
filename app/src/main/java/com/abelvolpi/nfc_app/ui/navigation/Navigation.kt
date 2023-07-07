package com.abelvolpi.nfc_app.ui.navigation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abelvolpi.nfc_app.ui.screens.HomeScreen
import com.abelvolpi.nfc_app.ui.screens.ProvideScreen
import com.abelvolpi.nfc_app.ui.screens.ReceiveScreen

@Composable
fun NavigationSchema() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(
            "home",
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -it },
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = LinearEasing
                    )
                )
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -it },
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = LinearEasing
                    )
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { it },
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = LinearEasing
                    )
                )
            }
        ) {
            HomeScreen(
                onNavigateToProvide = {
                    navController.navigate("provide")
                },
                onNavigateToReceive = {
                    navController.navigate("receive")
                }
            )
        }
        composable(
            "provide",
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { it },
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = LinearEasing
                    )
                )
            },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { - it },
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = LinearEasing
                    )
                )
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { - it },
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = LinearEasing
                    )
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { it },
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = LinearEasing
                    )
                )
            }
        ) {
            ProvideScreen()
        }
        composable("receive", enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(
                    durationMillis = 100,
                    easing = LinearEasing
                )
            )
        },
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { it },
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = LinearEasing
                    )
                )
            },
            popEnterTransition = {
                slideInHorizontally(
                    initialOffsetX = { it },
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = LinearEasing
                    )
                )
            },
            popExitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { it },
                    animationSpec = tween(
                        durationMillis = 100,
                        easing = LinearEasing
                    )
                )
            }
        ) {
            ReceiveScreen()
        }
    }
}