package com.example.sehatsetu.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.sehatsetu.firebase.AuthManager

@Composable
fun ProfileScreen(

    onLogout: () -> Unit
) {

    val user = AuthManager.auth.currentUser

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FA))
    ) {

        Box(

            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .background(

                    brush =
                        Brush.verticalGradient(

                            colors = listOf(
                                Color(0xFF4A90E2),
                                Color(0xFF50C9C3)
                            )
                        )
                ),

            contentAlignment =
                Alignment.Center
        ) {

            Column(

                horizontalAlignment =
                    Alignment.CenterHorizontally
            ) {

                Image(

                    painter =
                        rememberAsyncImagePainter(

                            "https://i.pravatar.cc/300"
                        ),

                    contentDescription = null,

                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape),

                    contentScale =
                        ContentScale.Crop
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Text(

                    text =
                        user?.displayName ?: "Sehat Setu User",

                    color = Color.White,

                    fontSize = 26.sp,

                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(

                    text =
                        user?.email ?: "",

                    color =
                        Color.White.copy(alpha = 0.9f)
                )
            }
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Column(

            modifier = Modifier.padding(20.dp)
        ) {

            Card(

                shape = RoundedCornerShape(20.dp)
            ) {

                Column(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {

                    Text(

                        text = "Account Information",

                        fontSize = 22.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(
                        text = "📧 Email: ${user?.email}"
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = "🩺 Healthcare Member"
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = "⭐ Premium Experience Enabled"
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            Button(

                onClick = {

                    onLogout()
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),

                colors = ButtonDefaults.buttonColors(

                    containerColor = Color.Red
                ),

                shape = RoundedCornerShape(18.dp)
            ) {

                Text(

                    text = "Logout",

                    color = Color.White,

                    fontSize = 18.sp
                )
            }
        }
    }
}