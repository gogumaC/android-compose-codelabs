package com.codelabs.state.ui.theme

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

//Stateful composable
@Composable
fun WellnessTaskItem(
    taskName: String,
    modifier: Modifier=Modifier
){
    var checkState by remember{ mutableStateOf(false) }
    WellnessTaskItem(
        taskName = taskName,
        checked = checkState,
        onCheckedChange = {checkState=it},
        onClose = { /*TODO*/ },
        modifier=modifier
    )
}

//Stateless composable
@Composable
fun WellnessTaskItem(
    taskName:String,
    checked:Boolean,
    onCheckedChange:(Boolean)->Unit,
    onClose:()->Unit,
    modifier:Modifier=Modifier
){
    Row(
        modifier=modifier,
        verticalAlignment = Alignment.CenterVertically,
    ){
        Text(
            modifier= Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text=taskName
        )
        Checkbox(
            checked=checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Close"
            )
        }
    }
}


