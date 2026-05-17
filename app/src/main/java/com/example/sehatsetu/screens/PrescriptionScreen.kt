package com.example.sehatsetu.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun PrescriptionScreen() {

    var uploadedFiles by remember {

        mutableStateOf<List<Uri>>(emptyList())
    }

    val launcher =

        rememberLauncherForActivityResult(

            contract =
                ActivityResultContracts.GetContent()

        ) { uri: Uri? ->

            if (uri != null) {

                uploadedFiles =
                    uploadedFiles + uri
            }
        }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(
                Color(0xFFF5F7FA)
            )
            .padding(16.dp)
    ) {

        Text(

            text = "Medical Reports",

            fontSize = 30.sp,

            fontWeight = FontWeight.Bold,

            color = Color(0xFF1A237E)
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(

            text =
                "Upload and manage your prescriptions",

            color = Color.Gray
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(

            onClick = {

                launcher.launch("image/*")
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(58.dp),

            shape = RoundedCornerShape(18.dp),

            colors = ButtonDefaults.buttonColors(

                containerColor =
                    Color(0xFF4A90E2)
            )
        ) {

            Icon(

                imageVector =
                    Icons.Default.Upload,

                contentDescription = null
            )

            Spacer(
                modifier = Modifier.width(8.dp)
            )

            Text(

                text = "Upload Prescription",

                fontSize = 18.sp
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        LazyColumn {

            items(uploadedFiles) { file ->

                Card(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 18.dp),

                    shape = RoundedCornerShape(24.dp),

                    elevation =
                        CardDefaults.cardElevation(
                            defaultElevation = 8.dp
                        )
                ) {

                    Column {

                        Image(

                            painter =
                                rememberAsyncImagePainter(file),

                            contentDescription = null,

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(240.dp)
                                .clip(
                                    RoundedCornerShape(
                                        topStart = 24.dp,
                                        topEnd = 24.dp
                                    )
                                ),

                            contentScale =
                                ContentScale.Crop
                        )

                        Column(

                            modifier =
                                Modifier.padding(16.dp)
                        ) {

                            Text(

                                text =
                                    "Prescription Uploaded",

                                fontWeight =
                                    FontWeight.Bold,

                                fontSize = 20.sp,

                                color =
                                    Color(0xFF1A237E)
                            )

                            Spacer(
                                modifier =
                                    Modifier.height(6.dp)
                            )

                            Text(

                                text =
                                    "Medical report saved successfully.",

                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}