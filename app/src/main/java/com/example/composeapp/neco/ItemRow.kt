package com.example.composeapp.neco

import androidx.annotation.DrawableRes

data class ItemRow(
    @DrawableRes
    val imageId: Int,
    val title: String,
    val content: String,
)
