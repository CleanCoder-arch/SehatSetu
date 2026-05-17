package com.example.sehatsetu.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import kotlinx.coroutines.delay
import com.example.sehatsetu.R
import com.airbnb.lottie.compose.*

@Composable
fun SplashScreen(

    onNavigate: () -> Unit
) {

    LaunchedEffect(Unit) {

        delay(2500)

        onNavigate()
    }

    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(

                brush = Brush.verticalGradient(

                    listOf(
                        Color(0xFF4A90E2),
                        Color(0xFF50C9C3)
                    )
                )
            ),

        contentAlignment = Alignment.Center
    ) {

        Column(

            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            val composition = rememberLottieComposition(
                LottieCompositionSpec.Asset("doctor_animation.json")
            )

            val progress = animateLottieCompositionAsState(
                composition = composition.value,
                iterations = LottieConstants.IterateForever
            )

            LottieAnimation(
                composition = composition.value,
                progress = { progress.value },
                modifier = Modifier.size(280.dp)
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(

                text = "Sehat Setu",

                color = Color.White,

                fontSize = 40.sp,

                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(

                text =
                    "Healthcare at your fingertips",

                color =
                    Color.White.copy(alpha = 0.9f),

                fontSize = 20.sp
            )

            Spacer(
                modifier = Modifier.height(50.dp)
            )

            CircularProgressIndicator(

                color = Color.White
            )
        }
    }
}