package com.example.myfirstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
fun MyApp(modifier: Modifier =Modifier, ){
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
    Surface(modifier) {
        if (shouldShowOnboarding){
            OnboardingScreen(onContinueClicked = {shouldShowOnboarding = false})
        }else{
            Greetings()
        }
    }
}

@Composable
fun Greetings(
    modifier: Modifier =Modifier,
    names: List<String> = List(1000) {"$it"}
){
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items (items = names){ name ->
            Greeting(name = name)
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) } // both remember and rememeberSaveable work
    val extraPadding = if(expanded) 48.dp else 0.dp
    Surface (
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column (modifier = modifier
                .weight(1f)
                .padding(bottom = extraPadding)
            ){
                Text(text = "Hello")
                Text(text = name)
            }
            ElevatedButton(onClick = { expanded =!expanded}) {
                Text(if(expanded) "Show Less" else "Show More")
                
            }
        }


    }

}

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    onContinueClicked: () -> Unit
){
    Column (
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "Welcome to the Basics Codelab!")
        Button(
            onClick = onContinueClicked,
            modifier = Modifier.padding(vertical = 24.dp)
        ) {
            Text(text = "Continue")
        }
    }
}

@Preview
@Composable
fun MyAppPreview(){
    MyFirstComposeAppTheme {
        MyApp(Modifier.fillMaxSize())
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun GreetingsPreview() {
    MyFirstComposeAppTheme {
        Greetings()
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview(){
    MyFirstComposeAppTheme {
        OnboardingScreen(onContinueClicked = {}) // Do Nothing | Perfect for Preview
    }
}
