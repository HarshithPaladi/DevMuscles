package com.example.devmuscles.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import com.example.devmuscles.ui.theme.AppGreen

@Composable
fun TextWhite(text:String, fontWeight: FontWeight?, fontSize: TextUnit, modifier: Modifier){
    Text(text = text, fontWeight = fontWeight, fontSize = fontSize, modifier = modifier, color = Color.White)
}

@Composable
fun TextWhite(text:String, fontWeight: FontWeight?){
    Text(text = text, fontWeight = fontWeight, color = Color.White)
}
@Composable
fun TextWhite(text:String, fontSize: TextUnit, modifier: Modifier){
    Text(text = text, fontSize = fontSize, color = Color.White, modifier = modifier)
}

@Composable
fun TextWhite(text:String, fontSize: TextUnit){
    Text(text = text, fontSize = fontSize, color = Color.White)
}
@Composable
fun TextWhite(text:String, fontWeight: FontWeight?, fontSize: TextUnit){
    Text(text = text, fontWeight = fontWeight, color = Color.White, fontSize = fontSize)
}

@Composable
fun TextWhite(text:String){
    Text(text = text, color = Color.White)
}

@Composable
fun TextGreen(text:String, fontWeight: FontWeight?, fontSize: TextUnit, modifier: Modifier){
    Text(text = text, fontWeight = fontWeight, fontSize = fontSize, modifier = modifier, color = AppGreen)
}

@Composable
fun TextGreen(text:String, fontWeight: FontWeight?){
    Text(text = text, fontWeight = fontWeight, color = AppGreen)
}

@Composable
fun TextGreen(text:String, fontWeight: FontWeight?, fontSize: TextUnit){
    Text(text = text, fontWeight = fontWeight, color = AppGreen, fontSize = fontSize)
}

@Composable
fun TextGreen(text:String){
    Text(text = text, color = AppGreen)
}