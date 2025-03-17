package br.dev.flp.empregamais.ui.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.dev.flp.empregamais.model.JobDetails
import br.dev.flp.empregamais.model.jobList
import androidx.compose.ui.Modifier


@Composable
fun JobItem(job: JobDetails, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = job.title,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFF003399)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "⭐ ${job.rating}  ${job.company}", fontWeight = FontWeight.Bold, color = Color(0xFF888888))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = job.location, fontSize = 14.sp, color = Color.DarkGray)
            Text(text = job.workType, fontSize = 14.sp, color = Color(0xFF4CAF50))
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { navController.navigate("details/${jobList.indexOf(job)}") }
                ,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF003399)),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("✓ Candidatar-me", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}