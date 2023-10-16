package com.example.devmuscles.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.devmuscles.view.HomeScreen
import com.example.devmuscles.view.WorkoutPlanDetailsView
import com.example.devmuscles.view.workOutCategoriesView

@Composable
fun NavigationComposable(){
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable("home"){
            HomeScreen(navController=navController)
        }
        composable("workoutPlanDetails"){
            WorkoutPlanDetailsView()
        }
        composable("workOutCategories"){
            workOutCategoriesView()
        }
    }
}