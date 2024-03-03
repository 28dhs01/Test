package com.example.kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

fun main() {
//    val userIdsInList = getUserByIdInList()
//    userIdsInList.forEach {
//        println(it)
//    }

//    this is to learn about flows - flows are by default cold in nature
//    runBlocking {
//        launch {
//            getUserByIdAsFlow().collect {
//                println("first collector - $it")
//            }
//        }
//        delay(2000)
//        launch {
//            getUserByIdAsFlow().collect {
//                println("second collector - $it")
//            }
//        }
//
//    }
    getUserIdAsStateFlow()
}

fun getUserByIdInList(): List<Int>{
    val list = mutableListOf<Int>()
    for (i in 1..100){
        list.add(i)
    }
    return list
}
fun getUserByIdAsFlow(): Flow<Int> = flow {
    for (i in 1..5) {
        emit(i)
        delay(duration = 1.seconds)
    }
}
fun getUserIdAsStateFlow(){
    runBlocking {
        val userId1 = MutableStateFlow(0)
        launch {
            getUserByIdAsFlow().collect{
                userId1.value = it
//                println("first collector - ${userId1.value}")
            }
        }
        delay(3000)
        println("first collector - ${userId1.value}")

//        val userId2 = MutableStateFlow(0)
//        delay(4000)
//        launch {
//            getUserByIdAsFlow().collect{
//                userId2.value = it
//                println("second collector - ${userId2.value}")
//            }
//        }
    }
}

