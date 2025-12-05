package com.example.scheduler.feature.schedule.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.scheduler.feature.schedule.ui.EventDetailScreen
import com.example.scheduler.feature.schedule.ui.EventEditorScreen
import com.example.scheduler.feature.schedule.ui.HomeScreen

object ScheduleDestinations {
    const val home = "home"
    const val detail = "detail/{eventId}"
    const val editor = "editor?eventId={eventId}"
    const val eventIdArg = "eventId"
}

fun NavController.navigateToDetail(eventId: Long) {
    navigate("detail/$eventId")
}

fun NavController.navigateToEditor(eventId: Long? = null) {
    val route = eventId?.let { "editor?eventId=$it" } ?: "editor"
    navigate(route)
}

fun NavGraphBuilder.scheduleGraph(
    navController: NavController,
    onOpenSettings: () -> Unit = {}
) {
    composable(route = ScheduleDestinations.home) {
        HomeScreen(
            onOpenSettings = onOpenSettings,
            onEventSelected = { navController.navigateToDetail(it) },
            onCreateEvent = { navController.navigateToEditor() }
        )
    }
    composable(
        route = ScheduleDestinations.detail,
        arguments = listOf(navArgument(ScheduleDestinations.eventIdArg) { type = NavType.LongType })
    ) { backStackEntry ->
        val eventId = backStackEntry.arguments?.getLong(ScheduleDestinations.eventIdArg) ?: 0L
        EventDetailScreen(
            eventId = eventId,
            onEdit = { navController.navigateToEditor(eventId) },
            onBack = { navController.popBackStack() }
        )
    }
    composable(
        route = ScheduleDestinations.editor,
        arguments = listOf(
            navArgument(ScheduleDestinations.eventIdArg) {
                type = NavType.LongType
                defaultValue = -1L
            }
        )
    ) { backStackEntry ->
        val eventId = backStackEntry.arguments?.getLong(ScheduleDestinations.eventIdArg)?.takeIf { it >= 0 }
        EventEditorScreen(
            eventId = eventId,
            onSave = { navController.popBackStack() },
            onCancel = { navController.popBackStack() }
        )
    }
}
