package com.example.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapp.home.HomeScreen3
import com.example.composeapp.neco.ItemRow
import com.example.composeapp.neco.ListItems
import com.example.composeapp.neco.ListItemsPreview
import com.example.composeapp.neco.RcViewItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Gray)) {
                itemsIndexed(
                    listOf(
                        ItemRow(R.drawable.ic_launcher_background, "Kurbonov","  Row(\n" +
                                "        modifier = Modifier\n" +
                                "            .fillMaxWidth()\n" +
                                "            .padding(5.dp)\n" +
                                "            .background(color = Color.White)\n" +
                                "    ) {\n" +
                                "        Image(\n" +
                                "            painter = painterResource(id = itemRow.imageId),\n" +
                                "            contentDescription = \"image\",\n" +
                                "            contentScale = ContentScale.Crop,\n" +
                                "            modifier = Modifier\n" +
                                "                .size(64.dp)\n" +
                                "                .padding(5.dp)\n" +
                                "                .clip(CircleShape)\n" +
                                "        )\n" +
                                "        Column(modifier = Modifier.padding(top = 10.dp)) {\n" +
                                "            Text(text = itemRow.title)\n" +
                                "            Text(text = itemRow.content)\n" +
                                "\n" +
                                "        }\n" +
                                "    }"),
                        ItemRow(R.drawable.ic_launcher_background, "Kurbonov","Bilol"),
                        ItemRow(R.drawable.ic_launcher_background, "Kurbonov","Bilol"),
                        ItemRow(R.drawable.ic_launcher_background, "Kurbonov","Bilol"),
                        ItemRow(R.drawable.ic_launcher_background, "Kurbonov","Bilol"),
                        ItemRow(R.drawable.ic_launcher_background, "Kurbonov","Bilol"),
                        ItemRow(R.drawable.ic_launcher_background, "Kurbonov","Bilol"),

                    )
                ) { index, item ->
                    RcViewItem(item)
                }
            }
        }
    }
}

