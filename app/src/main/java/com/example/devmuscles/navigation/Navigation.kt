package com.example.devmuscles.navigation

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.devmuscles.view.AgePicker
import com.example.devmuscles.view.AgePickerView
import com.example.devmuscles.view.EditProfileScreen
import com.example.devmuscles.view.GenderPickerView
import com.example.devmuscles.view.GoalPickerView
import com.example.devmuscles.view.HeightPickerView
import com.example.devmuscles.view.HomeScreen
import com.example.devmuscles.view.InsightScreen
import com.example.devmuscles.view.NotificationScreen
import com.example.devmuscles.view.PrivacyPolicyScreen
import com.example.devmuscles.view.ProfileScreen
import com.example.devmuscles.view.SettingsScreen
import com.example.devmuscles.view.WeightPickerView
import com.example.devmuscles.view.WorkoutPlanDetailsView
import com.example.devmuscles.view.workOutCategoriesView

@Composable
fun NavigationComposable(){
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = "goal_picker"){
        composable("gender"){
            GenderPickerView(navController = navController)
        }
        composable("age_picker"){
            AgePickerView(navController = navController)
        }
        composable("weight_picker"){
            WeightPickerView(navController = navController)
        }
        composable("height_picker"){
            HeightPickerView(navController = navController)
        }
        composable("goal_picker"){
            GoalPickerView(navController = navController)
        }
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
            PrivacyPolicyScreen(navController = navController)
        }
        composable("profile", enterTransition = {scaleIn()}){
            ProfileScreen(navController=navController)
        }
        composable("editProfile"){
            EditProfileScreen(navController=navController)
        }
        composable("settings"){
            SettingsScreen(navController=navController)
        }
    }
}