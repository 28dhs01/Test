package com.example.test.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.userPreferenceDataStore: DataStore<Preferences> by preferencesDataStore("my_datastore")
class DataStoreManager @Inject constructor(@ApplicationContext val context: Context) {
    private val userLoginKey = booleanPreferencesKey("user_login_key")
    suspend fun updateLoginStatus(isLoggedIn: Boolean){
        context.userPreferenceDataStore.edit {
            it[userLoginKey] = isLoggedIn
        }
    }
    val userLoginStatus: Flow<Boolean> = context.userPreferenceDataStore.data.map { preferences->
        preferences[userLoginKey] ?: false
    }
}