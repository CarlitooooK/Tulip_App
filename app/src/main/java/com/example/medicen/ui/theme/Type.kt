package com.example.medicen.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.medicen.R

// Set of Material typography styles to start with

val EuclidCircular = FontFamily(
    Font(R.font.euclid_circular_bold, FontWeight.Bold),
    Font(R.font.euclid_circular_regular, FontWeight.Medium),
    )
val ParkLane = FontFamily(
    Font(R.font.park_lane_light, FontWeight.Light)
)
val Typographys = Typography(
    bodyLarge = TextStyle(
        fontFamily = EuclidCircular,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )

)