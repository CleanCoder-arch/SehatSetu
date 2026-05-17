package com.example.sehatsetu.models

data class Appointment(

    val patientId: String = "",

    val doctorName: String = "",

    val specialization: String = "",

    val date: String = "",

    val time: String = "",

    val status: String = "Upcoming",

    val imageUrl: String = ""
)