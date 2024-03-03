package com.example.test.like_btn_on_lazy_column

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LikesViewModel : ViewModel() {
    private val _posts: MutableStateFlow<List<Post>> = MutableStateFlow(emptyList())
    val posts: StateFlow<List<Post>> = _posts.asStateFlow()
    fun getPosts() {
        val posts: MutableList<Post> = mutableListOf<Post>()
        (1..100).forEach {
            posts.add(Post(it))
        }
        _posts.value = posts
    }

    fun updatePost(id: Int) {
        _posts.value = _posts.value.map { post ->
            if (post.id == id) {
                // Create a new post with updated content for the specified ID
                post.copy(
                    isLiked = !post.isLiked,
                    likesCount = if (post.isLiked) post.likesCount - 1 else post.likesCount + 1
                )
            } else {
                // Keep other posts unchanged
                post
            }
        }
    }
}

data class Post(
    val id: Int,
    var isLiked: Boolean = false,
    val content: String = "This is post content",
    var likesCount: Int = 0
)