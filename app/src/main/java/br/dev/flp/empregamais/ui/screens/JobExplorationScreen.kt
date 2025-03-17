package br.dev.flp.empregamais.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.dev.flp.empregamais.model.JobDetails
import br.dev.flp.empregamais.model.jobList

@Composable
fun JobList(navController: NavController) {
    Column (modifier = Modifier.padding(16.dp)) {
        jobList.forEach { job ->
            JobItem(job, navController)
        }
    }
}

@Composable
fun JobItem(job: JobDetails, navController: NavController) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = job.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "${job.rating} ★ ${job.company}", fontWeight = FontWeight.Bold, color = Color.Gray)
            Text(text = job.location)
            Text(text = job.workType, color = Color.Green)

            Button (
                onClick = { navController.navigate("details/${jobList.indexOf(job)}") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("✓ Candidatar-me")
            }
        }
    }
}
