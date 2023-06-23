package com.codelabs.state.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.codelabs.state.StatefulCounter
import com.codelabs.state.WaterCounter

@Composable
fun WellnessScreen(modifier:Modifier=Modifier){
    Column(modifier=modifier){
        StatefulCounter()
        val list=remember{ getWellnessTasks().toMutableStateList() }
        WellnessTaskList(list=list,onCloseTask={task->list.remove(task)})
    }

}

private fun getWellnessTasks()=List(30){i-> WellnessTask(i,"Task # $i")}

@Preview(showBackground = true)
@Composable
fun WellnessScreenPreView(){
    WellnessScreen()
}