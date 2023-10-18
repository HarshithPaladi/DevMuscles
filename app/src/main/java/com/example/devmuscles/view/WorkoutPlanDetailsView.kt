package com.example.devmuscles.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableChipColors
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.devmuscles.R
import com.example.devmuscles.ui.theme.AppBG
import com.example.devmuscles.ui.theme.AppDarkGray
import com.example.devmuscles.ui.theme.AppGray
import com.example.devmuscles.ui.theme.AppGreen
import com.google.android.material.chip.Chip


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutPlanDetailsView(navController: NavController){
    Scaffold { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .background(AppBG)) {
            val lazyListState = rememberLazyListState()
            var scrolledY = 0f
            var previousOffset = 0
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    Modifier
                        .fillMaxSize(),
                    lazyListState
                ) {
                    item {
                        Box(modifier = Modifier
                            .height(280.dp)
                            .fillMaxWidth()){
                            Image(painter = painterResource(id = R.drawable.coverpic1),
                                contentDescription = "",
                                contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .graphicsLayer {
                                        scrolledY += lazyListState.firstVisibleItemScrollOffset - previousOffset
                                        translationY = scrolledY * 0.5f
                                        previousOffset = lazyListState.firstVisibleItemScrollOffset
                                    }
                                    .fillMaxSize()
                            )
                            IconButton(onClick = { navController.popBackStack() }, modifier = Modifier.align(Alignment.TopStart).offset(x=20.dp, y=25.dp).clip(RoundedCornerShape(50)).background(
                                Color(0x90000000)
                            ), colors = IconButtonDefaults.iconButtonColors(contentColor = Color.White)) {
                                Icon(imageVector = Icons.Default.ArrowBackIosNew, contentDescription = "")
                            }
                        }
                    }
                    item {
                        Column(modifier = Modifier
                            .padding()
                            .clip(
                                RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                            )
                            .background(AppBG)) {
                            Column(modifier = Modifier.padding(horizontal = 20.dp)) {
                                Text(text = "Day 01 - Warm Up", color = Color.White, fontSize = 26.sp, fontWeight = FontWeight.SemiBold , modifier = Modifier.padding(vertical = 10.dp))
                                Text(text = "04 Workouts for Beginner", color = AppGreen)
                                Row (modifier = Modifier.padding(vertical = 20.dp)){
                                    FilterChip(
                                        selected = true,
                                        onClick = { /*TODO*/ },
                                        label = { Text(text = "60 min") },
                                        leadingIcon = {
                                            Icon(
                                                imageVector = Icons.Default.PlayCircle,
                                                contentDescription = ""
                                            )
                                        },
                                        modifier = Modifier.padding(vertical = 4.dp),
                                        shape = RoundedCornerShape(50),
                                        colors = FilterChipDefaults.filterChipColors(
                                            selectedContainerColor = AppGray,
                                            selectedLabelColor = Color.White,
                                            selectedLeadingIconColor = Color.White
                                        )
                                    )
                                    Spacer(modifier = Modifier.width(30.dp))
                                    FilterChip(
                                        selected = true,
                                        onClick = { /*TODO*/ },
                                        label = { Text(text = "350 cal") },
                                        leadingIcon = {
                                            Icon(
                                                imageVector = Icons.Default.LocalFireDepartment,
                                                contentDescription = ""
                                            )
                                        },
                                        modifier = Modifier.padding(vertical = 4.dp),
                                        shape = RoundedCornerShape(50),
                                        colors = FilterChipDefaults.filterChipColors(
                                            selectedContainerColor = AppGray,
                                            selectedLabelColor = Color.White,
                                            selectedLeadingIconColor = Color.White
                                        )
                                        )
                                }
                                Text(
                                    color = Color.White,
                                    text = "Want your body to be healthy. Join our program with directions according to body’s goals. Increasing physical strength is the goal of strenght training. Maintain body fitness by doing physical exercise at least 2-3 times a week. "
                                )
                                Column(modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 25.dp)) {
                                    (1..5).forEach {
                                        Row(horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(AppGray)

                                        ) {
                                            Image(painter = painterResource(id = R.drawable.coverpic1), contentDescription = "", modifier = Modifier.fillMaxWidth(0.25f))
                                            Column(modifier = Modifier
                                                .fillMaxWidth(0.5f)
                                                .offset(x = (-24).dp), horizontalAlignment = Alignment.Start) {
                                                Text(text = "Simple Warm-Up\n" +
                                                        "Exercises", color = Color.White, fontWeight = FontWeight.SemiBold
                                                )
                                                Text(text = "0:30", color = AppGreen)
                                            }
                                            IconButton(onClick = { /*TODO*/ }, modifier = Modifier
                                                .padding(end = 6.dp)
                                                .fillMaxWidth(0.25f), colors = IconButtonDefaults.iconButtonColors(
                                                contentColor = Color.White
                                            )) {
                                                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "")
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(16.dp))
                                    }
                                }
                            }
                            Spacer(modifier = Modifier.height(140.dp))
                        }
                    }
                }
                Box(modifier = Modifier.align(Alignment.BottomCenter)){
                    BottomButtonBox()
                }
            }
        }
    }
}


@Composable
fun BottomButtonBox(){
    var sizeImage by remember { mutableStateOf(IntSize.Zero) }
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color(0xD2000000)),
        startY = sizeImage.height.toFloat()/3,  // 1/3
        endY = sizeImage.height.toFloat()
    )
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.3f)
        .background(gradient)
        .onGloballyPositioned { sizeImage = it.size }){
        PrimaryButton(
            Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp))
    }
}

@Composable
fun PrimaryButton(modifier:Modifier){
    Button(onClick = { /*TODO*/ },
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
        containerColor = AppGreen,
        contentColor = Color.Black
    )) {
        Text(text = "Confirm", modifier = Modifier.padding(horizontal = 84.dp, vertical = 8.dp))
    }
}