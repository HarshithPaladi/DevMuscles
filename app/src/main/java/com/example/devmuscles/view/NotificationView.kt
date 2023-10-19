package com.example.devmuscles.view


import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.devmuscles.data.notifications
import com.example.devmuscles.ui.theme.AppDarkGray
import com.example.devmuscles.ui.theme.AppGray
import com.example.devmuscles.ui.theme.AppGreen
import com.example.devmuscles.viewModel.GlobalData
import com.google.android.material.bottomappbar.BottomAppBar
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox

@Composable
fun NotificationScreen(navController: NavController){
    var globalData = viewModel<GlobalData>()
    globalData.updateSelectedItem(2)
    WrapperScreen(title = "NOTIFICATIONS", navController = navController,bottomAppBar = {BottomAppBarComposable(navController = navController)}, content = {
            var tabIndex by remember {
                mutableStateOf(0)
            }
        val titles = listOf("New", "Events", "All")
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
                            text = { Text(title, color = textColor) },
                            selected = tabIndex == index,
                            onClick = { tabIndex = index },
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .background(color = color)
                                .height(30.dp))
                    }
                }
                LazyColumn(
                    Modifier
                        .fillMaxSize()
                        .padding(horizontal = 20.dp)) {
                    item{
                        Divider(color = AppGray, modifier = Modifier.padding(top = 10.dp))
                    }
                    items(notifications) {
                        Column(modifier = Modifier.fillMaxWidth().padding(top=15.dp)) {
                            Row(modifier = Modifier.fillMaxWidth().padding(bottom = 6.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                                TextWhite(text = it.text1, fontWeight = FontWeight.Medium)
                                TextWhite(text = it.time)
                            }
                            TextWhite(text = it.text2)
                            Divider(color = AppGray, modifier = Modifier.padding(top = 25.dp))
                        }
                    }
                }
            }
    })
}