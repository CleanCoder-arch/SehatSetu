package com.example.sehatsetu.repository

import com.example.sehatsetu.firebase.FirestoreManager
import com.example.sehatsetu.models.Doctor
import com.google.firebase.firestore.toObject

class DoctorRepository {

    fun getDoctors(
        onResult: (List<Doctor>) -> Unit
    ) {

        FirestoreManager.db
            .collection("doctors")
            .get()

            .addOnSuccessListener { result ->

                val doctorList = mutableListOf<Doctor>()

                for (document in result) {

                    val doctor =
                        document.toObject(Doctor::class.java)

                    doctorList.add(doctor)
                }

                onResult(doctorList)
            }
    }
}