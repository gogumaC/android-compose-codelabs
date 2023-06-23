package com.codelabs.state.ui.theme

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


private fun getWellnessTasks()=List(30){i -> WellnessTask(i,"Task #$i")}

@Composable
fun WellnessTaskList(
    modifier: Modifier=Modifier,
    onCheckedTask:(WellnessTask,Boolean)->Unit,
    onCloseTask:(WellnessTask)->Unit,
    list:List<WellnessTask> = remember{ getWellnessTasks() }
){
    LazyColumn(
        modifier=modifier
    ){
        items(
            items=list,
            key={task->task.id} //위치 기반이 아닌 요소 각각의 상태를 유지 ->이렇게 안하면 체크가 된 1번을 삭제시 1번의 위치에 들어오는 2번이 체크상태로 변해버림
        ){task->
            WellnessTaskItem(
                taskName = task.label,
                onClose = { onCloseTask(task) },
                onCheckedChange = {checked-> onCheckedTask(task,checked)},
                checked=task.checked
            )
        }
    }
}