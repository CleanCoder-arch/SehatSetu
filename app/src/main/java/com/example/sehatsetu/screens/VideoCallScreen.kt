package com.example.sehatsetu.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun VideoCallScreen() {

    val context = LocalContext.current

    LaunchedEffect(Unit) {

        val intent = Intent(

            Intent.ACTION_VIEW,

            Uri.parse(
                "https://meet.jit.si/SehatSetuRoom"
            )
        )

        context.startActivity(intent)
    }

    Box(
        modifier = Modifier.fillMaxSize(),

        contentAlignment = Alignment.Center
    ) {

        CircularProgressIndicator()
    }
}