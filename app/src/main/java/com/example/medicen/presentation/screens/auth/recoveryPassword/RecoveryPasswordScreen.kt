package com.example.medicen.presentation.screens.auth.recoveryPassword

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Password
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.medicen.presentation.components.CustomTextField
import com.example.medicen.ui.theme.backgroundColor
import com.example.medicen.ui.theme.primaryColor

@Composable
fun RecoveryPassswordScreen(
    onRecoverySend: () -> Unit = {}
) {

    var emailResend by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .background(Color.White, shape = RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                Icons.Default.Password,
                contentDescription = null,
                tint = primaryColor,
                modifier = Modifier.size(40.dp)
            )
        }

        Text(
            "Recuperación de\nPassword",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(20.dp)
        )
        Text(
            "Ingresa tu correo electronico\n y sigue las instrucciones",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        CustomTextField(
            emailResend,
            onValueChanger = { emailResend = it },
            placeholder = "Ingresa tu correo",
            Icons.Default.Email,
            modifier = Modifier.fillMaxWidth().padding(40.dp)
        )

        Button(
            onClick = {onRecoverySend()},
            enabled = !emailResend.isEmpty(),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColor,
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth().padding(horizontal = 80.dp, vertical = 20.dp).height(50.dp)
        ) {
            Text("Enviar Instrucciones", fontSize = 14.sp)
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RecoveryPaswwordPrev() {
    RecoveryPassswordScreen()
}