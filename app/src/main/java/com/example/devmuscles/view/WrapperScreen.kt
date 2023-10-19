package com.example.devmuscles.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.devmuscles.ui.theme.AppBG
import com.example.devmuscles.ui.theme.AppGray
import com.example.devmuscles.ui.theme.AppGreen
import com.google.android.material.bottomappbar.BottomAppBar


//title:String, content:@Composable () -> Unit
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WrapperScreen(title:String, content:@Composable () -> Unit, bottomAppBar: @Composable () -> Unit?, navController: NavController) {
    Scaffold(
        bottomBar = {
            if (bottomAppBar!==null){
                bottomAppBar()
            }
        },
        topBar = {
            CenterAlignedTopAppBar(modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth()
                .height(110.dp)
                ,
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = AppBG
                ),
                navigationIcon = {
                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .padding(bottom = 28.dp), contentAlignment = Alignment.BottomCenter){
                        IconButton(
                            onClick = { navController.popBackStack() },
                            colors = IconButtonDefaults.iconButtonColors(
                                contentColor = Color.White,
                                containerColor = AppGray
                            ),
                            modifier = Modifier
                                .padding(start = 20.dp)
                                .clip(
                                    RoundedCornerShape(100)
                                )
                                .size(30.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBackIosNew,
                                contentDescription = "",
                                Modifier.size(15.dp)
                            )
                        }
                    }
                },
                title = {
                    Box(modifier = Modifier
                        .fillMaxHeight()
                        .padding(bottom = 25.dp), contentAlignment = Alignment.BottomCenter){
                        TextWhite(text = "$title", fontSize = 26.sp, fontWeight = FontWeight.ExtraBold)
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .background(AppBG)) {
            content()
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun example(){
    Scaffold(
        topBar = {
            TopAppBar(modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = AppBG
                ),
                navigationIcon = {},
                title = {}
            )
        }
    ) {
        pv -> Column(Modifier.padding(pv)) {

    }
    }
}