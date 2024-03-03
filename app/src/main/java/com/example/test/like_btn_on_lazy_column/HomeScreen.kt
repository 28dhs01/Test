package com.example.test.like_btn_on_lazy_column

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LikeBtnHomeScreen(modifier: Modifier = Modifier,viewModel: LikesViewModel) {

    val posts by viewModel.posts.collectAsState()
    LazyColumn(modifier = modifier) {
        items(posts) {
            PostItem(modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
                postItem = it
            ){id->
                viewModel.updatePost(id = id)
            }
        }
    }
}

@Composable
fun PostItem(modifier: Modifier = Modifier, postItem: Post,updatePost: (Int)->Unit) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = postItem.content)
        Row(modifier = modifier
            .background(Color.Cyan)
            , horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "${postItem.likesCount}")
            Icon(
                modifier = Modifier.clickable {
                    updatePost(postItem.id)
                },
                tint = if (postItem.isLiked) Color.Red else Color.Black,
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null
            )
        }
    }

}