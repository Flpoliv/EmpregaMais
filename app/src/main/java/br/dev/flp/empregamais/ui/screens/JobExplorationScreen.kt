package br.dev.flp.empregamais.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.dev.flp.empregamais.model.JobDetails
import br.dev.flp.empregamais.model.jobList
import br.dev.flp.empregamais.ui.screens.components.JobItem
import br.dev.flp.empregamais.ui.screens.components.SearchBar

@Composable
fun JobList(navController: NavController) {
    var query by remember { mutableStateOf("") }
    var selectedTab by remember { mutableStateOf("SUGERIDAS") }

    val filteredJobs = jobList.filter {
        it.title.contains(query, ignoreCase = true) ||
                it.company.contains(query, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF002366), Color(0xFF0044AA)) // Azul-marinho gradiente
                )
            )
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Cabeçalho com título e avatar
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Achar Vagas",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Avatar",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Barra de pesquisa
        SearchBar(query = query, onQueryChanged = { query = it })
        Spacer(modifier = Modifier.height(16.dp))

        // Abas de filtro
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TabButton("SUGERIDAS", selectedTab == "SUGERIDAS") { selectedTab = "SUGERIDAS" }
            TabButton("MAIS RELEVANTES", selectedTab == "MAIS RELEVANTES") { selectedTab = "MAIS RELEVANTES" }
        }
        Spacer(modifier = Modifier.height(16.dp))

        filteredJobs.forEach { job ->
            JobItem(job = job, navController = navController)
        }
    }
}

@Composable
fun TabButton(text: String, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        TextButton(onClick = onClick) {
            Text(text, color = if (isSelected) Color.White else Color.LightGray, fontWeight = FontWeight.Bold)
        }
        if (isSelected) {
            Box(
                modifier = Modifier
                    .height(3.dp)
                    .width(80.dp)
                    .background(Color(0xFFFFA500))
            )
        }
    }
}