package com.example.devmuscles.viewModel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GlobalData:ViewModel() {
    var selectedItem by mutableIntStateOf(0)
    fun updateSelectedItem(itemInt:Int){
        selectedItem=itemInt
    }
}