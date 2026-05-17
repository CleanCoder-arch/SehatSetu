package com.example.sehatsetu.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sehatsetu.firebase.AuthManager

@Composable
fun SignupScreen(

    onSignupSuccess: () -> Unit,

    onLoginClick: () -> Unit
) {

    var email by remember {

        mutableStateOf("")
    }

    var password by remember {

        mutableStateOf("")
    }

    var errorMessage by remember {

        mutableStateOf("")
    }

    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(

                brush = Brush.verticalGradient(

                    colors = listOf(
                        Color(0xFF50C9C3),
                        Color(0xFF4A90E2)
                    )
                )
            ),

        contentAlignment = Alignment.Center
    ) {

        Card(

            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(24.dp)
                ),

            shape = RoundedCornerShape(24.dp),

            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),

                horizontalAlignment =
                    Alignment.CenterHorizontally
            ) {

                Text(

                    text = "Create Account",

                    fontSize = 30.sp,

                    fontWeight = FontWeight.Bold,

                    color = Color(0xFF1E3A5F)
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(

                    text =
                        "Join Sehat Setu today",

                    color = Color.Gray
                )

                Spacer(
                    modifier = Modifier.height(30.dp)
                )

                OutlinedTextField(

                    value = email,

                    onValueChange = {

                        email = it
                    },

                    label = {

                        Text("Email")
                    },

                    modifier =
                        Modifier.fillMaxWidth(),

                    shape =
                        RoundedCornerShape(14.dp)
                )

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                OutlinedTextField(

                    value = password,

                    onValueChange = {

                        password = it
                    },

                    label = {

                        Text("Password")
                    },

                    visualTransformation =
                        PasswordVisualTransformation(),

                    modifier =
                        Modifier.fillMaxWidth(),

                    shape =
                        RoundedCornerShape(14.dp)
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                Button(

                    onClick = {

                        AuthManager.signupUser(

                            email = email,

                            password = password,

                            onSuccess = {

                                onSignupSuccess()
                            },

                            onError = {

                                errorMessage = it
                            }
                        )
                    },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(55.dp),

                    shape =
                        RoundedCornerShape(16.dp),

                    colors = ButtonDefaults.buttonColors(
                        containerColor =
                            Color(0xFF50C9C3)
                    )
                ) {

                    Text(

                        text = "Sign Up",

                        fontSize = 18.sp
                    )
                }

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                TextButton(

                    onClick = onLoginClick
                ) {

                    Text(

                        text =
                            "Already have an account? Login"
                    )
                }

                if (errorMessage.isNotEmpty()) {

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    Text(

                        text = errorMessage,

                        color = Color.Red
                    )
                }
            }
        }
    }
}