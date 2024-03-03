package com.example.kotlin.higherOrdrerFunctions

class NormalCalculator(val a: Int, val b: Int){
    fun add(): Int {
        return a + b
    }
    fun subtract(): Int{
        return a-b
    }
    fun multiply(): Int{
        return a*b
    }
    fun divide(): Int{
        return a/b
    }
}
fun main(){
    val calculator = NormalCalculator(10,2)
    val addition = calculator.add()
    println(addition)
}