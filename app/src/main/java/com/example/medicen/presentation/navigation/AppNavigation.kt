package com.example.medicen.presentation.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medicen.presentation.screens.auth.login.LoginScreen
import com.example.medicen.presentation.screens.auth.register.RegisterScreen
import com.example.medicen.presentation.screens.main.MainScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.LoginScreen.route,
        enterTransition = { slideInHorizontally(animationSpec = tween (500)) },
        exitTransition = { slideOutHorizontally(animationSpec = tween(500)) },
        popEnterTransition = {slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Right)},
        popExitTransition = {slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right)},
    ) {
        composable(AppScreens.LoginScreen.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(AppScreens.MainScreen.route) {
                        popUpTo(AppScreens.LoginScreen.route) { inclusive = true }
                    }
                },
                onNavigateToRegister = { navController.navigate(AppScreens.RegisterScreen.route) }
            )
        }
        composable(AppScreens.RegisterScreen.route) {
            RegisterScreen(
                onRegisterSuccess = {
                    navController.navigate(AppScreens.LoginScreen.route) {
                        popUpTo(AppScreens.LoginScreen.route) { inclusive = true }
                    }
                },
                onNavigateToLogin = {
                    navController.popBackStack()
                }
            )
        }
        composable(AppScreens.MainScreen.route) {
            MainScreen(
                rootNavController = navController
            )
        }
    }
}