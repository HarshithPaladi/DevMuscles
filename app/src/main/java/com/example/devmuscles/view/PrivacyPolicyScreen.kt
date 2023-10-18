package com.example.devmuscles.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController

@Preview
@Composable
fun PrivacyPolicyScreen(){
    WrapperScreen(title = "PRIVACY POLICY", content = {
        var loremText1 = "Consectetur adipiscing elit. Natoque phasellus lobortis mattis cursus faucibus hac proin risus. Turpis phasellus massa ullamcorper volutpat. Ornare commodo non integer fermentum nisi, morbi id. Vel tortor mauris feugiat amet, maecenas facilisis risus, in faucibus. Vestibulum ullamcorper fames eget enim diam fames faucibus duis ac. Aliquam non tellus semper in dignissim nascetur venenatis lacus. "
        var loremText2 = "Lectus vel non varius interdum vel tellus sed mattis. Sit laoreet auctor arcu mauris tincidunt sociis tristique pharetra neque. Aliquam pharetra elementum nisl sapien. Erat nisl morbi eu dolor in. Sapien ut lacus dui libero morbi tristique. "
        Column(Modifier.padding(horizontal = 25.dp)) {
            TextWhite(text = "Lorem ipsum dolor sit amet", fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(10.dp))
            repeat(2){
                TextWhite(text = "$loremText1", style = TextStyle(
                    lineHeight = 1.3.em
                ))
                Spacer(modifier = Modifier.height(8.dp))
                TextWhite(text = "$loremText2", style = TextStyle(
                    lineHeight = 1.3.em
                ))
                Spacer(modifier = Modifier.height(8.dp))
                TextWhite(text = "$loremText1 $loremText2", style = TextStyle(
                    lineHeight = 1.3.em
                ))
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }) {
        
    }
}