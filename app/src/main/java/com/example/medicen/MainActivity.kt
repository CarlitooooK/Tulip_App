package com.example.medicen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.medicen.presentation.navigation.AppNavigation
import com.example.medicen.presentation.screens.auth.login.LoginScreen
import com.example.medicen.presentation.screens.auth.register.RegisterScreen
import com.example.medicen.presentation.screens.dahsboard.DashboardScreen
import com.example.medicen.ui.theme.MedicenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MedicenTheme {
                AppNavigation()
            }
        }
    }
}

