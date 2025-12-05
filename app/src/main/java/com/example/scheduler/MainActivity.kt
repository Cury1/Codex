package com.example.scheduler

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.scheduler.feature.schedule.navigation.ScheduleDestinations
import com.example.scheduler.feature.schedule.navigation.scheduleGraph
import com.example.scheduler.feature.settings.SettingsScreen
import com.example.scheduler.ui.theme.SchedulerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SchedulerTheme {
                val navController = rememberNavController()
                Surface(color = MaterialTheme.colorScheme.background, modifier = Modifier.fillMaxSize()) {
                    NavHost(
                        navController = navController,
                        startDestination = ScheduleDestinations.home
                    ) {
                        scheduleGraph(
                            navController = navController,
                            onOpenSettings = { navController.navigate("settings") }
                        )
                        composable(route = "settings") {
                            SettingsScreen(onBack = { navController.popBackStack() })
                        }
                    }
                }
            }
        }
    }
}
