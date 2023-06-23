package com.codelabs.state.ui.theme

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class WellnessTask(
    val id:Int,
    val label:String,
    initialChecked:Boolean=true){

    var checked by mutableStateOf(initialChecked)

}
