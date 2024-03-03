package com.example.kotlin

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.Duration.Companion.seconds

fun main(){
//    val user: User? = fetchCurrentUser()
//    println(user)
//    val userEmail: String? = getUserEmail()
//    user?.apply {
//        age = 24
//        email= userEmail
//    }
//    println(user)

//    let - non-null objects only. inside the body you can access the other methods which are dependent on the object
//    val userId: Int? = 10
//    val userName = userId?.let{id->
//        println(id.shl(2))
//        fetchUserFullName(id = id)
//    }
//    println(userName)

    userFriends()

}
class User(
    val name: String,
    var age : Int,
    var email: String?,
    val phone: String?
){
    override fun toString(): String {
        return "User($name,$age,$email,$phone)"
    }
}
fun fetchCurrentUser(): User?{
    return User(name = "Dhruv", age = 23, email = null, phone = null)
}
fun getUserEmail():String?{
    return "dhruv@gmail.com"
}

fun fetchUserFullName(id: Int): String{
    return "Dhruv"
}

fun userFriends(){
    val lst = mutableListOf<Int>()
   runBlocking {
        getFriendsIds().collect{
            lst.add(it)
            println(it)
        }
       println(lst)
    }
}
fun getFriendsIds() =
    flow<Int> {
        for (i in 1..10){
            emit(i)
            delay(1.seconds)
        }
    }

