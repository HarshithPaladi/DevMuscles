package com.example.devmuscles

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.devmuscles.ui.theme.AppGreen
import com.example.devmuscles.ui.theme.DevMusclesTheme
import kotlinx.coroutines.delay


class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevMusclesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SplashScreenUI()
                }
            }
        }
    }
    @Composable
    fun SplashScreenUI() {
        var alpha = remember {
            Animatable(0f)
        }
        LaunchedEffect(key1 = true, block = {
            alpha.animateTo(1f, animationSpec = tween(1800))
            delay(100)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        })
        Column( verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally ,modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff000000))){
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(70.dp))
            Image(painter = painterResource(id = R.drawable.splash_logo), contentDescription = "", modifier = Modifier.size(120.dp).alpha(alpha.value))
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(20.dp))
            Text(text = "DEV", color = AppGreen, fontSize = 80.sp, fontWeight = FontWeight.ExtraBold)
            Text(text = "MUSCLES", color = AppGreen, fontSize = 50.sp, fontWeight = FontWeight(900), modifier = Modifier.offset(y=(-30).dp))
        }
    }
}


