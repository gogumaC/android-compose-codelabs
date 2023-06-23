package com.codelabs.state

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WaterCounter(modifier:Modifier= Modifier){
    val count=0
    Text(text="You've had $count glasses.")
}