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
import androidx.compose.ui.graphics.Color
import com.example.devmuscles.ui.theme.AppDarkGray
import com.example.devmuscles.ui.theme.AppGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBarComposable() {
    NavigationBar( containerColor = AppDarkGray) {
        NavigationBarItem(selected = true, onClick = { /*TODO*/ }, icon = { Icon(
            imageVector = Icons.Filled.Home,
            contentDescription = "",
        ) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                indicatorColor = AppDarkGray
            )
        )
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = { Icon(
            imageVector = Icons.Filled.ClearAll,
            contentDescription = ""
        ) })
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = { BadgedBox(
            badge = {
                Badge(containerColor = AppGreen)
            }) {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = ""
            )
        } })
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = { Icon(
            imageVector = Icons.Filled.Face,
            contentDescription = ""
        ) })
    }
}