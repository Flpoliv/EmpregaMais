package br.dev.flp.empregamais

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import br.dev.flp.empregamais.model.jobList
import br.dev.flp.empregamais.ui.screens.JobList
import br.dev.flp.empregamais.ui.screens.JobDetailsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            NavHost(navController, startDestination = "exploration") {
                composable("exploration") {
                    JobList(navController)
                }
                composable(
                    "details/{jobId}",
                    arguments = listOf(navArgument("jobId") { type = NavType.IntType })
                ) { backStackEntry ->
                    val jobId = backStackEntry.arguments?.getInt("jobId") ?: 0
                    JobDetailsScreen(navController, jobList[jobId])
                }
            }
        }
    }
}