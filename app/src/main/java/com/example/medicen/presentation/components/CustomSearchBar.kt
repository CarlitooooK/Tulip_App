package com.example.medicen.presentation.components

import android.R
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medicen.ui.theme.primaryColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(hint: String) {
    var text by remember { mutableStateOf("") }
    DockedSearchBar(
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
                placeholder = { Text(hint, color = Color.Gray) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color.Black) },
                trailingIcon = {
                    if (text.isNotEmpty()) {
                        IconButton(onClick = { text = "" }) {
                            Icon(Icons.Default.Clear, contentDescription = null)
                        }
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    unfocusedContainerColor = Color.White,
                    cursorColor = primaryColor,
                    focusedIndicatorColor = Color.Black,
                    disabledIndicatorColor = Color.Black,
                    focusedLeadingIconColor = Color.Black,
                    focusedTrailingIconColor = Color.Black
                )

            )
        },
        colors = SearchBarDefaults.colors(
            containerColor = Color.White,
        ),
        shape = RoundedCornerShape(16.dp)
    ) {}
}

@Preview
@Composable
private fun SearchBarPrev() {
    CustomSearchBar("hola")
    
}
