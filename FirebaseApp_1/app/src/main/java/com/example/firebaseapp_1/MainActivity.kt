package com.example.firebaseapp_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.firebaseapp_1.ui.theme.FirebaseApp_1Theme
import com.google.firebase.analytics.FirebaseAnalytics

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
    ///Splash
        Thread.sleep(2000)
        setTheme(R.style.Theme_FirebaseApp_1)
        super.onCreate(savedInstanceState)
        setContent {
            FirebaseApp_1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(245, 130, 13)
                ) {

                }
            }
        }
        val analytics:FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message","Firebase Integration Completed")
        analytics.logEvent("InitScreen",bundle)
        }


    }
