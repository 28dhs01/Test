package com.example.test.longClick

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.test.customLog

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun LongClickHomeScreen() {
    val count: MutableState<Int> = rememberSaveable {
        mutableStateOf(0)
    }
    val longPressed: MutableState<Boolean> = rememberSaveable{
        mutableStateOf(false)
    }
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = {
            Text(
                text = "Button Screen",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
        })

    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "${count.value}")
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(if(!longPressed.value){MaterialTheme.colorScheme.error} else{
                        Color.Cyan})
                    .combinedClickable(enabled = true, onClick = {
                        count.value++
                        longPressed.value = false
                    }, onLongClick = {
                        customLog("long pressed")
                        count.value += 5
                        longPressed.value = true
                    })
            )
        }
    }
}