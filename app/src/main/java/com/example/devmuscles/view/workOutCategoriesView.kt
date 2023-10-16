package com.example.devmuscles.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.devmuscles.R
import com.example.devmuscles.data.beginnerWorkoutList
import com.example.devmuscles.model.WorkoutCategory
import com.example.devmuscles.ui.theme.AppBG
import com.example.devmuscles.ui.theme.AppDarkGray
import com.example.devmuscles.ui.theme.AppGreen
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment




@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun workOutCategoriesView() {
    Scaffold(
        bottomBar = {
            BottomAppBarComposable()
        }
    ) {
        Column(
            Modifier
                .padding(it)
                .background(AppBG)
                .padding(top = 40.dp)) {

            val titles = listOf("Beginner", "Intermediate", "Advance")
            var tabIndex by remember { mutableStateOf(0) }
            Text(text = "Workout Categories",color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 20.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            TabRow(
                selectedTabIndex = tabIndex,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 20.dp)
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
                    val color = if (tabIndex == index) AppGreen else AppDarkGray
                    val textColor = if (tabIndex == index) Color.Black else Color.White
                    Tab(
                        text = { Text(title, color = textColor) },
                        selected = tabIndex == index,
                        onClick = { tabIndex = index },
                        modifier = Modifier
                            .clip(RoundedCornerShape(50))
                            .background(color = color)
                            .height(30.dp)
                    )
                }
            }
            LazyColumn(modifier = Modifier.padding(horizontal = 20.dp)){
                items(beginnerWorkoutList){
                    CardBox(text1 = it.text1, text2 = it.text2, imageId = it.imageId, isClickable = false, onClick = {}, isPro = it.isPro)
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}