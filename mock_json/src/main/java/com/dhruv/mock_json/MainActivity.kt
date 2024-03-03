package com.dhruv.mock_json

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.dhruv.mock_json.ui.theme.TestTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val mockJson = CustomerMockData.mockJson
        setContent {
            TestTheme {
                Log.d("MainActivity", "onCreate: $mockJson")
            }
        }
    }
}

