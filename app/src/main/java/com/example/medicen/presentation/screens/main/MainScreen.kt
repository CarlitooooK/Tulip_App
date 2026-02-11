package com.example.medicen.presentation.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.medicen.presentation.components.BottomNavigationBar
import com.example.medicen.presentation.navigation.NavItem
import com.example.medicen.presentation.screens.profile.ProfileScreen
import com.example.medicen.presentation.screens.dahsboard.DashboardScreen
import com.example.medicen.presentation.screens.inventory.InventoryScreen
import com.example.medicen.presentation.screens.recipes.RecipesScreen

@Composable
fun MainScreen(rootNavController: NavHostController) {

    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = bottomNavController)
        }
    ) {
        paddingValues ->
        NavHost(
            navController = bottomNavController,
            startDestination = NavItem.Dashboard.route,

            modifier = Modifier.padding(paddingValues)
        ){
            composable(NavItem.Dashboard.route) {
                DashboardScreen()
            }
            composable(NavItem.Inventory.route) {
                InventoryScreen(
                     navController = rootNavController
                )
            }
            composable(NavItem.Recipes.route) {
                RecipesScreen()
            }
            composable(NavItem.Profile.route) {
                ProfileScreen()
            }

        }

    }
}