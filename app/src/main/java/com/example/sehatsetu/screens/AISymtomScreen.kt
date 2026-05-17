package com.example.sehatsetu.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll


@Composable
fun AISymptomScreen() {

    var symptoms by remember {

        mutableStateOf("")
    }

    var response by remember {

        mutableStateOf("")
    }

    var userMessage by remember {

        mutableStateOf("")
    }

    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(

                brush = Brush.verticalGradient(

                    colors = listOf(
                        Color(0xFF4A90E2),
                        Color(0xFF50C9C3)
                    )
                )
            )
            .padding(20.dp)
    ) {

        Column(

            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(
                    rememberScrollState()
                ),

            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            Text(

                text = "AI Symptom Checker",

                fontSize = 30.sp,

                fontWeight = FontWeight.Bold,

                color = Color.White
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(

                text =
                    "Describe your symptoms below",

                color = Color.White.copy(alpha = 0.9f)
            )

            Spacer(
                modifier = Modifier.height(30.dp)
            )

            Card(

                shape = RoundedCornerShape(24.dp),

                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {

                Column(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {

                    OutlinedTextField(

                        value = symptoms,

                        onValueChange = {

                            symptoms = it
                        },

                        modifier =
                            Modifier.fillMaxWidth(),

                        label = {

                            Text("Enter symptoms")
                        },

                        shape =
                            RoundedCornerShape(16.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    Button(

                        onClick = {

                            userMessage = symptoms

                            response = when {

                                symptoms.contains("fever", true)
                                        && symptoms.contains("cough", true) -> {

                                    "Possible flu or viral infection.\n\nAdvice:\n• Stay hydrated\n• Take proper rest\n• Monitor temperature\n• Consult doctor if symptoms worsen."
                                }

                                symptoms.contains("chest pain", true) -> {

                                    "⚠ Emergency Warning\n\nChest pain can be serious. Please seek immediate medical attention."
                                }

                                symptoms.contains("headache", true)
                                        && symptoms.contains("vomiting", true) -> {

                                    "Possible migraine or dehydration.\n\nAdvice:\n• Drink water\n• Avoid bright screens\n• Rest in a quiet environment."
                                }

                                symptoms.contains("stomach pain", true) -> {

                                    "Possible indigestion or gastric issue.\n\nAdvice:\n• Avoid oily food\n• Drink warm water\n• Consult doctor if pain persists."
                                }

                                symptoms.contains("cold", true)
                                        || symptoms.contains("cough", true) -> {

                                    "Common cold symptoms detected.\n\nAdvice:\n• Drink warm fluids\n• Rest properly\n• Use steam inhalation."
                                }

                                symptoms.contains("fever", true) -> {

                                    "You may have viral fever.\n\nAdvice:\n• Stay hydrated\n• Take rest\n• Monitor temperature regularly."
                                }

                                else -> {

                                    "Unable to determine condition.\n\nPlease consult a healthcare professional for accurate medical advice."
                                }
                            }
                        },

                        modifier =
                            Modifier.fillMaxWidth(),

                        shape =
                            RoundedCornerShape(16.dp),

                        colors =
                            ButtonDefaults.buttonColors(

                                containerColor =
                                    Color(0xFF4A90E2)
                            )
                    ) {

                        Text("Analyze Symptoms")
                    }

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    if (userMessage.isNotEmpty()) {

                        Spacer(
                            modifier = Modifier.height(24.dp)
                        )

                        Column(

                            modifier = Modifier.fillMaxWidth()
                        ) {

                            Row(

                                modifier = Modifier.fillMaxWidth(),

                                horizontalArrangement =
                                    Arrangement.End
                            ) {

                                Surface(

                                    shape = RoundedCornerShape(
                                        topStart = 20.dp,
                                        topEnd = 20.dp,
                                        bottomStart = 20.dp,
                                        bottomEnd = 4.dp
                                    ),

                                    color = Color(0xFF4A90E2)
                                ) {

                                    Text(

                                        text = userMessage,

                                        modifier = Modifier.padding(14.dp),

                                        color = Color.White
                                    )
                                }
                            }

                            Spacer(
                                modifier = Modifier.height(16.dp)
                            )

                            Row(

                                modifier = Modifier.fillMaxWidth(),

                                horizontalArrangement =
                                    Arrangement.Start
                            ) {

                                Surface(

                                    shape = RoundedCornerShape(
                                        topStart = 20.dp,
                                        topEnd = 20.dp,
                                        bottomStart = 4.dp,
                                        bottomEnd = 20.dp
                                    ),

                                    color = Color.White
                                ) {

                                    Column(

                                        modifier = Modifier.padding(16.dp)
                                    ) {

                                        Text(

                                            text = "🤖 AI Doctor",

                                            fontWeight = FontWeight.Bold,

                                            color = Color(0xFF1E3A5F)
                                        )

                                        Spacer(
                                            modifier = Modifier.height(10.dp)
                                        )

                                        Text(

                                            text = response,

                                            color = Color.DarkGray,

                                            lineHeight = 24.sp
                                        )
                                    }
                                }
                            }

                            Spacer(
                                modifier = Modifier.height(18.dp)
                            )

                            Surface(

                                color = Color(0xFFE8F5E9),

                                shape = RoundedCornerShape(14.dp)
                            ) {

                                Text(

                                    text =
                                        "⚠ This is AI-generated advice. Consult a doctor for professional diagnosis.",

                                    modifier = Modifier.padding(14.dp),

                                    color = Color(0xFF2E7D32)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}