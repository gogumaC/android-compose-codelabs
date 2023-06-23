package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier:Modifier= Modifier){
    Column(
        modifier = modifier.padding(16.dp)
    ){
        val count: MutableState<Int> = mutableStateOf(0)

        Text(text="You've had $count glasses.")
        Button(
            modifier=Modifier.padding(top=8.dp),
            onClick = {count.value++}
        ){
            Text("Add one")
        }
    }

}