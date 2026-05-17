package com.example.sehatsetu.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmergencyScreen() {

    val context = LocalContext.current

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFEBEE))
            .padding(24.dp),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Text(

            text = "🚑 Emergency Help",

            fontSize = 32.sp,

            fontWeight = FontWeight.Bold,

            color = Color.Red
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(

            text =
                "Call emergency medical services immediately.",

            fontSize = 18.sp
        )

        Spacer(
            modifier = Modifier.height(40.dp)
        )

        Button(

            onClick = {

                val intent = Intent(

                    Intent.ACTION_DIAL,

                    Uri.parse("tel:108")
                )

                context.startActivity(intent)
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp),

            colors = ButtonDefaults.buttonColors(

                containerColor = Color.Red
            ),

            shape = RoundedCornerShape(18.dp)
        ) {

            Text(

                text = "Call 108",

                color = Color.White,

                fontSize = 22.sp
            )
        }
    }
}