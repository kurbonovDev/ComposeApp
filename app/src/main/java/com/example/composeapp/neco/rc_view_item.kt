package com.example.composeapp.neco

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun RcViewItem(itemRow: ItemRow) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = itemRow.imageId),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .padding(5.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(top = 10.dp)) {
            Text(text = itemRow.title)
            Text(text = itemRow.content, modifier = Modifier.clickable {
                isExpanded = !isExpanded
            }, maxLines = if (isExpanded) 10 else 1, overflow = TextOverflow.Ellipsis)

        }
    }
}