package com.example.sehatsetu.screens

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.shape.RoundedCornerShape
import com.airbnb.lottie.compose.*
import com.example.sehatsetu.firebase.AuthManager
import com.example.sehatsetu.firebase.FirestoreManager
import com.example.sehatsetu.models.Appointment
import java.util.Calendar

@Composable
fun AppointmentScreen(

    doctorName: String,

    specialization: String,

) {

    var date by remember {

        mutableStateOf("")
    }

    var time by remember {

        mutableStateOf("")
    }

    val calendar = Calendar.getInstance()

    val context = LocalContext.current

    var showSuccess by remember {

        mutableStateOf(false)
    }

    val snackbarHostState = remember {

        SnackbarHostState()
    }

    LaunchedEffect(showSuccess) {

        if (showSuccess) {

            snackbarHostState.showSnackbar(

                "Appointment booked successfully ✅"
            )
        }
    }

    val composition by rememberLottieComposition(

        LottieCompositionSpec.Asset(
            "success_animation.json"
        )
    )

    Scaffold(

        snackbarHost = {

            SnackbarHost(snackbarHostState)
        }

    ) { paddingValues ->

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(24.dp),

            verticalArrangement =
                Arrangement.Center,

            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Text(

                text = doctorName,

                style =
                    MaterialTheme.typography.headlineSmall
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = specialization
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Button(

                onClick = {

                    DatePickerDialog(

                        context,

                        { _, year, month, dayOfMonth ->

                            date =
                                "$dayOfMonth/${month + 1}/$year"
                        },

                        calendar.get(Calendar.YEAR),

                        calendar.get(Calendar.MONTH),

                        calendar.get(Calendar.DAY_OF_MONTH)

                    ).show()
                },

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(16.dp)
            ) {

                Text(

                    text =

                        if (date.isEmpty())
                            "Select Appointment Date"
                        else
                            "Date: $date"
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            Button(

                onClick = {

                    TimePickerDialog(

                        context,

                        { _, hour, minute ->

                            time =
                                "$hour:$minute"
                        },

                        calendar.get(Calendar.HOUR_OF_DAY),

                        calendar.get(Calendar.MINUTE),

                        false

                    ).show()
                },

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(16.dp)
            ) {

                Text(

                    text =

                        if (time.isEmpty())
                            "Select Appointment Time"
                        else
                            "Time: $time"
                )
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Button(

                onClick = {

                    val patientId =

                        AuthManager.auth
                            .currentUser?.uid ?: ""

                    val appointment = Appointment(

                        patientId = patientId,

                        doctorName = doctorName,

                        specialization = specialization,

                        date = date,

                        time = time
                    )

                    FirestoreManager.db
                        .collection("appointments")
                        .add(appointment)

                        .addOnSuccessListener {

                            showSuccess = true
                        }
                },

                modifier = Modifier.fillMaxWidth(),

                shape = RoundedCornerShape(16.dp)
            ) {

                Text("Confirm Appointment")
            }

            if (showSuccess) {

                AlertDialog(

                    onDismissRequest = {

                        showSuccess = false
                    },

                    confirmButton = {

                        Button(

                            onClick = {

                                showSuccess = false
                            }
                        ) {

                            Text("OK")
                        }
                    },

                    title = {

                        Text("Appointment Booked")
                    },

                    text = {

                        Column(

                            horizontalAlignment =
                                Alignment.CenterHorizontally
                        ) {

                            LottieAnimation(

                                composition = composition,

                                iterations = 1,

                                modifier =
                                    Modifier.size(180.dp)
                            )

                            Spacer(
                                modifier =
                                    Modifier.height(12.dp)
                            )

                            Text(

                                text =
                                    "Your appointment has been booked successfully!"
                            )
                        }
                    }
                )
            }
        }
    }
}