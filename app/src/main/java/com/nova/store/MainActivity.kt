package com.nova.store

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.*
import com.nova.store.ui.NovaMainScreen
import com.nova.store.ui.SplashScreen
import com.nova.store.ui.theme.NovaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NovaTheme {
                var showSplash by remember { mutableStateOf(true) }
                if (showSplash) {
                    SplashScreen { showSplash = false }
                } else {
                    NovaMainScreen()
                }
            }
        }
    }
}