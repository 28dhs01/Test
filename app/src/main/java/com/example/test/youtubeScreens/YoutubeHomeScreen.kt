package com.example.test.youtubeScreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun YoutubeHomeScreen(videos: List<Video>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        items(videos) {
            VideoItem(video = it)
        }
    }
}

@Composable
fun VideoItem(video: Video) {
    Column {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = video.thumbnailId),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape),
                painter = painterResource(id = video.channelImageId),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = video.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = video.channelName+" ",style = MaterialTheme.typography.bodySmall)
                    Text(text = video.views+" views ",style = MaterialTheme.typography.bodySmall)
                    Text(text = video.date, style = MaterialTheme.typography.bodySmall)
                }

            }

        }

    }

}

data class Video(
    val title: String,
    val thumbnailId: Int,
    val channelImageId: Int,
    val channelName: String,
    val views: String,
    val date: String
)