package br.dev.flp.empregamais.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import br.dev.flp.empregamais.R

@Composable
fun PerfilScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF002D62)), // Cor de fundo
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = modifier.height(24.dp))

       AsyncImage(
            model = "" /*"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvqeG0RhsP3WeuxuU1u0f7AmxAUqpcFn0h-g&s" */,
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(80.dp)
                .background(Color.White, shape = CircleShape)
                .padding(2.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = modifier.height(8.dp))

        Text(
            text = "Jack Black",
            fontSize = 24.sp,
            color = Color.White
        )

        Text(
            text = "📍 São Paulo - SP, Brasil",
            fontSize = 14.sp,
            color = Color.LightGray
        )
        Spacer(modifier = Modifier.height(24.dp))

        PerfilButton(icon = R.drawable.ic_save, text = "Vagas salvas")
        PerfilButton(icon = R.drawable.ic_history, text = "Histórico de candidaturas")
        PerfilButton(icon = R.drawable.ic_person, text = "Informações pessoais")
        PerfilButton(icon = R.drawable.ic_settings, text = "Configurações do aplicativo")

        Text(
            text = "Sair ➔",
            fontSize = 16.sp,
            color = Color.LightGray,
            modifier = Modifier
                .padding(bottom = 24.dp)
                .clickable {
                    // adicionar uma ação para sair, por exemplo, navegando para a tela de login
                    navController.navigate("login")
                }
        )
    }
}

@Composable
fun PerfilButton(icon: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 70.dp, vertical = 20.dp)
            .clickable { /* Aqui você pode adicionar ação ao botão, se necessário */ },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = text,
            tint = Color.Cyan,
            modifier = Modifier
                .size(24.dp)
        )

        Text(
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = Color.White
        )
    }
}
