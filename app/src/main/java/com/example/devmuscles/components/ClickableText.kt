package com.example.devmuscles.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.devmuscles.ui.theme.AppGreen

@Composable
fun ClickableTextWithUnderline(
    text: String,
    modifier: Modifier = Modifier,
    requireUnderline: Boolean = true,
    navController: NavController
) {
    Text(
        text = text,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        modifier = modifier
            .padding(start = 40.dp)
            .drawBehind {
                if (requireUnderline) {
                    val strokeWidthPx = 5.dp.toPx()
                    val verticalOffset = size.height + 10.sp.toPx()
                    drawLine(
                        color = AppGreen,
                        strokeWidth = strokeWidthPx,
                        start = Offset(0f, verticalOffset),
                        end = Offset(size.width, verticalOffset)
                    )
                }
            }
            .clickable(
                onClick = {
                    if(text == "Login")
                        navController.navigate("login")
                    else
                        navController.navigate("signup")
                }
            )
    )
}
