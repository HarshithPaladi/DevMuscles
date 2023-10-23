package com.example.devmuscles.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.devmuscles.R
import com.example.devmuscles.components.IconNavigationButton
import com.example.devmuscles.ui.theme.AppBG
import com.example.devmuscles.ui.theme.AppGray
import com.example.devmuscles.ui.theme.AppGreen
import com.example.devmuscles.ui.theme.AppWhite

@Composable
fun GenderPickerView( navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(AppBG)){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 56.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GenderSelectionGreetingText(navController = navController)
        }
    }
}

@Composable
fun GenderSelectionGreetingText(navController: NavController) {
    val configuration = LocalConfiguration.current
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(start = 28.dp, end = 28.dp
        )
    ) {
        TextWhite(
            text = "TELL US ABOUT YOURSELF!",
            fontSize = 24.sp,
            fontWeight = FontWeight(900)
        )
        TextWhite(
            text = "TO GIVE YOU A BETTER EXPERIENCE WE NEED",
            fontSize = 12.sp,
            fontWeight = FontWeight(900),
            modifier = Modifier.padding(top = 16.dp, start = 28.dp, end = 28.dp)
        )
        TextWhite(
            text = "TO KNOW YOUR GENDER",
            fontSize = 12.sp,
            fontWeight = FontWeight(800),
        )
        Spacer(modifier = Modifier.padding(top = (configuration.screenHeightDp.times(0.15f).dp)))
        Column {
            var selectedGender by remember {
                mutableStateOf(Gender.NONE)
            }
            GenderButton(
                gender = Gender.MALE,
                selectedGender = selectedGender,
                onClick = { selectedGender = Gender.MALE }
            )
            Spacer(modifier = Modifier.padding(top = 56.dp))
            GenderButton(
                gender = Gender.FEMALE,
                selectedGender = selectedGender,
                onClick = { selectedGender = Gender.FEMALE }
            )
        }
        Spacer(modifier = Modifier.padding(top = 56.dp))
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 28.dp)
        ) {
            IconNavigationButton(
                text = "NEXT",
                onClick = {
                    navController.navigate("age_picker")
                },
                icon = Icons.AutoMirrored.Filled.ArrowForward,
            )
        }
    }
}
enum class Gender(
    val gender: String,
){
    MALE("male"),
    FEMALE("female"),
    NONE("none")
}
@Composable
fun GenderButton(
    gender: Gender,
    selectedGender: Gender,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    val configuration = LocalConfiguration.current
    OutlinedIconButton(onClick = onClick,
        modifier = Modifier.size(configuration.smallestScreenWidthDp.times(0.40f).dp),
        colors = IconButtonDefaults.outlinedIconButtonColors(
            contentColor = if(gender == selectedGender) Color.Black else AppWhite,
            containerColor = if(gender == selectedGender) AppGreen else AppGray,
        ),
        border = null,
        content = {
            GenderIcon(
                icon = when (gender) {
                    Gender.MALE -> R.drawable.baseline_male_24
                    Gender.FEMALE -> R.drawable.baseline_female_24
                    Gender.NONE -> 0
                },
                contentDescription = gender.name,
                modifier = Modifier.size(configuration.smallestScreenWidthDp.times(0.20f).dp)

            )
        }
        )
}

@Composable
fun GenderIcon(
    icon: Int,
    contentDescription: String,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
//        modifier = modifier
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = contentDescription, modifier = modifier)
        Text(text = contentDescription, fontSize = 12.sp, fontWeight = FontWeight(800))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TestPreview() {
    GenderPickerView(navController = NavController(LocalContext.current))
}