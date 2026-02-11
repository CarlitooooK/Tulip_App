package com.example.medicen.presentation.screens.auth.register


import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BakeryDining
import androidx.compose.material.icons.filled.Coffee
import androidx.compose.material.icons.filled.Cookie
import androidx.compose.material.icons.filled.DinnerDining
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Icecream
import androidx.compose.material.icons.filled.LocalFlorist
import androidx.compose.material.icons.filled.LunchDining
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.outlined.Cake
import androidx.compose.material.icons.outlined.Cookie
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medicen.presentation.components.CustomTextField
import com.example.medicen.ui.theme.ParkLane
import com.example.medicen.ui.theme.backgroundColor
import com.example.medicen.ui.theme.primaryColor

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    onRegisterSuccess: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {


        Box(
            modifier = Modifier
                .width(70.dp)
                .height(70.dp)
                .background(Color.White, shape = RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center


        ) {
            Icon(
                imageVector = Icons.Default.Coffee,
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                tint = primaryColor
            )

        }


        Text(
            "Registrate",
            fontSize = 38.sp,
            fontFamily = ParkLane,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color.Black,
            modifier = Modifier.padding(top = 20.dp)
        )
        Text(
            "Empieza a organizar tu despensa de\n forma sencilla y eficiente",
            fontSize = 18.sp,
            fontFamily = ParkLane,
            textAlign = TextAlign.Center,
            color = Color.Gray,
            modifier = Modifier.padding(vertical = 20.dp)

        )

        Text(
            "Nombre",
            modifier = Modifier
                .padding(start = 20.dp)
                .fillMaxWidth(),
            fontSize = 16.sp,
            color = Color.Black
        )


        CustomTextField(
            value = name,
            { name = it },
            placeholder = "Tu nombre completo",
            icon = Icons.Filled.Email,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 14.dp)
        )


        Text(
            "Correo Electronico",
            modifier = Modifier
                .padding(start = 20.dp)
                .fillMaxWidth(),
            fontSize = 16.sp,
            color = Color.Black
        )


        CustomTextField(
            value = email,
            { email = it },
            placeholder = "Correo Electronico",
            icon = Icons.Filled.Email,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
        )


        Text(
            "Contraseña",
            modifier = Modifier
                .padding(start = 20.dp)
                .fillMaxWidth(),
            fontSize = 16.sp,
            color = Color.Black
        )


        CustomTextField(
            value = password,
            { password = it },
            "Minimo 8 caracteres",
            icon = Icons.Filled.Password,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 10.dp)
        )




        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .height(50.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = primaryColor,
                disabledContainerColor = Color.Gray,


                ),
            enabled = !email.isEmpty() && !password.isEmpty() && !name.isEmpty()
        ) {
            Text(
                "Registrarse",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("¿Ya tienes cuenta?", color = Color.Black)
            Spacer(Modifier.width(10.dp))
            Text(
                "Inicia Sesion",
                color = primaryColor,
                textDecoration = TextDecoration.Underline,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable(
                    onClick = onNavigateToLogin
                )
            )
        }


    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen()
}

