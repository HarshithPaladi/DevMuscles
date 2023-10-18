package com.example.devmuscles.view

import android.view.textclassifier.TextLinks.TextLink
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.devmuscles.R
import com.example.devmuscles.model.TextAndLink
import com.example.devmuscles.ui.theme.AppGray
import com.example.devmuscles.ui.theme.AppGreen
import com.example.devmuscles.ui.theme.AppRed
import com.example.devmuscles.viewModel.GlobalData


@Composable
fun ProfileScreen(navController: NavController) {
    var globalData = viewModel<GlobalData>()
    globalData.updateSelectedItem(3)
    var isProUser = false
    WrapperScreen(title = "", content = {
        Column(modifier = Modifier
            .padding(horizontal = 25.dp)
            .fillMaxHeight()) {
            Row(modifier = Modifier.padding(bottom = 15.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Box(modifier = Modifier){
                    GradientProgressIndicator(
                        progress = 0.75f,
                        gradientStart = if(isProUser==true) AppRed else AppGreen,
                        gradientEnd = if(isProUser==true) AppRed else AppRed,
                        trackColor = AppGray,
                        strokeWidth = 4.dp,
                        modifier = Modifier.size(110.dp)
                    )
                    Image(painter = painterResource(id = R.drawable.profile_pic1), contentDescription = "", modifier = Modifier
                        .size(85.dp)
                        .clip(
                            RoundedCornerShape(100)
                        )
                        .align(Alignment.Center))
                    if(isProUser==true){
                        Box(modifier = Modifier
                            .offset(x = 10.dp, y = (-10).dp)
                            .clip(
                                RoundedCornerShape(4.dp)
                            )
                            .background(AppRed)
                            .padding(vertical = 2.dp, horizontal = 4.dp)
                            .align(Alignment.BottomEnd)){
                            TextWhite(text = "PRO")
                        }
                    }
                }
                Column(Modifier) {
                    Text(text = "Joined")
                    TextWhite(text = "2 months Ago")
                }
            }
            TextWhite(text = "SARAH", fontSize = 34.sp, fontWeight = FontWeight.Black)
            TextWhite(text = "WEGAN", fontSize = 34.sp, fontWeight = FontWeight.SemiBold)
            Column(
                Modifier
                    .padding(top = 14.dp)
                    .fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
                Column() {
                    Divider(color = AppGray)
                    var listLinks = listOf<TextAndLink>(
                        TextAndLink("Edit Profile","editProfile"),
                        TextAndLink("Privacy Policy","privacyPolicy"),
                        TextAndLink("Settings","settings"),
                    )
                    listLinks.forEach {
                        Row(modifier = Modifier
                            .padding(vertical = 18.dp)
                            .fillMaxWidth()
                            .clickable(
                                onClick = {
                                    navController.navigate(it.link)
                                }
                            ), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            TextWhite(text = it.text)
                            Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "", tint = Color.White, modifier = Modifier.size(18.dp))
                        }
                        Divider(color = AppGray)
                    }
                }
                if(isProUser!==true){
                    Row(modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(AppGray)
                        .padding(12.dp)
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                        Column {
                            TextWhite(text = "PRO", fontWeight = FontWeight.SemiBold,fontSize=15.sp, modifier = Modifier
                                .padding(bottom = 2.dp)
                                .background(AppRed)
                                .padding(horizontal = 4.dp, vertical = 2.dp)
                                .clip(
                                    RoundedCornerShape(50)
                                ))
                            TextWhite(text = "Upgrade to Premium", fontWeight = FontWeight.SemiBold, fontSize = 17.sp, modifier = Modifier.padding(bottom = 6.dp))
                            TextWhite(text = "This subscription is auto-renewable")
                        }
                        Icon(imageVector = Icons.Default.ArrowForwardIos, contentDescription = "", tint = Color.White, modifier = Modifier.size(18.dp))
                    }
                }
                Column(modifier = Modifier.padding(bottom = 30.dp)) {
                    Divider(color = AppGray)
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Sign Out", color = AppRed)
                    }
                    Divider(color = AppGray)
                }
            }
        }
    }, bottomAppBar = {})
}