package com.example.sehatsetu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sehatsetu.firebase.AuthManager
import com.example.sehatsetu.models.Doctor
import com.example.sehatsetu.screens.*
import com.example.sehatsetu.ui.theme.ThemeViewModel


@Composable
fun AppNavigation(

    themeViewModel: ThemeViewModel
) {

    val navController = rememberNavController()

    NavHost(

        navController = navController,

        startDestination = "splash"
    ) {

        composable("login") {

            LoginScreen(

                onSignupClick = {

                    navController.navigate("signup")
                },

                onLoginSuccess = {

                    navController.navigate("home") {

                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable("signup") {

            SignupScreen(

                onSignupSuccess = {

                    navController.navigate("home") {

                        popUpTo("signup") {
                            inclusive = true
                        }
                    }
                },

                onLoginClick = {

                    navController.navigate("login")
                }
            )
        }

        composable("home") {

            HomeScreen(

                themeViewModel = themeViewModel,

                onDoctorsClick = {

                    navController.navigate("doctors")
                },

                onBookAppointment = { doctor ->

                    navController.navigate(

                        "appointment/" +
                                "${doctor.name}/" +
                                "${doctor.specialization}"

                    )
                },

                onDoctorDetailsClick = { doctor ->

                    navController.navigate(

                        "doctorDetails/" +
                                "${doctor.name}/" +
                                "${doctor.specialization}/" +
                                "${doctor.rating}"
                    )
                },

                onAppointmentsClick = {

                    navController.navigate("appointments")
                },

                onProfileClick = {

                    navController.navigate("profile")
                },

                onAIClick = {

                    navController.navigate("ai")
                },

                onChatClick = {

                    navController.navigate("chat")
                },

                onPrescriptionClick = {

                    navController.navigate("prescription")
                },

                onEmergencyClick = {

                    navController.navigate("emergency")
                }
            )
        }

        composable(

            route =
                "doctorDetails/{doctorName}/{specialization}/{rating}",

            arguments = listOf(

                navArgument("doctorName") {
                    type = NavType.StringType
                },

                navArgument("specialization") {
                    type = NavType.StringType
                },

                navArgument("rating") {
                    type = NavType.StringType
                }
            )

        ) { backStackEntry ->

            val doctor = Doctor(

                name =
                    backStackEntry.arguments
                        ?.getString("doctorName") ?: "",

                specialization =
                    backStackEntry.arguments
                        ?.getString("specialization") ?: "",



                rating =
                    backStackEntry.arguments
                        ?.getString("rating") ?: "4.8"
            )

            DoctorDetailsScreen(

                doctor = doctor,

                onBookAppointment = {

                    navController.navigate(

                        "appointment/" +
                                "${doctor.name}/" +
                                "${doctor.specialization}"
                    )
                }
            )
        }

        composable(

            route =
                "appointment/{doctorName}/{specialization}",

            arguments = listOf(

                navArgument("doctorName") {
                    type = NavType.StringType
                },

                navArgument("specialization") {
                    type = NavType.StringType
                }
            )

        ) { backStackEntry ->

            val doctorName =

                backStackEntry.arguments
                    ?.getString("doctorName") ?: ""

            val specialization =

                backStackEntry.arguments
                    ?.getString("specialization") ?: ""

            AppointmentScreen(

                doctorName = doctorName,

                specialization = specialization
            )
        }

        composable("doctors") {

            DoctorsScreen(

                onDoctorDetailsClick = { doctor ->

                    navController.navigate(

                        "doctorDetails/" +
                                "${doctor.name}/" +
                                "${doctor.specialization}/" +
                                "${doctor.rating}"
                    )
                }
            )
        }

        composable("appointments") {

            AppointmentsScreen(

                onJoinCall = {

                    navController.navigate("videoCall")
                }
            )
        }

        composable("chat") {

            ChatScreen()
        }

        composable("ai") {

            AISymptomScreen()
        }

        composable("emergency") {

            EmergencyScreen()
        }

        composable("prescription") {

            PrescriptionScreen()
        }

        composable("profile") {

            ProfileScreen(

                onLogout = {

                    AuthManager.auth.signOut()

                    navController.navigate("login") {

                        popUpTo("home") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable("videoCall") {

            VideoCallScreen()
        }

        composable("splash") {

            SplashScreen(

                onNavigate = {

                    if (

                        AuthManager
                            .auth
                            .currentUser != null

                    ) {

                        navController.navigate("home") {

                            popUpTo("splash") {
                                inclusive = true
                            }
                        }

                    } else {

                        navController.navigate("login") {

                            popUpTo("splash") {
                                inclusive = true
                            }
                        }
                    }
                }
            )
        }
    }
}