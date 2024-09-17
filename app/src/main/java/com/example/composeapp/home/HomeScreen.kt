package com.example.composeapp.home

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun HomeScreen() {
    Row(verticalAlignment = CenterVertically, modifier = Modifier.background(color = Color.Red)) {
        Box(modifier = Modifier.background(Color.Yellow)) {
            Text("N", fontSize = 48.sp)
            Text("ame", modifier = Modifier.align(BottomCenter))
        }
        Spacer(
            modifier = Modifier
                .width(8.dp)
                .background(Color.White)
        )
        Column(modifier = Modifier.background(Color.Green)) {
            Text("Title")
            Text("Description")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    // HomeScreen()
    // HomeScreen1(listOf("abc","abc","abc","abc",))
    //HomeScreen2()
    //HomeScreen4()
}


@Composable
fun HomeScreen1(list: List<String>) {
    if (list.isEmpty()) {
        Box(contentAlignment = Center, modifier = Modifier.fillMaxSize()) {
            Text(text = "Empty screen")
        }
    } else {
        Column(modifier = Modifier.fillMaxSize()) {
            for (s in list) {
                Text(text = s)
            }
        }
    }
}

@Composable
fun HomeScreen2() {
    Box(contentAlignment = Center, modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = "https://developer.android.com/images/android-go/next-billion-users_856.png",
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}


@Composable
fun HomeScreen4(
    checked: State<Boolean>,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked.value,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.background(color = Color.Red)
        )
        Text(text = "Some checkbox text", fontSize = 18.sp, modifier = Modifier.clickable {
            onCheckedChange(!checked.value)
        })
    }
}


@Composable
fun HomeScreen5(
    text: State<String>,
    onTextChange: (String) -> Unit
) {
    OutlinedTextField(value = text.value, onValueChange = onTextChange)
}

@Composable
fun InfoText(text: String) {
    Log.d(TAG, "InfoText $text")
    Text(text = text, fontSize = 24.sp)
}


@Composable
fun HomeScreen3(
    counter: State<Int>,
    uppercase: State<Boolean>,
    onCounterClick: () -> Unit,
    onCheckedChange: (Boolean) -> Unit
) {
    Log.d(TAG, "HomeScreen")
    Column {
        ClickCounter(
            counterValue = counter.value,
            uppercase = uppercase.value,
            onCounterClick = onCounterClick
        )
        CheckView(uppercase = uppercase,
            onCheckedChange = onCheckedChange)
    }
}

@Composable
fun ClickCounter(
    uppercase: Boolean,
    counterValue: Int,
    onCounterClick: () -> Unit
) {
    val evenOdd = remember(uppercase) { EvenOdd(uppercase) }
    Text(
        text = "Clicks: $counterValue ${evenOdd.check(counterValue)}",
        modifier = Modifier.clickable(onClick = onCounterClick)
    )
    Log.d(TAG, "ClickCounter(counter = $counterValue, uppercase = $uppercase), $evenOdd")
}

class EvenOdd(private val uppercase: Boolean) {
    fun check(value: Int): String {
        var result = if (value % 2 == 0) "even" else "odd"
        if (uppercase) result = result.uppercase()
        return result
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun toString(): String {
        return "EvenOdd(uppercase = $uppercase, hashcode = ${hashCode().toHexString()})"
    }
}

@Composable
fun CheckView(
    uppercase: State<Boolean>,
    onCheckedChange: (Boolean) -> Unit
) {
    Checkbox(checked = uppercase.value, onCheckedChange = onCheckedChange)
}
