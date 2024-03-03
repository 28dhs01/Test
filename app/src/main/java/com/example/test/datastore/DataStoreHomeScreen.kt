package com.example.test.datastore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataStoreHomeScreen(dataStoreViewModel: DataStoreViewModel) {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = { Text(text = "Home Screen") }
        )
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Home Screen")
            Button(onClick = {
                dataStoreViewModel.updateLoginStatus(isLoggedIn = false)
            }){
                Text(text = "Logout")
            }
        }
    }
}