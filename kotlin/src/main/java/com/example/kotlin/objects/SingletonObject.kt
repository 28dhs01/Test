package com.example.kotlin.objects


object Leader{
    const val NAME = "Ram"
}
fun main(){
//    below is an eg. of singleton object
//    val leader1 = Leader.NAME
//    val leader2 = Leader.NAME
//    println(leader1 == leader2)

//    below is normal class with two different objects
//    val male1 = Male("Ram",23)
//    val male2 = Male("Ram",23)
//    println(male1 == male2)

//    eg. of companion objects -->
//    val familyMember1 = FamilyMember.create("Ram")
//    val familyMember2 = FamilyMember.create("Ram")
//    println(familyMember1 == familyMember2)
//    val sum = FamilyMember.add(1,2)
//    println(sum)

//    eg. of anonymous class
    val myApi = object : MyApi{
        override fun doSomething() {
            println("do something")
        }
    }
    myApi.doSomething()
}
class Male(val name: String, val age: Int){
    init {
        println("name is $name and age is $age")
    }
}

class FamilyMember(name: String){
    companion object{
        fun create(name: String): FamilyMember{
            return FamilyMember(name)
        }

        fun add(a: Int, b: Int): Int{
            return a+b
        }
    }
}

interface MyApi{
    fun doSomething()
}