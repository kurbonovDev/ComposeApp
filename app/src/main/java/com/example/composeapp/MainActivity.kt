package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import com.example.composeapp.home.HomeScreen3
import com.example.composeapp.neco.ListItemsPreview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val counter = mutableIntStateOf(0)
        val checked = mutableStateOf(true)
        val text = mutableStateOf("Some text")
        setContent {
            ListItemsPreview()
        }
    }
}

