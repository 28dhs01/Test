package com.example.test

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home_screen" ){
        composable(route = "home_screen") {
            HomeScreen(){
                navController.navigate("detail_screen")
            }
        }
        composable(route = "detail_screen"){
            DetailScreen{
                navController.popBackStack()
            }
        }
    }
}