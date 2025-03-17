package br.dev.flp.empregamais.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.dev.flp.empregamais.model.JobDetails

@Composable
fun JobDetailsScreen(navController: NavController, job: JobDetails) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF0A1F44), Color.White)
                )
            )
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        // Botão de Voltar
        Text(
            text = "← Voltar",
            fontSize = 18.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable { navController.popBackStack() }
                .padding(bottom = 16.dp)
        )

        // Nome da Vaga
        Text(
            text = job.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(text = "${job.rating} ★ ${job.company}", fontWeight = FontWeight.Bold, color = Color.Yellow)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = job.location, color = Color.LightGray)
        Text(text = job.workType, fontWeight = FontWeight.Bold, color = Color.Green)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Descrição da vaga",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color(0xFFC1C1FA)
        )
        Text(text = job.description, color = Color.White)

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Requisitos",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = Color(0xFFC1C1FA)
        )
        job.requirements.forEach { requirement ->
            Text(text = "• $requirement", color = Color.White)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { /* Implementar ação de candidatura */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(Color(0xFFFFA500)),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "CANDIDATAR-ME", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}
