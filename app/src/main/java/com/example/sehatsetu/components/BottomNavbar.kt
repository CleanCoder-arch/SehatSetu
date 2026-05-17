package com.example.sehatsetu.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.LocalHospital

@Composable
fun BottomNavBar(

    onHomeClick: () -> Unit,

    onDoctorsClick: () -> Unit,

    onAppointmentsClick: () -> Unit,

    onProfileClick: () -> Unit


) {

    NavigationBar(

        containerColor = Color.White,

        tonalElevation = 10.dp
    ) {

        NavigationBarItem(

            selected = true,

            onClick = onHomeClick,

            colors = NavigationBarItemDefaults.colors(

                selectedIconColor =
                    Color.White,

                selectedTextColor =
                    Color(0xFF4A90E2),

                indicatorColor =
                    Color(0xFF4A90E2),

                unselectedIconColor =
                    Color.Gray,

                unselectedTextColor =
                    Color.Gray
            ),

            icon = {

                Icon(

                    imageVector =
                        Icons.Default.Home,

                    contentDescription = null
                )
            },

            label = {

                Text("Home")
            }
        )

        NavigationBarItem(

            selected = false,

            onClick = onDoctorsClick,

            colors = NavigationBarItemDefaults.colors(

                selectedIconColor =
                    Color.White,

                selectedTextColor =
                    Color(0xFF4A90E2),

                indicatorColor =
                    Color(0xFF4A90E2),

                unselectedIconColor =
                    Color.Gray,

                unselectedTextColor =
                    Color.Gray
            ),

            icon = {

                Icon(

                    imageVector =
                        Icons.Default.LocalHospital,

                    contentDescription = null
                )
            },

            label = {

                Text("Doctors")
            }
        )

        NavigationBarItem(

            selected = false,

            onClick = onAppointmentsClick,

            colors = NavigationBarItemDefaults.colors(

                selectedIconColor =
                    Color.White,

                selectedTextColor =
                    Color(0xFF4A90E2),

                indicatorColor =
                    Color(0xFF4A90E2),

                unselectedIconColor =
                    Color.Gray,

                unselectedTextColor =
                    Color.Gray
            ),

            icon = {

                Icon(

                    imageVector =
                        Icons.Default.CalendarMonth,

                    contentDescription = null
                )
            },

            label = {

                Text("Appointments")
            }
        )

        NavigationBarItem(

            selected = false,

            onClick = onProfileClick,

            colors = NavigationBarItemDefaults.colors(

                selectedIconColor =
                    Color.White,

                selectedTextColor =
                    Color(0xFF4A90E2),

                indicatorColor =
                    Color(0xFF4A90E2),

                unselectedIconColor =
                    Color.Gray,

                unselectedTextColor =
                    Color.Gray
            ),

            icon = {

                Icon(

                    imageVector =
                        Icons.Default.Person,

                    contentDescription = null
                )
            },

            label = {

                Text("Profile")
            }
        )
    }
}