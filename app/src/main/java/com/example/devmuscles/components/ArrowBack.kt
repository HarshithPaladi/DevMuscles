package com.example.devmuscles.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.devmuscles.ui.theme.AppGray
import com.example.devmuscles.ui.theme.AppWhite

@Composable
fun ArrowBackButton(onClick: () -> Unit, modifier: Modifier = Modifier) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.size(52.dp),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp),
        border = null,
        colors = ButtonDefaults.buttonColors(
            contentColor = AppWhite,
            containerColor = AppGray,
        ),

        ) {

            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
            )
    }
}

@Composable
@Preview
fun ArrowBackButtonPreview() {
    ArrowBackButton(onClick = {})
}