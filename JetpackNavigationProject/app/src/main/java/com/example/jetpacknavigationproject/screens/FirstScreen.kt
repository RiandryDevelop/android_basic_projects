package com.example.jetpacknavigationproject.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.jetpacknavigationproject.navigation.AppScreens


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FirstScreen(navController: NavController){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Go to Second Screen") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate( route = AppScreens.SecondScreen.route) }) {
                        Icon(Icons.Default.ArrowForward, contentDescription = "Go Forward")
                    }
                }
            )
        }
    )
    {
    FirstBodyContent(navController)
    }
}

@Composable
fun FirstBodyContent(navController: NavController){
    Column(modifier = Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(text = "Home Screen, 1st Screen")
        Button(onClick  = {
                navController.navigate(route = AppScreens.SecondScreen.route)
            }
        ) {
            Text(text = "Go to the Second Screen")
        }
    }
}
