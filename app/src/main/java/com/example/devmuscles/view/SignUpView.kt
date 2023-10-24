package com.example.devmuscles.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.FactCheck
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.devmuscles.R
import com.example.devmuscles.components.ClickableTextWithUnderline

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController){
    BoxWithConstraints(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Image(painter = painterResource(id = R.drawable.background_signup), contentDescription = "", modifier = Modifier
            .padding(horizontal = 0.dp)
            .fillMaxSize(), alignment = Alignment.TopCenter,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0.5f) })
        )
        BoxWithConstraints(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.TopCenter)){
            val trianglePath = Path().apply {
                // Moves to top center position
                moveTo( 0f, constraints.maxHeight/1.89f)

                // 2)
                lineTo(constraints.maxWidth*1f, constraints.maxHeight/1.89f)

                // 3)
                lineTo(constraints.maxWidth*1f, constraints.maxHeight/2.5f)
            }
            Canvas(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
            ) {
                drawPath(path = trianglePath, color = Color.Black)
            }
        }
        Box {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(top = 60.dp)
            ) {
                ClickableTextWithUnderline(text = "Login",requireUnderline = false, navController = navController)
                ClickableTextWithUnderline(text = "Sign Up",navController = navController)
            }

        }
        val configuration  = LocalContext.current.resources.configuration
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = configuration.screenHeightDp.dp / 3.7f, start = 20.dp, end = 8.dp),
        ){
            Column {
                Text(
                    text = "HELLO ROOKIES,",
                    style = TextStyle(
                        fontSize = 40.sp,
                        fontWeight = FontWeight(900),
                        color = Color(0xFFFFFFFF),
                        fontFamily = FontFamily.SansSerif
                    )
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "ENTER YOUR INFORMATIONS BELOW OR\nLOGIN WITH A OTHER ACCOUNT",
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                        fontFamily = FontFamily.SansSerif
                    )
                )
            }

        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = configuration.screenHeightDp.dp / 1.8f, start = 48.dp, end = 48.dp),

            ){
            var a by remember {
                mutableStateOf("")
            }
            var b by remember {
                mutableStateOf("")
            }
            var c by remember {
                mutableStateOf("")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                CustomTextField(value = a, label = "Email", onValueChange = {a = it},
                    trailingIcon = Icons.AutoMirrored.Filled.FactCheck)
                Spacer(modifier = Modifier.padding(top = 24.dp))
                CustomTextField(value = b, label = "Password", onValueChange = {b = it},
                    trailingIcon = Icons.AutoMirrored.Filled.FactCheck)
                Spacer(modifier = Modifier.padding(top = 24.dp))
                CustomTextField(value = c, label = "Password Again", onValueChange = {c = it},
                    trailingIcon = Icons.AutoMirrored.Filled.FactCheck)
            }

        }
        LoginScreenButtons( modifier = Modifier
            .padding(bottom = 20.dp, start = 20.dp, end = 20.dp)
            .align(Alignment.BottomCenter),
            action = "Sign Up",
            onClick = { navController.navigate("home")},
        )
    }
}



@Composable
@Preview
fun SignUpScreenPreview(){
    SignUpScreen(navController = NavController(LocalContext.current))
}