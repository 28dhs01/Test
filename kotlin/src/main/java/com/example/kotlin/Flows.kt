package com.example.kotlin

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(){
    val userLoginData = UserLoginData()
    val loginStatusFlow = userLoginData.loginStatusFlow
    runBlocking {
        launch{
            delay(10000)
            loginStatusFlow.collect{
                println("Login Status on thread 1: $it")
            }
        }
        launch {
            userLoginData.updateLoginStatus(true)
            loginStatusFlow.collect{
                println("Login Status on thread 2: $it")
            }
        }
    }


}

class UserLoginData{
    private var loginStatusValue = false
    val loginStatusFlow = flow<Boolean> {
        emit(loginStatusValue)
    }
    fun updateLoginStatus(loginStatus: Boolean){
        loginStatusValue = loginStatus
    }
}