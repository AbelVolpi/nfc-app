package com.abelvolpi.nfc_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.abelvolpi.nfc_app.ui.screens.HomeScreen
import com.abelvolpi.nfc_app.ui.screens.ProvideScreen
import com.abelvolpi.nfc_app.ui.theme.NFC_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NFC_AppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("home") {
                        HomeScreen(
                            onNavigateToProvide = {
                                navController.navigate("provide")
                            }
                        )
                    }
                    composable("provide") {
                        ProvideScreen()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NFC_AppTheme {
//        HomeScreen()
    }
}