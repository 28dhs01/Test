package com.example.kotlin.higherOrdrerFunctions

fun main(){
//    var list = (1..10).toList()
//    list  = list.customFilter {
//        it % 2 == 0
//    }
//    println(list)


//    getUserPosts(2){blocked->
//        if(blocked){
//            "blocked"
//        }else{
//            "unblocked"
//        }
//    }


}

fun List<Int>.customFilter(myFun: (Int)-> Boolean): List<Int>{
    val newList = mutableListOf<Int>()
    this.forEach {
        val isPos = myFun(it)
        if(isPos){
            newList.add(it)
        }
    }
    return newList
}

fun getUserPosts(id: Int, blocked: (Boolean)->String ){
    val res = if( id == 1 ){ blocked(true)
    } else{
        blocked(false)
    }
    println(res)
}