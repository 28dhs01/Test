package com.example.test.datastore

import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DatastoreRepository @Inject constructor (private val dataStoreManager: DataStoreManager) {
    suspend fun updateLoginStatus(isLoggedIn: Boolean){
        dataStoreManager.updateLoginStatus(isLoggedIn)
    }
    val loginStatus: Flow<Boolean> = dataStoreManager.userLoginStatus
}