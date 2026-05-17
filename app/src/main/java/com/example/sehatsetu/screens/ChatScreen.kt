package com.example.sehatsetu.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sehatsetu.firebase.FirestoreManager
import com.example.sehatsetu.models.ChatMessage
import com.google.firebase.firestore.ListenerRegistration

@Composable
fun ChatScreen() {

    var message by remember {

        mutableStateOf("")
    }

    var messages by remember {

        mutableStateOf<List<ChatMessage>>(
            emptyList()
        )
    }

    LaunchedEffect(Unit) {

        FirestoreManager.db
            .collection("chat")

            .addSnapshotListener { value, _ ->

                if (value != null) {

                    val chatList =
                        value.toObjects(
                            ChatMessage::class.java
                        )

                    messages = chatList
                }
            }
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FA))
            .padding(16.dp)
    ) {

        Text(

            text = "Doctor Chat",

            style =
                MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        LazyColumn(

            modifier = Modifier.weight(1f)
        ) {

            items(messages) { chat ->

                Row(

                    modifier = Modifier.fillMaxWidth(),

                    horizontalArrangement =

                        if (chat.sender == "user")
                            Arrangement.End
                        else
                            Arrangement.Start
                ) {

                    Surface(

                        color =

                            if (chat.sender == "user")
                                Color(0xFF4A90E2)
                            else
                                Color.White,

                        shape =
                            RoundedCornerShape(18.dp),

                        tonalElevation = 4.dp
                    ) {

                        Text(

                            text = chat.message,

                            modifier = Modifier.padding(
                                14.dp
                            ),

                            color =

                                if (chat.sender == "user")
                                    Color.White
                                else
                                    Color.Black
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(10.dp)
                )
            }
        }

        Row(

            modifier = Modifier.fillMaxWidth(),

            verticalAlignment =
                Alignment.CenterVertically
        ) {

            OutlinedTextField(

                value = message,

                onValueChange = {

                    message = it
                },

                modifier = Modifier.weight(1f),

                placeholder = {

                    Text("Type message")
                }
            )

            Spacer(
                modifier = Modifier.width(10.dp)
            )

            Button(

                onClick = {

                    if (message.isNotEmpty()) {

                        val chatMessage = ChatMessage(

                            sender = "user",

                            message = message
                        )

                        FirestoreManager.db
                            .collection("chat")
                            .add(chatMessage)

                        message = ""
                    }
                }
            ) {

                Text("Send")
            }
        }
    }
}