package com.example.devmuscles.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.devmuscles.components.ArrowBackButton
import com.example.devmuscles.components.IconNavigationButton
import com.example.devmuscles.components.Picker
import com.example.devmuscles.components.rememberPickerState
import com.example.devmuscles.ui.theme.AppBG
import com.example.devmuscles.ui.theme.AppGreen
import com.example.devmuscles.ui.theme.AppWhite

@Composable
fun HeightPickerView(navController: NavController){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(AppBG)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 56.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeightPicker(navController = navController)
        }
    }
}
@Composable
fun HeightPicker(navController: NavController){
    val configuration = LocalConfiguration.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(start = 28.dp, end = 28.dp
        )
    ) {
        TextWhite(
            text = "WHAT'S YOUR HEIGHT?",
            fontSize = 24.sp,
            fontWeight = FontWeight(900)
        )
        TextWhite(
            text = "THIS HELPS US CREATE YOUR PERSONALIZED PLAN",
            fontSize = 10.sp,
            fontWeight = FontWeight(900),
            modifier = Modifier.padding(top = 16.dp, start = 28.dp, end = 28.dp)
        )
        Spacer(modifier = Modifier.padding(top = (configuration.screenHeightDp.times(0.15f).dp)))

        val values = remember { (120..250).map { it.toString() } }
        val valuesPickerState = rememberPickerState()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = configuration.smallestScreenWidthDp.times(0.30f).dp,
                    end = configuration.smallestScreenWidthDp.times(0.30f).dp)
        ) {
            Picker(
                state = valuesPickerState,
                items = values,
                visibleItemsCount = 7,
                textModifier = Modifier.padding(8.dp),
                textStyle = TextStyle(fontSize = 32.sp),
                dividerColor = AppGreen,
                textColor = AppWhite,
                startIndex = 4
            )
            Text(text = "cm",
                modifier = Modifier.offset(
                    x = configuration.smallestScreenWidthDp.times(0.22f).dp,
                    y = configuration.screenHeightDp.times(0.24f).dp
                ),
                fontWeight = FontWeight(200),
                color = AppWhite
            )

        }


//        TextWhite(
//            text = "Age: ${valuesPickerState.selectedItem} Years",
//        )
        Spacer(modifier = Modifier.padding(top = 56.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 28.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.BottomStart
            ) {
                ArrowBackButton(onClick = {
                    navController.navigate("weight_picker")
                })
            }
            Box(
                contentAlignment = Alignment.BottomEnd
            ) {
                IconNavigationButton(
                    text = "NEXT",
                    onClick = {
                        navController.navigate("goal_picker")
                    },
                    icon = Icons.AutoMirrored.Filled.ArrowForward,
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeightPickerPreview(){
//    AgeExample()
    HeightPickerView(navController = NavController(LocalContext.current))
}