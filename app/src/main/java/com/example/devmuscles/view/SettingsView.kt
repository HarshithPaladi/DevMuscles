package com.example.devmuscles.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.devmuscles.ui.theme.AppGray

@Preview
@Composable
fun SettingsScreen(){
    WrapperScreen(title = "SETTINGS", content = {
        Column(Modifier.padding(horizontal = 25.dp).fillMaxHeight()) {
            listOf<String>("Units of Measure","Notifications","Language", "Contact Us").forEach {
                Row(modifier = Modifier.padding(vertical = 18.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    TextWhite(text = it)
                    Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "", tint = Color.White, modifier = Modifier.size(15.dp))
                }
                Divider(color = AppGray)
            }
        }
    }) {

    }
}