package br.dev.flp.empregamais.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.dev.flp.empregamais.R

@Composable
fun CadastroScreen(navController: NavController) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var senhaConfirm by remember { mutableStateOf("") }
    val tamanhoSenha = 8

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.back01),
            contentDescription = "Background azul",
            contentScale = ContentScale.Crop
        )

        // Logo no canto superior direito
        Image(
            painter = painterResource(id = R.drawable.logoslogan),
            contentDescription = "Logo Slogan",
            modifier = Modifier
                .size(120.dp)
                .padding(16.dp)
                .align(Alignment.TopEnd) // Alinha no canto superior direito
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 60.dp)
                .offset(y = 70.dp)
        ) {
            // Título "Cadastrar-se"
            Text(
                text = "Cadastrar-se",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome") },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "Ícone de usuário", tint = Color.White)
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xFFFFA201),
                    unfocusedIndicatorColor = Color.White,
                    cursorColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                modifier = Modifier
                    .height(50.dp)
                    .width(250.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("E-mail") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = "Ícone de email", tint = Color.White)
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xFFFFA201),
                    unfocusedIndicatorColor = Color.White,
                    cursorColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                modifier = Modifier
                    .height(50.dp)
                    .width(250.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = senha,
                onValueChange = { if (it.length <= tamanhoSenha) senha = it },
                label = { Text("Senha") },
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "Ícone de senha", tint = Color.White)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xFFFFA201),
                    unfocusedIndicatorColor = Color.White,
                    cursorColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                modifier = Modifier
                    .height(50.dp)
                    .width(250.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextField(
                value = senhaConfirm,
                onValueChange = { if (it.length <= tamanhoSenha) senhaConfirm = it },
                label = { Text("Confirmar Senha") },
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "Ícone de senha", tint = Color.White)
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color(0xFFFFA201),
                    unfocusedIndicatorColor = Color.White,
                    cursorColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent
                ),
                modifier = Modifier
                    .height(50.dp)
                    .width(250.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                onClick = { navController.navigate("exploration") },
                modifier = Modifier
                    .height(35.dp)
                    .width(120.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFA201),
                    contentColor = Color.White
                )
            ) {
                Text(text = "Cadastrar")
            }

            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = R.drawable.redes_sociais),
                contentDescription = "Redes sociais",
                modifier = Modifier
                    .size(150.dp)
            )

            Text(
                text = "Já tem uma conta? Faça login aqui!",
                modifier = Modifier
                    .clickable { navController.navigate("login") }
                    .padding(top = 10.dp),
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}
