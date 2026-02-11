package com.example.medicen.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medicen.ui.theme.ParkLane
import com.example.medicen.ui.theme.Purple40
import com.example.medicen.ui.theme.Purple80
import com.example.medicen.ui.theme.greenBold
import com.example.medicen.ui.theme.primaryColor

@Composable
fun RecipiesBox() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                spotColor = Color.Black,
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(15.dp)
    ) {
        Text(
            "Pasta al Pesto",
            color = Color.Black,
            fontSize = 22.sp,
            fontFamily = ParkLane,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 5.dp)
        )
        Spacer(Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Icon(imageVector = Icons.Default.Timer, contentDescription = null, tint = Color.Black)
            Text("Tiempo: 15 min", color = Color.DarkGray)
            Spacer(Modifier.width(12.dp))
            Icon(imageVector = Icons.Default.LocalFireDepartment, contentDescription = null, tint = Color.Black)
            Text("Calorias: 450 kcal", color = Color.DarkGray, )
        }
        Spacer(Modifier.height(10.dp))
        Row(
            modifier = Modifier.padding(vertical = 5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                "Pruebalo\n¡Listo para cocinar!",
                color = greenBold,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 5.dp)
            )

            Spacer(Modifier.weight(1f))

            OutlinedButton(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = primaryColor,

                    ),
                border = ButtonDefaults.outlinedButtonBorder(false),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Ver receta")
            }
        }
    }
    Spacer(Modifier.height(10.dp))
}

@Preview
@Composable
private fun RecipiesBoxPrev() {
    RecipiesBox()
}