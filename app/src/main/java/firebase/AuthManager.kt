package com.example.sehatsetu.firebase

import com.google.firebase.auth.FirebaseAuth

object AuthManager {

    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun loginUser(

        email: String,

        password: String,

        onSuccess: () -> Unit,

        onError: (String) -> Unit
    ) {

        auth.signInWithEmailAndPassword(
            email,
            password
        )

            .addOnCompleteListener { task ->

                if (task.isSuccessful) {

                    onSuccess()

                } else {

                    onError(
                        task.exception?.message
                            ?: "Login Failed"
                    )
                }
            }
    }

    fun signupUser(

        email: String,

        password: String,

        onSuccess: () -> Unit,

        onError: (String) -> Unit
    ) {

        auth.createUserWithEmailAndPassword(
            email,
            password
        )

            .addOnCompleteListener { task ->

                if (task.isSuccessful) {

                    onSuccess()

                } else {

                    onError(
                        task.exception?.message
                            ?: "Signup Failed"
                    )
                }
            }
    }
}