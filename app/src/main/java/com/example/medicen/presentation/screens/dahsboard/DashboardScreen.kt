package com.example.medicen.presentation.screens.dahsboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BakeryDining
import androidx.compose.material.icons.filled.DinnerDining
import androidx.compose.material.icons.filled.Egg
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Timelapse
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medicen.presentation.components.CustomCard
import com.example.medicen.presentation.components.ExpireItem
import com.example.medicen.presentation.components.StockItem
import com.example.medicen.ui.theme.ParkLane
import com.example.medicen.ui.theme.backgroundColor
import com.example.medicen.ui.theme.expireColor
import com.example.medicen.ui.theme.expireSoonColor
import com.example.medicen.ui.theme.primaryColor
import com.example.medicen.ui.theme.secondaryColor

@Composable
fun DashboardScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background( backgroundColor)
    ) {

        Text(
            "Bienvenido Carlo,",
            fontSize = 22.sp,
            fontFamily = ParkLane,
            color = Color.Black,
            modifier = Modifier.padding(top = 10.dp, start = 24.dp)
        )
        Text(
            "Mi Despensa",
            fontSize = 28.sp,
            fontFamily = ParkLane,
            color = Color.Black,
            modifier = Modifier.padding(start = 28.dp, top = 10.dp),
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(14.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomCard(
                label = "Total Articulos",
                count = "45",
                icon = Icons.Default.Inventory,
                iconColor = primaryColor
            )
            CustomCard(
                label = "Caducan Pronto",
                count = "3",
                icon = Icons.Default.Timelapse,
                iconColor = secondaryColor,
            )
        }

        Spacer(Modifier.height(20.dp))
        Text(
            "Próximos a Caducar",
            fontSize = 22.sp,
            fontFamily = ParkLane,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 22.dp)
        )
        LazyColumn(modifier = Modifier.padding(20.dp)) {
            items(1){
                ExpireItem("Leche Entera", "Expira: Mañana", expireColor, Icons.Default.DinnerDining)
                ExpireItem("Pan Griego", "Expira: En 3 días", expireSoonColor, Icons.Default.BakeryDining)
            }
        }

        Text(
            "Bajo Stock",
            fontSize = 22.sp,
            fontFamily = ParkLane,
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 22.dp)
        )
        LazyColumn(Modifier.padding(20.dp)) {
            items(2){
                StockItem("Huevos","Quedan: 2 Unidades", Color.Gray, Icons.Default.Egg)
            }
        }


    }
}


@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4_XL)
@Composable
private fun DashboardScreenPreview() {
    DashboardScreen()
}