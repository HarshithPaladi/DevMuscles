package com.example.devmuscles.view


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.devmuscles.viewModel.GlobalData
import com.google.android.material.bottomappbar.BottomAppBar

@Composable
fun NotificationScreen(navController: NavController){
    var globalData = viewModel<GlobalData>()
    globalData.updateSelectedItem(2)
    WrapperScreen(title = "NOTIFICATIONS", bottomAppBar = {BottomAppBarComposable(navController = navController)}, content = {
            TextWhite(text = "Cool")
    })
}