package com.hellofresh.androidkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hellofresh.androidkmm.Greeting
import com.hellofresh.androidkmm.model.DataEntity
import com.hellofresh.androidkmm.model.Entries
import com.hellofresh.androidkmm.model.PhoneBrands
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val uiState: MutableStateFlow<List<Entries>> = MutableStateFlow(emptyList())

                    LaunchedEffect("phones") {
                        val phones = DataEntity.data()
                        uiState.value = phones
                    }

                    PhoneBrandScreen(phonesState = uiState)

                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Composable
fun PhoneBrandScreen(phonesState: StateFlow<List<Entries>>) {
    val state = phonesState.collectAsState()

    LazyColumn(content = {
        items(state.value) {

            Card(modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()) {
                Text(modifier = Modifier.padding(8.dp), text = "${it.api}\n${it.desc}\n${it.category}")
            }
        }
    })
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
