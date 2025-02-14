package com.example.vpn.Screens.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vpn.Screens.HomeScreen.HomeScreen
import com.example.vpn.Screens.SplashScreen

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController  = rememberNavController()
    NavHost(navController = navController, startDestination = "SplashScreen"){
        composable("SplashScreen") {
            SplashScreen{
                navController.navigate("HomeScreen")
            }
        }

        composable("HomeScreen") {
            HomeScreen()
        }
    }

}