package com.example.test.datastore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.customLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(private val datastoreRepository: DatastoreRepository) :
    ViewModel() {

    val loginStatus: Flow<Boolean> = datastoreRepository.loginStatus

    fun updateLoginStatus(isLoggedIn: Boolean) {
        viewModelScope.launch {
            datastoreRepository.updateLoginStatus(isLoggedIn = isLoggedIn)
        }
    }

}