package com.example.counter_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.counter_app.ui.theme.CounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterAppTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    MainScreen()
}

@Composable
fun MainScreen() {
    Column(modifier = Modifier.fillMaxSize()) {

    }
}

@Preview
@Composable
fun AddButton() {
    Card(modifier = Modifier.background(colorResource(R.color.beau_blue))) {
        
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CounterAppTheme {
        App()
    }
}