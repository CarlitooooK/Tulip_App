package com.example.medicen.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Person4
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavItem(
    val route: String,
    val title: String,
    val iconNav: ImageVector
) {
    object Dashboard :
        NavItem(route = "dashboard_screen", title = "Home", iconNav = Icons.Default.Home)

    object Inventory :
        NavItem(route = "inventory_screen", title = "Inventario", iconNav = Icons.Default.Inventory2)

    object Recipes  :
        NavItem(route = "recipes_screen", title = "Recetas", iconNav = Icons.Default.Receipt)

    object Profile :
        NavItem(route = "profile_screen", title = "Perfil", iconNav = Icons.Default.Person4)
}
val bottomNavItem = listOf(
    NavItem.Dashboard,
    NavItem.Inventory,
    NavItem.Recipes,
    NavItem.Profile,
)

