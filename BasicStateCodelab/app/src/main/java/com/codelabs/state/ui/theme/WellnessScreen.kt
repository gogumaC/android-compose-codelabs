package com.codelabs.state.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.codelabs.state.StatefulCounter
import com.codelabs.state.WaterCounter

@Composable
fun WellnessScreen(modifier:Modifier=Modifier){
    StatefulCounter(modifier)
}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreView(){
    WellnessScreen()
}