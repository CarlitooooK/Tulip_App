package com.example.medicen.presentation.screens.inventory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.FreeBreakfast
import androidx.compose.material.icons.filled.Icecream
import androidx.compose.material.icons.filled.RiceBowl
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medicen.presentation.components.InventoryItem
import com.example.medicen.ui.theme.backgroundColor

import com.example.medicen.ui.theme.expireColor


import com.example.medicen.ui.theme.primaryColor
import com.example.medicen.ui.theme.secondaryColor


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryScreen() {


    var text by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 20.dp, end = 20.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Mi Inventario", fontSize = 26.sp, color = Color.Black, fontWeight = FontWeight.Bold)
            FloatingActionButton(
                onClick = {},
                shape = CircleShape,
                modifier = Modifier.size(40.dp),
                containerColor = primaryColor,
                contentColor = Color.White
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add to Inventory")
            }
        }


        // Contenedor principal de la búsqueda
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            expanded = false,
            onExpandedChange = { },
            inputField = {
                SearchBarDefaults.InputField(
                    query = text,
                    onQueryChange = { text = it },
                    onSearch = {},
                    expanded = false,
                    onExpandedChange = {},
                    placeholder = { Text("Buscar en el inventario", color = Color.Gray) },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color.Black) },
                    trailingIcon = {
                        if (text.isNotEmpty()) {
                            IconButton(onClick = { text = "" }) {
                                Icon(Icons.Default.Clear, contentDescription = null)
                            }
                        }
                    }
                )
            },
            colors = SearchBarDefaults.colors(containerColor = Color.White),
            shape = RoundedCornerShape(16.dp)
        ) {}

        Text("DESPENSA (12)", color = Color.Black, fontSize = 16.sp, modifier = Modifier.padding(20.dp ))
        LazyColumn(modifier = Modifier.padding(20.dp)) {
            items(3){
                InventoryItem("Arroz Integral","Caduca: 20 Nov", colorExpire = primaryColor, icon = Icons.Default.RiceBowl)
                InventoryItem("Cafe de Grano","Consumir pronto", colorExpire = secondaryColor, icon = Icons.Default.FreeBreakfast)
                InventoryItem("Helado de Litro","Caduca: Mañana", colorExpire = expireColor, icon = Icons.Default.Icecream)
            }
        }
    }

}


@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4_XL)
@Composable
private fun InventoryScreenPreview() {
    InventoryScreen()
}