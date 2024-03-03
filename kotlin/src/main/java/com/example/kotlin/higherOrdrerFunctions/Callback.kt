package com.example.kotlin.higherOrdrerFunctions

import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        operate(10,25){a,b->
            a+b
        }

    }
}
fun operate(a: Int,b: Int,operation: (Int,Int)->Int):Int{
    val result = operation(a,b)
    return result
}
