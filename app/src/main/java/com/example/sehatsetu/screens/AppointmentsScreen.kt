package com.example.sehatsetu.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sehatsetu.firebase.AuthManager
import com.example.sehatsetu.firebase.FirestoreManager
import com.example.sehatsetu.models.Appointment

@Composable
fun AppointmentsScreen(

    onJoinCall: () -> Unit
) {

    var appointments by remember {

        mutableStateOf<List<Appointment>>(
            emptyList()
        )
    }

    var isLoading by remember {

        mutableStateOf(true)
    }

    LaunchedEffect(Unit) {

        val patientId =

            AuthManager.auth
                .currentUser?.uid ?: ""

        FirestoreManager.db
            .collection("appointments")
            .whereEqualTo(
                "patientId",
                patientId
            )
            .get()

            .addOnSuccessListener { result ->

                appointments =

                    result.documents.mapNotNull {

                        it.toObject(
                            Appointment::class.java
                        )
                    }

                isLoading = false
            }
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(
                MaterialTheme.colorScheme.background
            )
            .padding(16.dp)
    ) {

        Text(

            text = "My Appointments",

            style =
                MaterialTheme.typography.headlineMedium,

            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        if (isLoading) {

            Box(

                modifier = Modifier.fillMaxSize(),

                contentAlignment =
                    Alignment.Center
            ) {

                CircularProgressIndicator()
            }
        }

        else if (appointments.isEmpty()) {

            Box(

                modifier = Modifier.fillMaxSize(),

                contentAlignment =
                    Alignment.Center
            ) {

                Column(

                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {

                    Text(

                        text = "📅",

                        fontSize = 60.sp
                    )

                    Spacer(
                        modifier =
                            Modifier.height(12.dp)
                    )

                    Text(

                        text =
                            "No appointments booked yet",

                        style =
                            MaterialTheme.typography.titleMedium
                    )

                    Spacer(
                        modifier =
                            Modifier.height(6.dp)
                    )

                    Text(

                        text =
                            "Book your first consultation",

                        color =
                            MaterialTheme.colorScheme
                                .onSurfaceVariant
                    )
                }
            }
        }

        else {

            LazyColumn(

                verticalArrangement =
                    Arrangement.spacedBy(18.dp)
            ) {

                items(appointments) { appointment ->

                    Card(

                        modifier = Modifier
                            .fillMaxWidth(),

                        shape =
                            RoundedCornerShape(24.dp),

                        elevation =
                            CardDefaults.cardElevation(
                                defaultElevation = 8.dp
                            ),

                        colors =
                            CardDefaults.cardColors(

                                containerColor =
                                    MaterialTheme.colorScheme.surface
                            )
                    ) {

                        Column(

                            modifier =
                                Modifier.padding(18.dp)
                        ) {

                            Row(

                                verticalAlignment =
                                    Alignment.CenterVertically
                            ) {

                                Box(

                                    modifier = Modifier
                                        .size(72.dp)
                                        .clip(CircleShape)
                                        .background(
                                            Color(0xFFE3F2FD)
                                        ),

                                    contentAlignment =
                                        Alignment.Center
                                ) {

                                    Text(

                                        text =
                                            appointment
                                                .doctorName
                                                .first()
                                                .toString(),

                                        fontSize = 30.sp,

                                        fontWeight =
                                            FontWeight.Bold,

                                        color =
                                            Color(0xFF4A90E2)
                                    )
                                }

                                Spacer(
                                    modifier =
                                        Modifier.width(16.dp)
                                )

                                Column(

                                    modifier =
                                        Modifier.weight(1f)
                                ) {

                                    Text(

                                        text =
                                            appointment.doctorName,

                                        style =
                                            MaterialTheme
                                                .typography
                                                .titleLarge,

                                        fontWeight =
                                            FontWeight.Bold
                                    )

                                    Spacer(
                                        modifier =
                                            Modifier.height(4.dp)
                                    )

                                    Text(

                                        text =
                                            appointment.specialization,

                                        color =
                                            MaterialTheme
                                                .colorScheme
                                                .onSurfaceVariant
                                    )

                                    Spacer(
                                        modifier =
                                            Modifier.height(8.dp)
                                    )

                                    Surface(

                                        color =
                                            Color(0xFFE8F5E9),

                                        shape =
                                            RoundedCornerShape(50.dp)
                                    ) {

                                        Text(

                                            text =
                                                "Upcoming",

                                            modifier =
                                                Modifier.padding(
                                                    horizontal = 12.dp,
                                                    vertical = 6.dp
                                                ),

                                            color =
                                                Color(0xFF2E7D32)
                                        )
                                    }
                                }
                            }

                            Spacer(
                                modifier =
                                    Modifier.height(20.dp)
                            )

                            Row(

                                horizontalArrangement =
                                    Arrangement.spacedBy(20.dp)
                            ) {

                                Text(
                                    text =
                                        "📅 ${appointment.date}"
                                )

                                Text(
                                    text =
                                        "⏰ ${appointment.time}"
                                )
                            }

                            Spacer(
                                modifier =
                                    Modifier.height(20.dp)
                            )

                            Button(

                                onClick = {

                                    onJoinCall()
                                },

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(52.dp),

                                shape =
                                    RoundedCornerShape(16.dp)
                            ) {

                                Text(

                                    text =
                                        "Join Video Consultation"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}