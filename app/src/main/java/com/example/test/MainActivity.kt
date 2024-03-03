package com.example.test

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.test.bottomsheet.BottomSheetHomeScreen
import com.example.test.compose.McqScreen
import com.example.test.compose.getList
import com.example.test.datastore.DataStoreHomeScreen
import com.example.test.datastore.DataStoreLoginScreen
import com.example.test.datastore.DataStoreViewModel
import com.example.test.like_btn_on_lazy_column.LikeBtnHomeScreen
import com.example.test.like_btn_on_lazy_column.LikesViewModel
import com.example.test.longClick.LongClickHomeScreen
import com.example.test.nav_drawer.NavDrawerHomeScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val dataStoreViewModel : DataStoreViewModel by viewModels()
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        lifecycleScope.launch {
//            dataStoreViewModel.loginStatus.collect{
//                if (!it){
//                    setContent{
//                        DataStoreLoginScreen(dataStoreViewModel = dataStoreViewModel)
//                    }
//                }else{
//                    setContent{
//                        DataStoreHomeScreen( dataStoreViewModel =  dataStoreViewModel)
//                    }
//                }
//            }
//        }

//        setContent {
//            Parent()
//            AppNavigation()
//            FilesScreen()
//            val viewModel :  CounterViewModel = viewModel()
//            val count by viewModel.count.collectAsState()
//            CounterScreen(count = count, viewModel = viewModel, increment = {
//                viewModel.increment()
//            })
//            CameraScreen()

//            val youtubeVideos = getYoutubeItems()
//            customLog("${youtubeVideos.size}")
//            YoutubeHomeScreen(videos = youtubeVideos)

//            working with datastore
//            DataStoreNavigation(dataStoreViewModel = dataStoreViewModel)

//        }

//        setContent {
//            LongClickHomeScreen()
//        }

//        setContent {
//            NavDrawerHomeScreen()
//        }

//        setContent {
//            McqScreen(optionsList = getList())
//        }

        setContent {
            val likesViewModel by viewModels<LikesViewModel>()
            likesViewModel.getPosts()
            LikeBtnHomeScreen( modifier = Modifier.fillMaxSize(),likesViewModel)
        }
    }
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun getYoutubeItems() : List<Video> {
//        val list = mutableListOf<Video>()
//        for (i in 1..100){
//            val video = Video(
//                thumbnailId = R.drawable.thumbnail,
//                title = generateRandomYouTubeTitle(),
//                channelImageId = R.drawable.avatar,
//                channelName = generateRandomYouTubeChannelName(),
//                views = generateRandomChannelViews().toString(),
//                date = generateRandomDateString()
//            )
//            list.add(video)
//        }
//        return list
//    }
//    fun generateRandomYouTubeTitle(): String {
//        val topics = listOf("Tutorial", "Review", "Unboxing", "Vlog", "Challenge")
//        val adjectives = listOf("Awesome", "Exciting", "Incredible", "Amazing", "Fantastic")
//        val nouns = listOf("Adventure", "Journey", "Experience", "Discovery", "Moment")
//
//        val randomTopic = topics.random()
//        val randomAdjective = adjectives.random()
//        val randomNoun = nouns.random()
//
//        return "$randomTopic: $randomAdjective $randomNoun"
//    }
//    fun generateRandomYouTubeChannelName(): String {
//        val prefixes = listOf("Tech", "Gaming", "Travel", "Food", "Adventure")
//        val suffixes = listOf("Hub", "Zone", "Network", "World", "Studios")
//
//        val randomPrefix = prefixes.random()
//        val randomSuffix = suffixes.random()
//
//        return "$randomPrefix $randomSuffix"
//    }
//    fun generateRandomChannelViews(): Int {
//        val minViews = 100000  // Minimum number of views
//        val maxViews = 10000000  // Maximum number of views
//
//        return Random.nextInt(minViews, maxViews + 1)
//    }
//
//    @RequiresApi(Build.VERSION_CODES.O)
//    fun generateRandomDateString(): String {
//        val startDate = LocalDate.of(2000, 1, 1)
//        val endDate = LocalDate.of(2024, 12, 31)
//
//        val randomDays = Random.nextLong(startDate.toEpochDay(), endDate.toEpochDay())
//        val randomDate = LocalDate.ofEpochDay(randomDays)
//
//        return randomDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
//    }
}

