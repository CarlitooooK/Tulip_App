package com.example.medicen.presentation.navigation

sealed class AppScreens(val route: String) {
    object LoginScreen: AppScreens("login_screen")
    object RegisterScreen: AppScreens("register_screen")
    object MainScreen: AppScreens("main_screen")
    object RecoveryPasswordScreen: AppScreens("recovery_password_screen")
    object InventoryAddScreen: AppScreens("inventory_add_screen")
}