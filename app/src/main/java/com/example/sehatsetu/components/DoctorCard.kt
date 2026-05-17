package com.example.sehatsetu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
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
fun DoctorCard(

    doctor: Doctor,

    onBookClick: () -> Unit
) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 18.dp),

        shape = RoundedCornerShape(26.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),

        colors = CardDefaults.cardColors(
            containerColor =
                MaterialTheme.colorScheme.surface
        )
    ) {

        Column(

            modifier = Modifier.padding(18.dp)
        ) {

            Row(

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Box {

                    Image(

                        painter = rememberAsyncImagePainter(

                            model = doctor.imageUrl
                        ),

                        contentDescription = null,

                        modifier = Modifier
                            .size(82.dp)
                            .clip(CircleShape),

                        contentScale =
                            ContentScale.Crop
                    )

                    Box(

                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(18.dp)
                            .clip(CircleShape)
                            .background(Color.Green)
                    )
                }

                Spacer(
                    modifier = Modifier.width(18.dp)
                )

                Column(

                    modifier = Modifier.weight(1f)
                ) {

                    Text(

                        text = doctor.name,

                        fontSize = 21.sp,

                        fontWeight = FontWeight.Bold,

                        color = Color(0xFF1E3A5F)
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Surface(

                        shape =
                            RoundedCornerShape(50.dp),

                        color =
                            Color(0xFFE8F1FF)
                    ) {

                        Text(

                            text =
                                doctor.specialization,

                            modifier = Modifier.padding(
                                horizontal = 14.dp,
                                vertical = 7.dp
                            ),

                            color = Color(0xFF4A90E2),

                            fontSize = 13.sp,

                            fontWeight = FontWeight.Medium
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Row(

                        verticalAlignment =
                            Alignment.CenterVertically
                    ) {

                        Icon(

                            imageVector =
                                Icons.Default.Star,

                            contentDescription = null,

                            tint = Color(0xFFFFC107),

                            modifier =
                                Modifier.size(18.dp)
                        )

                        Spacer(
                            modifier = Modifier.width(4.dp)
                        )

                        Text(

                            text = doctor.rating,

                            fontWeight = FontWeight.Bold
                        )

                        Spacer(
                            modifier = Modifier.width(8.dp)
                        )

                        Text(

                            text =
                                "(${doctor.reviews} reviews)",

                            color = Color.Gray,

                            fontSize = 13.sp
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Row {

                        InfoChip("10+ yrs")

                        Spacer(
                            modifier = Modifier.width(8.dp)
                        )

                        InfoChip("Available")
                    }
                }
            }

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            Button(

                onClick = onBookClick,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),

                shape = RoundedCornerShape(18.dp),

                colors = ButtonDefaults.buttonColors(
                    containerColor =
                        Color(0xFF4A90E2)
                )
            ) {

                Text(

                    text = "Book Appointment",

                    fontSize = 17.sp,

                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun InfoChip(

    text: String
) {

    Box(

        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(
                Brush.horizontalGradient(

                    listOf(
                        Color(0xFF4A90E2),
                        Color(0xFF50C9C3)
                    )
                )
            )
            .padding(
                horizontal = 12.dp,
                vertical = 6.dp
            )
    ) {

        Text(

            text = text,

            color = Color.White,

            fontSize = 12.sp
        )
    }
}