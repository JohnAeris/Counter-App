package com.example.counter_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counter_app.ui.theme.CounterAppTheme
import kotlin.math.round

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

    var initial_number = 0

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = initial_number.toString(),
            fontSize = 150.sp,
            fontWeight = FontWeight.Bold,
        )
        
        Spacer(modifier = Modifier.height(100.dp))

        Row() {
            MinusButton()
            
            Spacer(modifier = Modifier.width(130.dp))
            
            AddButton()
        }
    }
}

@Preview
@Composable
fun AddButton() {
    Card(
        modifier = Modifier.wrapContentSize(),
        elevation = 8.dp,
        border = BorderStroke(5.dp, Color.Black)
    ) {
        Image(
            painter = painterResource(R.drawable.add_ic),
            contentDescription = "Add button",
            Modifier.size(70.dp)
        )
    }
}

@Preview
@Composable
fun MinusButton() {
    Card(
        modifier = Modifier.wrapContentSize(),
        elevation = 8.dp,
        border = BorderStroke(5.dp, Color.Black)
    ) {
        Image(
            painter = painterResource(R.drawable.minus_ic),
            contentDescription = "Minus button",
            Modifier.size(70.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CounterAppTheme {
        App()
    }
}