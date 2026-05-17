package com.example.sehatsetu.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.example.sehatsetu.models.Doctor

@Composable
fun DoctorDetailsScreen(

    doctor: Doctor,

    onBookAppointment: () -> Unit
) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
            .verticalScroll(
                rememberScrollState()
            )
    ) {

        Box(

            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .background(

                    brush =
                        Brush.verticalGradient(

                            listOf(
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
                        .size(140.dp)
                        .clip(CircleShape),

                    contentScale =
                        ContentScale.Crop
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                Text(

                    text = doctor.name,

                    color = Color.White,

                    fontSize = 28.sp,

                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(

                    text =
                        doctor.specialization,

                    color =
                        Color.White.copy(alpha = 0.9f),

                    fontSize = 18.sp
                )
            }
        }

        Column(

            modifier =
                Modifier.padding(20.dp)
        ) {

            Row(

                horizontalArrangement =
                    Arrangement.SpaceEvenly,

                modifier = Modifier.fillMaxWidth()
            ) {

                StatCard(
                    title = "Rating",
                    value = "⭐ ${doctor.rating}"
                )

                StatCard(
                    title = "Patients",
                    value = "1.2k+"
                )

                StatCard(
                    title = "Experience",
                    value = "10+ yrs"
                )
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Text(

                text = "About Doctor",

                style =
                    MaterialTheme.typography.titleLarge,

                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Text(

                text =
                    "Experienced specialist dedicated to providing the best healthcare consultation and treatment with modern medical practices.",

                color =
                    MaterialTheme.colorScheme.onSurfaceVariant,

                lineHeight = 24.sp
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Card(

                shape =
                    RoundedCornerShape(20.dp),

                colors =
                    CardDefaults.cardColors(

                        containerColor =
                            MaterialTheme.colorScheme.surface
                    )
            ) {

                Column(

                    modifier =
                        Modifier.padding(20.dp)
                ) {

                    Text(
                        text = "Consultation Fee: ₹500"
                    )

                    Spacer(
                        modifier =
                            Modifier.height(10.dp)
                    )

                    Text(
                        text = "Availability: Mon - Sat"
                    )

                    Spacer(
                        modifier =
                            Modifier.height(10.dp)
                    )

                    Text(
                        text = "Timing: 9 AM - 6 PM"
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            Button(

                onClick = {

                    onBookAppointment()
                },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp),

                shape =
                    RoundedCornerShape(18.dp)
            ) {

                Text(

                    text = "Book Appointment",

                    fontSize = 18.sp
                )
            }

            Spacer(
                modifier = Modifier.height(30.dp)
            )
        }
    }
}

@Composable
fun StatCard(

    title: String,

    value: String
) {

    Card(

        shape =
            RoundedCornerShape(18.dp)
    ) {

        Column(

            modifier = Modifier
                .padding(16.dp),

            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Text(

                text = value,

                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = title
            )
        }
    }
}