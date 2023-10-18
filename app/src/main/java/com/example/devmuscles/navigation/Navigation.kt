package com.example.devmuscles.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.devmuscles.view.EditProfileScreen
import com.example.devmuscles.view.HomeScreen
import com.example.devmuscles.view.InsightScreen
import com.example.devmuscles.view.NotificationScreen
import com.example.devmuscles.view.PrivacyPolicyScreen
import com.example.devmuscles.view.ProfileScreen
import com.example.devmuscles.view.SettingsScreen
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
            WorkoutPlanDetailsView(navController=navController)
        }
        composable("workOutCategories"){
            workOutCategoriesView(navController = navController)
        }
        composable("insights"){
            InsightScreen(navController = navController)
        }
        composable("notifications"){
            NotificationScreen(navController=navController)
        }
        composable("privacyPolicy"){
            PrivacyPolicyScreen()
        }
        composable("profile"){
            ProfileScreen(navController=navController)
        }
        composable("editProfile"){
            EditProfileScreen()
        }
        composable("settings"){
            SettingsScreen()
        }
    }
}