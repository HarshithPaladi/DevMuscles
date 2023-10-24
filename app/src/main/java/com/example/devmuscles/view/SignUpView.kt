package com.example.devmuscles.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.devmuscles.R
import com.example.devmuscles.components.ClickableTextWithUnderline
import com.example.devmuscles.ui.theme.AppDarkGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavController){
    BoxWithConstraints(modifier = Modifier.fillMaxSize().background(AppDarkGray)) {
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
                moveTo( 0f, constraints.maxHeight/1.65f)

                // 2)
                lineTo(constraints.maxWidth*1f, constraints.maxHeight/1.65f)

                // 3)
                lineTo(constraints.maxWidth*1f, constraints.maxHeight/2f)
            }
//            Canvas(modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.3f)
//            ) {
//                drawPath(path = trianglePath, color = Color.Black)
//            }
        }
        Box {
            Row {
                ClickableTextWithUnderline(text = "Login",requireUnderline = false, navController = navController)
                ClickableTextWithUnderline(text = "Sign Up",navController = navController)
            }

        }
    }
}



@Composable
@Preview
fun SignUpScreenPreview(){
    SignUpScreen(navController = NavController(LocalContext.current))
}