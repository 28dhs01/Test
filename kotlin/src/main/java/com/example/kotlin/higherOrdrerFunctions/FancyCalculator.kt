package com.example.kotlin.higherOrdrerFunctions

fun calculator(a:Int, b: Int, operation: (Int,Int)-> Int): Int{
    val result = operation(a,b)
    return result
}

fun main(){
    val addition: (Int,Int) -> Int = {a:Int, b: Int -> a+b}
    val result = calculator(10,2){a,b->
        addition(a,b)
    }
    println(result)
}