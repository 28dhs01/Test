package com.example.test.accessFiles

import android.net.Uri
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.FileProvider
import coil.compose.AsyncImage
import com.example.test.customLog
import java.io.File

@Composable
fun CameraScreen() {
    val context = LocalContext.current
    val file = File(context.filesDir, "photo.jpg")
    val uri = FileProvider.getUriForFile(
        context,
        "com.example.test.fileProvider",
        file
    )
    var capturedImageUri by remember {
        mutableStateOf<Uri>(Uri.EMPTY)
    }
    customLog("$capturedImageUri")

    val cameraLauncher: ManagedActivityResultLauncher<Uri, Boolean> =
        rememberLauncherForActivityResult(
            contract = ActivityResultContracts.TakePicture(),
            onResult = {
                if (it) {
                    capturedImageUri = uri
                    customLog("success")

                }else{
                    customLog("failure")
                }
            }
        )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                cameraLauncher.launch(uri)
            }
        ) {
            Text(text = "open camera")
        }
        Text(text = "$capturedImageUri")
        AsyncImage(modifier = Modifier.size(250.dp), model = capturedImageUri, contentDescription = null)
    }
}