package com.example.devmuscles.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ClearAll
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.util.Date
import com.example.devmuscles.R
import com.example.devmuscles.data.beginnerWorkoutList
import com.example.devmuscles.ui.theme.AppBG
import com.example.devmuscles.ui.theme.AppDarkGray
import com.example.devmuscles.ui.theme.AppGreen
import com.example.devmuscles.ui.theme.AppRed

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController:NavController){
    Scaffold(
        bottomBar = {
            BottomAppBarComposable()
        }
    ) {
        paddingValues ->  Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .background(AppBG)
        .padding(top = 40.dp)
        .padding(paddingValues)
    ) {
        Column(Modifier.padding(horizontal = 20.dp)) {
            val name = "Teja"
            Row {
                Text(text = "Hello ", color = Color.White, fontSize = 34.sp, fontWeight = FontWeight.Bold)
                Text(text = "$name,", color = Color.White, fontSize = 34.sp, fontWeight = FontWeight.Black)
            }
            Text(text = "Good Morning.", color = Color.White,)
        }
        Column(modifier = Modifier
            .padding(top = 10.dp, bottom = 15.dp)
            .padding(horizontal = 20.dp)) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp)) {
                Text(text = "Today Workout Plan", color = Color.White, fontWeight = FontWeight.SemiBold)
                Text(text = "Mon 26 Apr", color = AppGreen)
            }
            CardBox("Day 01 - Warm Up","07:00 - 08:00 AM", isClickable = true, onClick = {
                navController.navigate("workoutPlanDetails")
            })
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(vertical = 10.dp)) {
            Text(text = "Workout Categories",color = Color.White, fontWeight = FontWeight.SemiBold)
            Text(text = "See all", color = AppGreen, modifier = Modifier.clickable(
                onClick = {
                    navController.navigate("workOutCategories")
                }
            ))
        }
        val titles = listOf("Beginner", "Intermediate", "Advance")
        var tabIndex by remember { mutableStateOf(0) }
        Column() {
            TabRow(selectedTabIndex = tabIndex,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 15.dp)
                    .clip(RoundedCornerShape(50)),
                containerColor = AppDarkGray,
                divider = {
                    Divider(modifier = Modifier.height(0.dp))
                },
                indicator = { tabPositions: List<TabPosition> ->
                    Box(Modifier.height(0.dp)) {}
                },
            ) {
                titles.forEachIndexed { index, title ->
                    val color = if (tabIndex==index) AppGreen else AppDarkGray
                    val textColor = if (tabIndex==index) Color.Black else Color.White
                    Tab(
                        text = { Text(title, color = textColor)},
                        selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(color = color)
                            .height(30.dp))
                }
            }

            LazyRow(modifier = Modifier
                .padding(start = 20.dp)
                .fillMaxWidth()){

                items(beginnerWorkoutList.reversed()){
                    Box(modifier = Modifier
                        .padding(end = 15.dp)
                        .width(320.dp)){
                        CardBox(text1 = it.text1, text2 = it.text2, imageId = it.imageId, isClickable = false, onClick = {}, isPro = it.isPro)
                    }
                }
            }
        }
        Column(modifier = Modifier.padding(start = 20.dp)) {
            Text(text = "New Workouts",color = Color.White, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(top = 25.dp, bottom = 10.dp))
            LazyRow(modifier = Modifier
                .fillMaxWidth()){
                items(5){index ->
                    Box(modifier = Modifier
                        .padding(end = 15.dp)
                        .width(220.dp)){
                        CardBox(text1 = "Coool", text2 = "Hello", isClickable = false, onClick = {})
                    }
                }
            }
        }
    }
    }
}

@Composable
fun CardBox(text1: String, text2: String, isClickable: Boolean, onClick: () -> Unit, imageId:Int?=R.drawable.slide3, isPro:Boolean?=false){
    var modifier = if(isClickable) Modifier
        .height(160.dp)
        .fillMaxWidth()
        .clickable(
            onClick = onClick
        )
     else Modifier
        .height(160.dp)
        .fillMaxWidth()
    var sizeImage by remember { mutableStateOf(IntSize.Zero) }
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.Black),
        startY = sizeImage.height.toFloat()/3,  // 1/3
        endY = sizeImage.height.toFloat()
    )
    Box(modifier = modifier
    ) {
        Image(painter = painterResource(id=imageId!!), contentDescription = "", modifier = Modifier
            .fillMaxSize()
            .onGloballyPositioned {
                sizeImage = it.size
            }
            .clip(
                RoundedCornerShape(20.dp)
            ), contentScale = ContentScale.FillBounds,)
        Box(modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .matchParentSize()
            .background(gradient))
        if(isPro==true){
            Row(modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth().padding(14.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Bottom) {
                Column(modifier = Modifier
                    ) {
                    Text(text = "$text1", color = Color.White, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(vertical = 4.dp))
                    Row {
                        Box(modifier = Modifier)
                        Text(text = "$text2", color = AppGreen)
                    }
                }
                Text(text = "PRO", color = Color.White, fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .background(AppRed)
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                        .clip(RoundedCornerShape(50))
                )
            }
        }else{
            Column(modifier = Modifier
                .padding(14.dp)
                .align(Alignment.BottomStart)) {
                Text(text = "$text1", color = Color.White, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(vertical = 4.dp))
                Row {
                    Box(modifier = Modifier)
                    Text(text = "$text2", color = AppGreen)
                }
            }
        }
    }
}
