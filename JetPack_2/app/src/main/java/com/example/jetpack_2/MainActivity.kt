package com.example.jetpack_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingPreview()
        }
    }
}

@Composable
fun GreetingUser(name: String, last_name:String) {
    Column(Modifier.padding(16.dp)) {
        Image(painter = painterResource(R.drawable.ic_launcher_background), contentDescription ="Launcher Image",)
        Text(
            text = "Hello $name $last_name!",

        )
        Text(text = "Welcome to PissyLand")
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
 GreetingUser(name = "Manuela", last_name = "Gutierrez")

}