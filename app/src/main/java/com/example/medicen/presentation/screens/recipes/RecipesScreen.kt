package com.example.medicen.presentation.screens.recipes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medicen.presentation.components.CustomFilterButton
import com.example.medicen.presentation.components.CustomSearchBar
import com.example.medicen.presentation.components.RecipiesBox
import com.example.medicen.ui.theme.ParkLane
import com.example.medicen.ui.theme.backgroundColor
import com.example.medicen.ui.theme.primaryColor

@Composable
fun RecipesScreen() {

    val filters = listOf("Rapido", "Vegetariano", "Desayuno", "Comida", "Cena", "Postres")
    var selectedFilter by remember { mutableStateOf("Rapido") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text(
            "Mis recetas",
            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            fontSize = 28.sp,
            fontFamily = ParkLane,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        CustomSearchBar("Buscar receta")

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item {
                filters.forEach { filter ->
                    FilterChip(
                        modifier = Modifier.padding(horizontal = 5.dp),
                        selected = (filter == selectedFilter),
                        onClick = { selectedFilter = filter },
                        label = { Text(filter) },
                        leadingIcon = {
                            if (filter == selectedFilter) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = null,
                                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                                )
                            }
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = primaryColor,
                            labelColor = Color.Black,
                            selectedLabelColor = Color.White,
                            containerColor = Color.White,
                            selectedLeadingIconColor = Color.White,
                            disabledContainerColor = Color.White,

                            ),
                        border = FilterChipDefaults.filterChipBorder(
                            enabled = false,
                            selected = false
                        ),
                        elevation = FilterChipDefaults.elevatedFilterChipElevation(
                            elevation = 8.dp,
                            focusedElevation = 1.dp
                        ),
                        shape = RoundedCornerShape(12.dp)
                    )
                }
            }
        }

        Text(
            "Tus Recetas: ",
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            fontSize = 22.sp,
            fontFamily = ParkLane,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        LazyColumn(modifier = Modifier.padding(20.dp)) {
            items(3) {
                RecipiesBox()
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RecipesScreenPrev() {
    RecipesScreen()
}