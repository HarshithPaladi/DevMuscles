package com.example.devmuscles.view

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.FactCheck
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.example.devmuscles.components.IconNavigationButton
import com.example.devmuscles.ui.theme.AppDarkGray
import com.example.devmuscles.ui.theme.AppGray
import com.example.devmuscles.ui.theme.AppGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController){
    BoxWithConstraints(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)) {
        Image(painter = painterResource(id = R.drawable.background_login), contentDescription = "", modifier = Modifier
            .padding(horizontal = 0.dp)
            .fillMaxSize()
            .alpha(0.5f), alignment = Alignment.TopCenter,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply { setToSaturation(0.5f) })
        )
        BoxWithConstraints(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.TopCenter)){
            val trianglePath = Path().apply {
                // Moves to top center position
                moveTo( 0f, constraints.maxHeight/1.57f)

                // 2)
                lineTo(constraints.maxWidth*1f, constraints.maxHeight/1.57f)

                // 3)
                lineTo(constraints.maxWidth*1f, constraints.maxHeight/2.5f)
            }
            Canvas(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.8f)
            ) {
                drawPath(path = trianglePath, color = Color.Black)
            }
        }
        Box {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().padding(top = 40.dp)
            ) {
                ClickableTextWithUnderline(text = "Login", navController = navController)
                ClickableTextWithUnderline(text = "Sign Up", requireUnderline = false, navController = navController)
                Spacer(modifier = Modifier.padding(start = 100.dp))
                Image(painter = painterResource(id = R.drawable.profile_pic1), contentDescription ="",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(60.dp)
                        .border(2.dp, AppGray, CircleShape),
                    alignment = Alignment.Center)
            }
        }
        val configuration  = LocalContext.current.resources.configuration
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = configuration.screenHeightDp.dp / 3f, start = 20.dp, end = 8.dp),
        ){
                Text(
                    text = "WELCOME BACK,\nSARAH",
                    style = TextStyle(
                        fontSize = 40.sp,
                        fontWeight = FontWeight(900),
                        color = Color(0xFFFFFFFF),
                        fontFamily = FontFamily.SansSerif
                    )
                )

        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = configuration.screenHeightDp.dp / 1.6f, start = 48.dp, end = 48.dp),

        ){
            var a by remember {
                mutableStateOf("")
            }
            var b by remember {
                mutableStateOf("")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CustomTextField(value = a, label = "Email", onValueChange = {a = it},
                    trailingIcon = Icons.AutoMirrored.Filled.FactCheck)
                Spacer(modifier = Modifier.padding(top = 24.dp))
                CustomTextField(value = b, label = "Password", onValueChange = {b = it},
                    trailingIcon = Icons.AutoMirrored.Filled.FactCheck)
            }

        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 112.dp, end = 60.dp)
        ) {
            Text(text = "Forgot Password?", color = AppGreen,
                fontWeight = FontWeight(900), fontSize = 12.sp,
                modifier = Modifier.padding(top = 16.dp))
        }

       LoginScreenButtons( modifier = Modifier
           .padding(bottom = 20.dp, start = 20.dp, end = 20.dp)
           .align(Alignment.BottomCenter),
           action = "Login",
           onClick = { navController.navigate("home")},
       )
    }
}


@Composable
fun LoginScreenButtons(
    modifier: Modifier = Modifier,
    action: String,
    onClick: () -> Unit
){
    Box(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            LogoButton(
                onClick = { /* handle Apple login */ },
                icon = painterResource(id = R.drawable.apple),
                contentDescription = "Apple logo"
            )
            LogoButton(
                onClick = { /* handle Google login */ },
                icon = painterResource(id = R.drawable.google),
                contentDescription = "Google logo"
            )
            IconNavigationButton(onClick = {onClick()},
                icon = Icons.AutoMirrored.Filled.ArrowForward,
                modifier = Modifier.padding(start = 16.dp),
                text = action,
            )
        }
    }
}
@Composable
fun LogoButton(
    onClick: () -> Unit,
    icon: Painter,
    contentDescription: String
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .background(Color.Transparent)
            .padding(end = 16.dp)
            .size(56.dp),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        border = null,
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            containerColor = AppDarkGray,
        )
    ) {
        Image(
            painter = icon,
            contentDescription = contentDescription
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    trailingIcon: ImageVector? = null
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        modifier = Modifier
            .background(Color.Transparent)
            .border(0.dp, Color.Transparent),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color.White,
            errorIndicatorColor = Color.Red,
            focusedLabelColor = AppGreen,
            unfocusedLabelColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            placeholderColor = AppGreen,
            textColor = Color.White
        ),
        trailingIcon = {
            trailingIcon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    tint = AppGreen
                )
            }
        }
    )
}

@Composable
@Preview
fun LoginScreenPreview(){
    LoginScreen(navController = NavController(LocalContext.current))
}

