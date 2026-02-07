package com.example.medicen.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WbTwilight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicen.ui.theme.primaryColor
import java.nio.file.WatchEvent

@Composable
fun CustomFilterButton(text: String = "Rapido") {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .background(primaryColor, shape = RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                Icons.Default.WbTwilight,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.padding(end = 5.dp)
            )
            Text(text, color = Color.White)

        }
    }
}

@Preview
@Composable
private fun FilterButtonPrev() {
    CustomFilterButton()

}