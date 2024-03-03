package com.example.test.datastore

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

//@Composable
//fun DataStoreNavigation(dataStoreViewModel: DataStoreViewModel){
//    dataStoreViewModel.getLoginStatus()
//    val loggedIn = dataStoreViewModel.loginStatus.collectAsState().value
//    if( !loggedIn ){
//        DataStoreLoginScreen(dataStoreViewModel)
//    }else{
//        DataStoreHomeScreen(dataStoreViewModel)
//    }
//}