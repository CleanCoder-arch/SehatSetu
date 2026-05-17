package com.example.sehatsetu.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sehatsetu.components.BottomNavBar
import com.example.sehatsetu.models.Doctor
import com.example.sehatsetu.ui.theme.ThemeViewModel
import java.util.Calendar

@Composable
fun HomeScreen(

    onBookAppointment: (Doctor) -> Unit,

    onDoctorsClick: () -> Unit,

    onAppointmentsClick: () -> Unit,

    onProfileClick: () -> Unit,

    onAIClick: () -> Unit,

    onChatClick: () -> Unit,

    onPrescriptionClick: () -> Unit,

    onDoctorDetailsClick: (Doctor) -> Unit,

    onEmergencyClick: () -> Unit,

    themeViewModel: ThemeViewModel
) {

    var searchQuery by remember {

        mutableStateOf("")
    }

    var selectedCategory by remember {

        mutableStateOf("All")
    }

    val categories = listOf(

        "All",
        "Cardiology",
        "Dental",
        "Dermatology",
        "Pediatrics",
        "Orthopedic"
    )

    Scaffold(

        bottomBar = {

            BottomNavBar(

                onHomeClick = { },

                onDoctorsClick = {

                    onDoctorsClick()
                },

                onAppointmentsClick = onAppointmentsClick,

                onProfileClick = onProfileClick
            )
        }

    ) { paddingValues ->

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
                .padding(16.dp)
        ) {

            item {

                Box(

                    modifier = Modifier
                        .fillMaxWidth()
                        .background(

                            brush = Brush.horizontalGradient(

                                listOf(
                                    Color(0xFF4A90E2),
                                    Color(0xFF50C9C3)
                                )
                            ),

                            shape = RoundedCornerShape(24.dp)
                        )
                        .padding(24.dp)
                ) {

                    Column {

                        val hour =

                            Calendar.getInstance()
                                .get(Calendar.HOUR_OF_DAY)

                        val greeting = when {

                            hour < 12 -> "Good Morning ☀️"

                            hour < 17 -> "Good Afternoon 🌤️"

                            else -> "Good Evening 🌙"
                        }

                        Text(

                            text = greeting,

                            color = Color.White.copy(alpha = 0.9f),

                            style =
                                MaterialTheme.typography.titleMedium
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Text(

                            text = "Welcome to Sehat Setu",

                            color = Color.White,

                            style =
                                MaterialTheme.typography.headlineMedium
                        )

                        Spacer(
                            modifier = Modifier.height(10.dp)
                        )

                        Text(

                            text =
                                "Find top doctors and book appointments instantly",

                            color = Color.White.copy(alpha = 0.9f)
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Row(

                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement =
                        Arrangement.SpaceBetween,

                    verticalAlignment =
                        Alignment.CenterVertically
                ) {

                    Text(
                        text = "Dark Mode"
                    )

                    Switch(

                        checked =
                            themeViewModel.isDarkMode,

                        onCheckedChange = {

                            themeViewModel.isDarkMode = it
                        }
                    )
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )
            }

            item {

                LazyRow(

                    horizontalArrangement =
                        Arrangement.spacedBy(8.dp)
                ) {

                    items(categories) { category ->

                        FilterChip(

                            selected =
                                selectedCategory == category,

                            onClick = {

                                selectedCategory = category

                                onDoctorsClick()
                            },

                            label = {

                                Text(category)
                            }
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(16.dp)
                )

                OutlinedTextField(

                    value = searchQuery,

                    onValueChange = {

                        searchQuery = it

                        if (it.isNotEmpty()) {

                            onDoctorsClick()
                        }
                    },

                    modifier = Modifier.fillMaxWidth(),

                    shape = RoundedCornerShape(18.dp),

                    singleLine = true,

                    leadingIcon = {

                        Icon(

                            imageVector = Icons.Default.Search,

                            contentDescription = null,

                            tint = Color.Gray
                        )
                    },

                    placeholder = {

                        Text(
                            "Search doctors, specialists..."
                        )
                    }
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                Text(

                    text = "Quick Actions",

                    style =
                        MaterialTheme.typography.titleLarge,

                    fontWeight = FontWeight.Bold
                )

                Spacer(
                    modifier = Modifier.height(14.dp)
                )

                Row(

                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement =
                        Arrangement.spacedBy(12.dp)
                ) {

                    ActionCard(

                        title = "AI Check",

                        emoji = "🤖",

                        color1 = Color(0xFF4A90E2),

                        color2 = Color(0xFF50C9C3),

                        modifier = Modifier.weight(1f)
                    ) {

                        onAIClick()
                    }

                    ActionCard(

                        title = "Emergency",

                        emoji = "🚑",

                        color1 = Color(0xFFFF5252),

                        color2 = Color(0xFFFF8A80),

                        modifier = Modifier.weight(1f)
                    ) {

                        onEmergencyClick()
                    }
                }

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                Row(

                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement =
                        Arrangement.spacedBy(12.dp)
                ) {

                    ActionCard(

                        title = "Prescription",

                        emoji = "📄",

                        color1 = Color(0xFF7E57C2),

                        color2 = Color(0xFFB39DDB),

                        modifier = Modifier.weight(1f)
                    ) {

                        onPrescriptionClick()
                    }

                    ActionCard(

                        title = "Chat Doctor",

                        emoji = "💬",

                        color1 = Color(0xFF26A69A),

                        color2 = Color(0xFF80CBC4),

                        modifier = Modifier.weight(1f)
                    ) {

                        onChatClick()
                    }
                }

                Spacer(
                    modifier = Modifier.height(20.dp)
                )
            }
        }
    }
}

@Composable
fun ActionCard(

    title: String,

    emoji: String,

    color1: Color,

    color2: Color,

    modifier: Modifier = Modifier,

    onClick: () -> Unit
) {

    Card(

        onClick = onClick,

        modifier = modifier.height(120.dp),

        shape = RoundedCornerShape(24.dp)
    ) {

        Box(

            modifier = Modifier
                .fillMaxSize()
                .background(

                    Brush.linearGradient(

                        listOf(
                            color1,
                            color2
                        )
                    )
                )
                .padding(16.dp)
        ) {

            Column(

                verticalArrangement =
                    Arrangement.SpaceBetween
            ) {

                Text(

                    text = emoji,

                    style =
                        MaterialTheme.typography.headlineMedium
                )

                Text(

                    text = title,

                    color = Color.White,

                    style =
                        MaterialTheme.typography.titleMedium,

                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}