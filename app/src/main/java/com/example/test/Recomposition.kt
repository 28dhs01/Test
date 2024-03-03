package com.example.test

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
@Composable
fun CounterExample(){
    var counter : Int = 0
    customLog("$counter")
    Column {
        Text(text = "$counter")
        Button(onClick = {
            counter++
        }) {
            Text(text = "Click Me")
        }
    }
}
@Composable
fun Child(
    counter: Int,
    onCounterChange: ()->Unit
){
    Column {
        Text(text = "$counter")
        Button(onClick = {
            onCounterChange()
        }) {
            Text(text = "Click Me")
        }
    }
}

@Composable
fun Parent(){
    val counter = remember {
        mutableIntStateOf(0)
    }
    Child(counter = counter.intValue){
        counter.intValue++
    }
}
@Preview()
@Composable
fun ParentPreview(){
    Parent()
}
//@Preview
//@Composable
//fun CounterExamplePreview(){
//    CounterExample()
//}