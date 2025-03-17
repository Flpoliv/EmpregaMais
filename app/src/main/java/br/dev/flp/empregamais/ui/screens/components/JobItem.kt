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
import androidx.navigation.NavController

@Composable
fun JobItem(title: String, date: String, navController: NavController) {
    Card (modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Column (modifier = Modifier.padding(16.dp)) {
            Text(text = title, fontWeight = FontWeight.Bold)
            Text(text = "4.5 ★ System Solution", color = Color.Gray)
            Text(text = "São Paulo - SP, à 10km")
            Text(text = date, color = Color.Gray)

            Button (
                onClick = { navController.navigate("details") }, // Redireciona para a tela de detalhes
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
            ) {
                Text("✓ Candidatar-me")
            }
        }
    }
}
