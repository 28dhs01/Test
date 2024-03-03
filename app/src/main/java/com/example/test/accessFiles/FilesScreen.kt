package com.example.test.accessFiles

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.test.customLog
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@RequiresApi(Build.VERSION_CODES.Q)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun FilesScreen() {
    val context = LocalContext.current
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(

        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectedImageUri = uri   }
    )
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "External Files")
        })
    }) {
        val permissionState = rememberPermissionState(
            android.Manifest.permission.READ_MEDIA_IMAGES
        )
            Column(modifier = Modifier
                .padding(it)
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                Button(onClick = {
                    if( permissionState.status.isGranted){
                        val photos = accessDevicePhotos(context)
                        customLog("Photos: ${photos.size}")
                        photos.forEach {
                            customLog("${it.name}")
                        }
                    }else{
                        permissionState.launchPermissionRequest()
                    }

                }) {
                    Text(text = "Access Files")
                }
                Button(onClick = {
                    singlePhotoPickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                }) {
                    Text(text = "Pick Image")
                }
                if(selectedImageUri != null){
                    Text(text = selectedImageUri.toString())
//                    AsyncImage(
//                        model = selectedImageUri,
//                        contentDescription = null
//                    )
                }
            }
    }
}



data class Photo(
    val id: Long,
    val uri: String,
    val name: String
)

@RequiresApi(Build.VERSION_CODES.Q)
fun accessDevicePhotos(context: Context): List<Photo> {
    val projection = arrayOf(MediaStore.Images.Media._ID,
        MediaStore.Images.Media.DISPLAY_NAME,
        MediaStore.Images.Media.DATA )
    val order = "${MediaStore.Images.Media.DISPLAY_NAME} ASC"
    val cursor: Cursor? = context.contentResolver.query(
        MediaStore.Images.Media.getContentUri(MediaStore.VOLUME_EXTERNAL),
         projection,
         null,
         null,
         order
    )
    val photosList = mutableListOf<Photo>()
    if (cursor != null) {
        while(cursor.moveToNext()){
            customLog("${cursor.position}")
            val imageId: Long = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID))
            val imageUri = "${MediaStore.Images.Media.EXTERNAL_CONTENT_URI}/$imageId"
            val imageName: String = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME))
            val photo = Photo(id = imageId, uri = imageUri, name = imageName)
            photosList.add(photo)
        }
        cursor.close()
    }
    return photosList
}

