package com.example.sehatsetu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material.icons.filled.Videocam
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
import com.example.sehatsetu.models.Appointment

@Composable
fun AppointmentCard(

    appointment: Appointment
) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),

        shape = RoundedCornerShape(26.dp),

        elevation =
            CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(

            modifier = Modifier.padding(18.dp)
        ) {

            Row(

                verticalAlignment =
                    Alignment.CenterVertically
            ) {

                Image(

                    painter =
                        rememberAsyncImagePainter(
                            "https://i.pravatar.cc/300"
                        ),

                    contentDescription = null,

                    modifier = Modifier
                        .size(78.dp)
                        .clip(CircleShape),

                    contentScale =
                        ContentScale.Crop
                )

                Spacer(
                    modifier = Modifier.width(16.dp)
                )

                Column(

                    modifier = Modifier.weight(1f)
                ) {

                    Text(

                        text = appointment.doctorName,

                        fontSize = 22.sp,

                        fontWeight = FontWeight.Bold,

                        color = Color(0xFF1E3A5F)
                    )

                    Spacer(
                        modifier = Modifier.height(6.dp)
                    )

                    Text(

                        text =
                            appointment.specialization,

                        color = Color.Gray,

                        fontSize = 14.sp
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    StatusChip(appointment.status)
                }
            }

            Spacer(
                modifier = Modifier.height(18.dp)
            )

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement =
                    Arrangement.SpaceBetween
            ) {

                AppointmentInfoItem(

                    icon = Icons.Default.CalendarMonth,

                    label = appointment.date
                )

                AppointmentInfoItem(

                    icon = Icons.Default.Schedule,

                    label = appointment.time
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Button(

                onClick = { },

                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp),

                shape = RoundedCornerShape(18.dp),

                colors = ButtonDefaults.buttonColors(

                    containerColor =
                        Color(0xFF4A90E2)
                )
            ) {

                Icon(

                    imageVector =
                        Icons.Default.Videocam,

                    contentDescription = null
                )

                Spacer(
                    modifier = Modifier.width(8.dp)
                )

                Text(

                    text = "Join Consultation",

                    fontSize = 16.sp,

                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}


@Composable
fun StatusChip(

    text: String
) {

    val gradientColors = when (text) {

        "Completed" -> listOf(
            Color(0xFF42A5F5),
            Color(0xFF90CAF9)
        )

        "Cancelled" -> listOf(
            Color(0xFFEF5350),
            Color(0xFFEF9A9A)
        )

        else -> listOf(
            Color(0xFF4CAF50),
            Color(0xFF81C784)
        )
    }

    Box(

        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .background(

                Brush.horizontalGradient(
                    gradientColors
                )
            )
            .padding(
                horizontal = 14.dp,
                vertical = 7.dp
            )
    ) {

        Text(

            text = text,

            color = Color.White,

            fontSize = 12.sp,

            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun AppointmentInfoItem(

    icon: androidx.compose.ui.graphics.vector.ImageVector,

    label: String
) {

    Row(

        verticalAlignment =
            Alignment.CenterVertically
    ) {

        Icon(

            imageVector = icon,

            contentDescription = null,

            tint = Color(0xFF4A90E2)
        )

        Spacer(
            modifier = Modifier.width(6.dp)
        )

        Text(

            text = label,

            fontWeight = FontWeight.Medium
        )
    }
}