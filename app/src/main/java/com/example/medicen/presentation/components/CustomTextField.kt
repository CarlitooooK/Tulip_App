package com.example.medicen.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp



@Composable
fun CustomTextField(value: String, onValueChanger: (String) -> Unit,placeholder: String, icon: ImageVector, modifier: Modifier = Modifier) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChanger,
        maxLines = 1,
        modifier = modifier,
        placeholder = { Text(placeholder, color = Color.Black) },
        leadingIcon = { Icon(imageVector = icon, contentDescription = null, tint = Color.Black) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedTextColor = Color.Black,
        ),
        shape = RoundedCornerShape(8.dp)
    )
}


