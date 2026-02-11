package com.example.medicen.presentation.screens.inventory

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Inventory2
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medicen.presentation.components.CustomTextField
import com.example.medicen.ui.theme.ParkLane
import com.example.medicen.ui.theme.backgroundColor
import com.example.medicen.ui.theme.greenBold
import com.example.medicen.ui.theme.primaryColor

@Composable
fun InventoryAddScreen(
    modifier: Modifier = Modifier,
    onSaveProduct: () -> Unit = {}
) {

    var text by remember { mutableStateOf("") }
    val filters =
        listOf("Todos", "Por caducar", "Caducados", "Lácteos", "Frutas", "Verduras", "Bebidas")
    var counter by remember { mutableStateOf(1) }

    var selectedFilter by remember { mutableStateOf("Todos") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Spacer(Modifier.weight(0.3f))
        Text(
            "Añadir al inventario",
            fontFamily = ParkLane,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Nombre del producto",
            color = Color.Black,
            fontSize = 18.sp,
        )
        CustomTextField(
            value = text,
            onValueChanger = { text = it },
            placeholder = "Ej. Leche, Arroz, etc...",
            icon = Icons.Default.Inventory2,
            modifier = Modifier.fillMaxWidth()

        )
        Text(
            "Categoria",
            color = Color.Black,
            fontSize = 18.sp,

            )

        LazyRow(
            modifier = Modifier.fillMaxWidth(),
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    "Cantidad",
                    color = Color.Black,
                    fontSize = 18.sp,

                    )
                Row(
                    modifier = Modifier
                        .width(180.dp)
                        .height(56.dp)
                        .border(
                            1.dp,
                            color = Color.Black,
                            shape = RoundedCornerShape(8.dp),
                        )
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    IconButton(
                        onClick = { if (counter > 1) counter-- }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Remove,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.size(24.dp)
                        )
                    }


                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "$counter",
                            color = Color.Black,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = if (counter == 1) "UNIDAD" else "UNIDADES",
                            color = Color.Gray,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(Modifier.width(2.dp))


                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(primaryColor, shape = RoundedCornerShape(12.dp))
                            .clickable { counter++ },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    "Caducidad",
                    color = Color.Black,
                    fontSize = 18.sp,

                    )
                CustomTextField(
                    text,
                    onValueChanger = { text = it },
                    placeholder = "mm/dd/yyy",
                    icon = Icons.Default.CalendarMonth
                )
            }

        }
        Text(
            "Icono",
            color = Color.Black,
            fontSize = 18.sp,

            )
        CustomTextField(
            text,
            onValueChanger = { text = it },
            placeholder = "Elige un icono",
            icon = Icons.Default.CalendarMonth,
            modifier = Modifier.size(width = 180.dp, height = 56.dp)
        )

        OutlinedButton(
            onClick = {
                onSaveProduct()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(horizontal = 50.dp, vertical = 10.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColor,
                contentColor = Color.White,
                disabledContentColor = Color.Gray,
                disabledContainerColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Guardar Producto", fontSize = 16.sp)
        }
        Spacer(Modifier.weight(1f))
    }


}

@Preview(showBackground = true)
@Composable
private fun AddScreenPrev() {
    InventoryAddScreen()
}