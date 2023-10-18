package com.example.devmuscles.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.devmuscles.ui.theme.AppDarkGray
import com.example.devmuscles.ui.theme.AppGreen
import com.example.devmuscles.viewModel.GlobalData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBarComposable(navController: NavController) {
    var globalData = viewModel<GlobalData>()
    var nabBarItemColor = NavigationBarItemDefaults.colors(
        selectedIconColor = Color.White,
        indicatorColor = AppDarkGray
    )
    NavigationBar(containerColor = AppDarkGray) {
        NavigationBarItem(selected = globalData.selectedItem == 0, onClick = {
            globalData.updateSelectedItem(0)
            navController.navigate("home")
        }, icon = {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "",
            )
        },
            colors = nabBarItemColor
        )
        NavigationBarItem(selected = globalData.selectedItem == 1, onClick = {
            globalData.updateSelectedItem(1)
            navController.navigate("insights")
        }, icon = {
            Icon(
                imageVector = Icons.Filled.ClearAll,
                contentDescription = ""
            )
        },
            colors = nabBarItemColor
        )
        NavigationBarItem(selected = globalData.selectedItem == 2, onClick = {
            globalData.updateSelectedItem(2)
            navController.navigate("notifications")
        }, icon = {
            BadgedBox(
                badge = {
                    Badge(containerColor = AppGreen)
                }) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = ""
                )
            }
        },
            colors = nabBarItemColor
        )
        NavigationBarItem(selected = globalData.selectedItem == 3,
            onClick = {
                navController.navigate("profile")
                globalData.updateSelectedItem(3) },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Face,
                    contentDescription = ""
                )
            },
            colors = nabBarItemColor
        )
    }
}