package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    Column() {

        if (count > 0) {

            Text(
                text = "You've had $count glasses",
                modifier = modifier.padding(16.dp)
            )
        }
        Button(onClick = { count++ }, enabled = count < 10) {
            Text("Add one")
        }

    }

}

@Composable
fun StatefulCounter(modifier:Modifier=Modifier){
    var waterCount by remember{ mutableStateOf(0) }


    StatelessCounter(count = waterCount, onIncrement = { waterCount++ })


}

@Composable
fun StatelessCounter(count:Int,onIncrement:()->Unit,modifier:Modifier=Modifier){
    Column(modifier=modifier.padding(16.dp)){
        if(count>0){
            Text("You've had $count glasses.")
        }
        Button(onClick=onIncrement,Modifier.padding(top=9.dp),enabled=count<10){
            Text("Add one")
        }
    }
}