package com.abelvolpi.nfc_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.abelvolpi.nfc_app.ui.navigation.NavigationSchema
import com.abelvolpi.nfc_app.ui.theme.NFC_AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NFC_AppTheme {
                NavigationSchema()
            }
        }
    }
}
