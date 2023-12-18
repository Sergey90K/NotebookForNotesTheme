package com.example.notebookfornotestheme.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.notebookfornotestheme.ui.home.HomeDestination
import com.example.notebookfornotestheme.ui.home.HomeScreen

@Composable
fun InventoryNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(route = HomeDestination.route) {
            HomeScreen(
                navigateToItemEntry = {  },
                navigateToItemUpdate = { }
            )
        }

    }
}