package com.example.sehatsetu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sehatsetu.navigation.AppNavigation
import com.example.sehatsetu.ui.theme.SehatSetuTheme
import com.example.sehatsetu.ui.theme.ThemeViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val themeViewModel = ThemeViewModel()

        setContent {

            SehatSetuTheme(

                darkTheme =
                    themeViewModel.isDarkMode
            ) {

                AppNavigation(
                    themeViewModel
                )
            }
        }
    }
}