package com.example.kotlin.higherOrdrerFunctions

val twoTimes: (Int)->Int = {item:Int -> 2*item}
fun main(){
//    println(twoTimes(7))
    val list = (1..10).toList()
//    for ( item in list ){
//        println(item)
//    }
//    list.forEach {
//        println(it)
//    }
//    list.customForEach {
//        println(it)
//    }
//    val customizedList = list.customizedList{item->
//        val newItem = twoTimes(item)
//        newItem
//    }
//    println(customizedList)
    val oddSquaredSum = list.myFilter {
        it%2!=0
    }.oddSum().customMap{
        it*it
    }
    println(oddSquaredSum)
}

fun List<Int>.customForEach(action: (Int)->Unit){
    for (item in this){
        action(item)
    }
}
fun List<Int>.customizedList(action: (Int)->Int): List<Int>{
    val alteredList: MutableList<Int> = mutableListOf()
    for(item in this){
        val res = action(item)
        alteredList.add(res)
    }
    return alteredList
}

fun List<Int>.oddSum():Int{
    var oddSum = 0
    for( item in this ){
        if(item%2!=0){
            oddSum += item
        }
    }
    return oddSum
}

fun List<Int>.myFilter(filter: (Int)->Boolean): List<Int>{
    val customList: MutableList<Int> = mutableListOf()
    for( item in this ){
        val shouldAdd = filter(item)
        if( shouldAdd ){
            customList.add(item)
        }
    }
    return customList
}
fun Int.customMap(transform:(Int)->Int):Int{
    return transform(this)
}
