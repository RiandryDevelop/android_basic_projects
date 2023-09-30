package com.example.firebaseauthapp

import android.os.Bundle

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // Splash
        Thread.sleep(2000) // Hack:
        setTheme(R.style.Theme_FirebaseAuthAPP)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_layout)

        // Analytics Event
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("Message", "Firebase Integration Completed")
        analytics.logEvent("InitScreen", bundle)

    }
}


