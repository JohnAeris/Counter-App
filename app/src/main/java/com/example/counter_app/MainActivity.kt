package com.example.counter_app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
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

    var initialInterval by remember {
        mutableStateOf(1)
    }

    var interval by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Card(
            modifier = Modifier
                .align(Alignment.End)
                .clickable {
                    initialCount = 0
                    interval = ""
                    initialInterval = 1
                    Toast
                        .makeText(context, "Reset", Toast.LENGTH_SHORT)
                        .show()
                },
            elevation = 8.dp
        ) {
            Image(
                painter = painterResource(R.drawable.reset_ic),
                contentDescription = "Reset button",
                Modifier
                    .background(colorResource(R.color.beau_blue))
                    .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                    .size(50.dp)
                    .align(Alignment.CenterHorizontally)

            )
        }
        
        Spacer(modifier = Modifier.height(150.dp))

        Text(
            text = initialCount.toString(),
            fontSize = 70.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 5
        )
        
        Spacer(modifier = Modifier.height(50.dp))

        Row {
            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {
                        initialCount -= initialInterval
                    },
                elevation = 8.dp,
                border = BorderStroke(5.dp, Color.Black)
            ) {
                Image(
                    painter = painterResource(R.drawable.minus_ic),
                    contentDescription = "Minus button",
                    Modifier
                        .size(70.dp)
                        .background(Color.White)
                )
            }

            Spacer(modifier = Modifier.width(130.dp))

            Card(
                modifier = Modifier
                    .wrapContentSize()
                    .clickable {
                        initialCount += initialInterval
                    },
                elevation = 8.dp,
                border = BorderStroke(5.dp, Color.Black)
            ) {
                Image(
                    painter = painterResource(R.drawable.add_ic),
                    contentDescription = "Add button",
                    Modifier
                        .size(70.dp)
                        .background(Color.White)
                )
            }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Column {
            Text(
                text = "Enter the interval: $interval",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(5.dp)
            )

            OutlinedTextField(
                value = interval,
                onValueChange = { value ->
                    if (value.length <= 3) {
                        interval = value.filter { it.isDigit() }
                    } else {
                        Toast.makeText(context, "Reached the limit", Toast.LENGTH_SHORT).show()
                    }
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorResource(R.color.beau_blue),
                    unfocusedBorderColor = colorResource(R.color.black)
                )
            )

            try {
                if (interval.isNotEmpty()) {
                    initialInterval = interval.toInt()
                }
            } catch (e: Exception) {
                Toast.makeText(context, e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CounterAppTheme {
        App()
    }
}