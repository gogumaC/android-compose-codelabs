package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.codelabs.state.ui.theme.BasicStateCodelabTheme

@Composable
fun WellnessScreen(
    modifier:Modifier=Modifier,
    wellnessViewModel:WellnessViewModel=viewModel()
){
    Column(modifier=modifier) {
        StatefulCounter(modifier)

        WellnessTasksList(
            list=wellnessViewModel.tasks,
            onCloseTask={task-> wellnessViewModel.remove(task)},
            onCheckedTask={task,checked->
                wellnessViewModel.changeTaskChecked(task,checked)
            }
        )
    }

}


@Preview(showBackground = true)
@Composable
fun WellnessScreenPreview(){
    BasicStateCodelabTheme {
        WellnessScreen()
    }
}