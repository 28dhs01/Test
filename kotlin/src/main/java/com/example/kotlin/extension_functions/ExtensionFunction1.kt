package com.example.kotlin.extension_functions


fun main(){
    val list = (1..10).toList()
    list.forEach {
        if(it.isOdd()){
            println("$it is odd")
        }else{
            println("$it is even")
        }
    }
    val lastIndex = list.lastIndex
}
fun Int.isOdd():Boolean {
    return this%2 != 0
}

val List<Int>.lastIndex: Int
    get() = size - 1