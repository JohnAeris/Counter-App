package com.example.counter_app

import android.os.Bundle
import android.provider.Settings.Global
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    var initialCount by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



        Text(
            text = initialCount.toString(),
            fontSize = 100.sp,
            fontWeight = FontWeight.SemiBold,
        )
        
        Spacer(modifier = Modifier.height(50.dp))

        Row() {
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {
                        initialCount--
                    },
                elevation = 8.dp,
                border = BorderStroke(5.dp, Color.Black)
            ) {
                Image(
                    painter = painterResource(R.drawable.minus_ic),
                    contentDescription = "Minus button",
                    Modifier.size(70.dp).background(Color.White)
                )
            }
            
            Spacer(modifier = Modifier.width(130.dp))

            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {
                        initialCount++
                    },
                elevation = 8.dp,
                border = BorderStroke(5.dp, Color.Black)
            ) {
                Image(
                    painter = painterResource(R.drawable.add_ic),
                    contentDescription = "Add button",
                    Modifier.size(70.dp).background(Color.White)
                )
            }
        }
    }
}

@Preview
@Composable
fun AddButton() {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .clickable {

            },
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