package com.example.vpn

//import com.example.vpn.Screens.SplashScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.vpn.Screens.navigation.Navigation
import com.example.vpn.ui.theme.VpnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VpnTheme {
                Navigation()
            }
        }
    }
}

