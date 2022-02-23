package com.example.onetwotriptest.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.onetwotriptest.presentation.screens.main_screen.NavGraph
import com.example.onetwotriptest.presentation.ui.theme.TripTheme

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = TripTheme.colors.secondaryBackground,
    ) {
        NavGraph(navController = navController, currentDestination = currentDestination)
    }
}