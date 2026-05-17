package com.example.sehatsetu.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sehatsetu.components.DoctorCard
import com.example.sehatsetu.models.Doctor
import com.example.sehatsetu.repository.DoctorRepository

@Composable
fun DoctorsScreen(

    onDoctorDetailsClick: (Doctor) -> Unit
) {

    var doctors by remember {

        mutableStateOf<List<Doctor>>(emptyList())
    }

    var isLoading by remember {

        mutableStateOf(true)
    }

    LaunchedEffect(Unit) {

        DoctorRepository()
            .getDoctors {

                doctors = it

                isLoading = false
            }
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(

            text = "Top Doctors",

            style =
                MaterialTheme.typography.headlineMedium,

            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(18.dp)
        )

        if (isLoading) {

            CircularProgressIndicator()

        } else {

            LazyColumn {

                items(doctors) { doctor ->

                    DoctorCard(

                        doctor = doctor,

                        onBookClick = {

                            onDoctorDetailsClick(doctor)
                        }
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )
                }
            }
        }
    }
}