package com.example.devmuscles.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.devmuscles.ui.theme.AppGray
import com.example.devmuscles.ui.theme.AppGreen


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Preview
@Composable
fun EditProfileScreen() {
    WrapperScreen(title = "EDIT PROFILE", content = {
        Column(modifier = Modifier
            .padding(horizontal = 25.dp)
            .fillMaxWidth()) {
//Image
            Column(modifier = Modifier.fillMaxWidth()) {
                Divider(color = AppGray)
                Column(Modifier.padding(vertical = 16.dp)) {
                    TextGreen(text = "Name")
                    BasicTextField(
                        value = "a",
                        onValueChange = {},
                        modifier = Modifier.padding(top = 4.dp),
                        textStyle = TextStyle.Default.copy(fontSize = 24.sp, color = Color.White),
                    )
                }
                Divider(color = AppGray)
                Column(Modifier.padding(vertical = 16.dp)) {
                    TextGreen(text = "Email")
                    BasicTextField(
                        value = "a",
                        onValueChange = {},
                        modifier = Modifier.padding(top = 4.dp),
                        textStyle = TextStyle.Default.copy(fontSize = 24.sp, color = Color.White),
                    )
                }
                Divider(color = AppGray)
            }
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.align(Alignment.BottomCenter)) {
                BottomButtonBox()
            }
        }
    }) {

    }
}