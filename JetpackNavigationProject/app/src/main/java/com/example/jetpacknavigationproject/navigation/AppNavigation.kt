package com.example.jetpacknavigationproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpacknavigationproject.screens.FirstScreen
import com.example.jetpacknavigationproject.screens.SecondScreen

@Composable
fun AppNavigation(){
val NavController = rememberNavController()
    NavHost(navController = NavController, startDestination = AppScreens.FirstScreen.route) {
        composable(route = AppScreens.FirstScreen.route) { FirstScreen(NavController) }
        composable(route = AppScreens.SecondScreen.route) { SecondScreen(NavController) }
    }
}