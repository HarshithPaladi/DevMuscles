package com.example.devmuscles.view

import android.annotation.SuppressLint
import android.graphics.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.devmuscles.ui.theme.AppBG
import com.example.devmuscles.ui.theme.AppGray
import com.example.devmuscles.ui.theme.AppGreen
import com.example.devmuscles.ui.theme.AppRed
import com.example.devmuscles.utils.datesWithDay
import com.example.devmuscles.utils.getMonthName
import com.example.devmuscles.viewModel.GlobalData
import kotlinx.coroutines.launch
import java.time.LocalDate
@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InsightScreen(navController:NavController) {
    var globalData = viewModel<GlobalData>()
    globalData.updateSelectedItem(1)
    Scaffold(
        bottomBar = {
            BottomAppBarComposable(navController = navController)
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .background(Color.Black)
            .verticalScroll(rememberScrollState())) {
            Column(modifier = Modifier
                .padding(bottom = 40.dp)
                .clip(
                    RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 30.dp)
                )
                .background(AppBG)) {
                val currentDate = LocalDate.now()
                var currentYear by remember {
                    mutableStateOf(currentDate.year)
                }
                var currentMonth by remember {
                    mutableStateOf(currentDate.monthValue)
                }
                var currentDay by remember {
                    mutableStateOf(currentDate.dayOfMonth)
                }
                var lazyListState = rememberLazyListState()
                var scope = rememberCoroutineScope()
                if((currentMonth==currentDate.monthValue) && (currentYear==currentDate.year)){
                    scope.launch {
                        lazyListState.animateScrollToItem(currentDay, -600)
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp)
                    .fillMaxWidth()) {
                    var iconButtonColor = IconButtonDefaults.iconButtonColors(contentColor = Color.White)
                    var iconButtonModifier = Modifier
                        .clip(
                            RoundedCornerShape(50)
                        )
                        .background(
                            AppGray
                        )
                    IconButton(onClick = { if(currentMonth==1){
                        currentMonth=12
                        currentYear-=1
                    }else{
                        currentMonth-=1
                    }
                        scope.launch {
                            lazyListState.animateScrollToItem(0)
                        }
                                         }, colors = iconButtonColor, modifier = iconButtonModifier) {
                        Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "")
                    }
                    TextWhite(text = "${getMonthName(currentYear,currentMonth)} $currentYear", fontWeight = FontWeight.SemiBold, fontSize = 20.sp)
                    IconButton(onClick = {
                                         if(currentMonth==12){
                                             currentMonth=1
                                             currentYear+=1
                                         }else{
                                             currentMonth+=1
                                         }
                        scope.launch {
                            lazyListState.animateScrollToItem(0)
                        }
                    }, colors = iconButtonColor, modifier = iconButtonModifier) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = "")
                    }
                }
                LazyRow(state = lazyListState, modifier = Modifier.padding(bottom = 20.dp)){
                    items(datesWithDay(currentYear,currentMonth)){
                        var currentDayBGColor = if((currentMonth==currentDate.monthValue) && (currentYear==currentDate.year) && (currentDay==it.date)) AppGreen else AppGray
                        var currentDayTextColor = if((currentMonth==currentDate.monthValue) && (currentYear==currentDate.year) && (currentDay==it.date)) Color.Black else Color.White
                        Column(modifier = Modifier
                            .padding(10.dp)
                            .clip(RoundedCornerShape(50))
                            .background(currentDayBGColor)
                            .padding(vertical = 12.dp, horizontal = 16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "${it.day}", color = currentDayTextColor)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "${it.date}", fontWeight = FontWeight.Bold, color = currentDayTextColor)
                        }
                    }
                }
            }
            Column(modifier = Modifier
                .padding(horizontal = 10.dp)
                .padding(bottom = 25.dp)) {
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                    var progress: Float by remember { mutableStateOf(0.75f) }
                    val indicatorSize = 200.dp
                    val trackWidth: Dp = (indicatorSize * .05f)
                    val commonModifier = Modifier.size(indicatorSize)
                    Box {
                        GradientProgressIndicator(
                            progress = progress,
                            modifier = commonModifier,
                            strokeWidth = trackWidth,
                            gradientStart = Color.Red,
                            gradientEnd = Color.Yellow,
                            trackColor = AppBG,
                        )
                        Column(modifier = Modifier
                            .align(Alignment.Center)
                            .size(indicatorSize), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                            Row(verticalAlignment = Alignment.Bottom ) {
                                TextWhite(text = "650 ", fontWeight = FontWeight.Bold, fontSize = 40.sp)
                                TextWhite(text = "Cal", fontWeight = FontWeight.SemiBold, fontSize = 32.sp)
                            }
                            Spacer(modifier = Modifier.height(6.dp))
                            TextWhite(text = "Active Calories")
                        }
                    }
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
                    var progress: Float by remember { mutableStateOf(0.75f) }
                    val indicatorSize = 90.dp
                    val trackWidth: Dp = (indicatorSize * .05f)
                    val commonModifier = Modifier.size(indicatorSize)
                    Box {
                        GradientProgressIndicator(
                            progress = progress,
                            modifier = commonModifier,
                            strokeWidth = trackWidth,
                            gradientStart = AppGreen,
                            gradientEnd = AppGreen,
                            trackColor = AppBG,
                        )
                        Column(modifier = Modifier
                            .align(Alignment.Center)
                            .size(indicatorSize), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                            TextWhite(text = "Steps")
                            Spacer(modifier = Modifier.height(10.dp))
                            TextWhite(text = "1250", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                        }
                    }
                    Box {
                        GradientProgressIndicator(
                            progress = progress,
                            modifier = commonModifier,
                            strokeWidth = trackWidth,
                            gradientStart = AppRed,
                            gradientEnd = AppRed,
                            trackColor = AppBG,
                        )
                        Column(modifier = Modifier
                            .align(Alignment.Center)
                            .size(indicatorSize), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                            TextWhite(text = "Time")
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(verticalAlignment = Alignment.Bottom) {
                                TextWhite(text = "50", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                                TextWhite(text = " min")
                            }
                        }
                    }
                    Box {
                        GradientProgressIndicator(
                            progress = progress,
                            modifier = commonModifier,
                            strokeWidth = trackWidth,
                            gradientStart = Color(0xFFFF9800),
                            gradientEnd = Color(0xFFFF9800),
                            trackColor = AppBG,
                        )
                        Column(modifier = Modifier
                            .align(Alignment.Center)
                            .size(indicatorSize), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                            TextWhite(text = "Heart")
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(verticalAlignment = Alignment.Bottom) {
                                TextWhite(text = "72", fontWeight = FontWeight.Bold, fontSize = 24.sp)
                                TextWhite(text = " bpm")
                            }
                        }
                    }
                }
            }
            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                TextWhite(text = "Finished workout", fontSize = 18.sp, modifier = Modifier.padding(vertical = 16.dp))
                repeat(3){
                    Row(modifier = Modifier
                        .clip(RoundedCornerShape(14.dp))
                        .background(AppBG)
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Column {
                            TextWhite(text = "Stability Training", fontSize = 18.sp)
                            TextGreen(text = "10:00")
                        }
                        Checkbox(checked = true, onCheckedChange = {

                        }, colors = CheckboxDefaults.colors(
                            checkmarkColor = Color.Black,
                            checkedColor = AppGreen
                        ))
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }

        }
    }
}


