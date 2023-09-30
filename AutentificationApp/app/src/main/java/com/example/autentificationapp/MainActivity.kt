package com.example.autentificationapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.biometric.BiometricPrompt.PromptInfo
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.autentificationapp.ui.theme.AutentificationAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AutentificationAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Auth()
                }
            }
        }
        setupAut()
    }

    // Private methods
    private var canAuthenticate = false
    private lateinit var promptInfo: PromptInfo
    private fun setupAut() {
        if (BiometricManager.from(this).canAuthenticate(
                BiometricManager.Authenticators.BIOMETRIC_STRONG or
                        BiometricManager.Authenticators.DEVICE_CREDENTIAL
            ) == BiometricManager.BIOMETRIC_SUCCESS
        ) {
            canAuthenticate = true
            promptInfo = PromptInfo.Builder()
                .setTitle("Biometric Authentication")
                .setSubtitle("authenticate it by using biometric sensor or something else")
                .setAllowedAuthenticators(
                    BiometricManager.Authenticators.BIOMETRIC_STRONG or
                            BiometricManager.Authenticators.DEVICE_CREDENTIAL
                )
                .build()
        }
    }

    private fun authenticate(auth: (auth:Boolean) -> Unit){
        if (canAuthenticate){
            BiometricPrompt(this, ContextCompat.getMainExecutor(this),
            object: BiometricPrompt.AuthenticationCallback(){
                override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    auth(true)
                }
            }).authenticate(promptInfo)

        }else{
            auth(true)
        }
    }
    // Composable
    @Composable
    fun Auth() {
        var isAuth by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
//                    hsl(hue = 360f, saturation = 63f, lightness = 50f, alpha = 1f)
                .background(if (isAuth) Color.Blue else Color.LightGray)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (isAuth) "You are Authenticated" else "You need authentication",
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.Monospace
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = {
                if (isAuth){
                    isAuth = false
                }else{
                    authenticate {
                        isAuth = it
                    }
                }

            }) {
                Text(text = if (isAuth) "Close" else "Authenticate")
            }
        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun GreetingPreview() {
        AutentificationAppTheme {
            Auth()
        }
    }
}
