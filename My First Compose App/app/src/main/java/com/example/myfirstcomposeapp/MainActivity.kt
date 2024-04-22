package com.example.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myfirstcomposeapp.ui.theme.MyFirstComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface (color = MaterialTheme.colorScheme.primary) {
        Column (
            modifier = modifier.padding(12.dp)
        ){
            Text(
                text = "Hello $name!",
//                modifier = modifier.padding(24.dp)
            )
            Text(
                text = "Hello $name!",
//                modifier = modifier.padding(24.dp)
            )
        }

    }

}

@Composable
fun MyApp(modifier: Modifier =Modifier){
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        Greeting(name = "Android")

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyFirstComposeAppTheme {
        MyApp()
    }
}
