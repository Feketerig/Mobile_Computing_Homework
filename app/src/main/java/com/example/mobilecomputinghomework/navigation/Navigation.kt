package com.example.mobilecomputinghomework.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.example.mobilecomputinghomework.feature_authentication.presentation.login.LoginScreen
import com.example.mobilecomputinghomework.feature_authentication.presentation.registration.presentation.RegistrationScreen
import com.example.mobilecomputinghomework.feature_location.presentation.MapScreen
import com.example.mobilecomputinghomework.feature_profile.presentation.ProfileScreen
import com.example.mobilecomputinghomework.feature_reminder.presentation.reminder_edit.ReminderEditScreen
import com.example.mobilecomputinghomework.feature_reminder.presentation.reminder_list.RemindersListScreen

@Composable
fun Navigation(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.Login.route,
        modifier = modifier
    ){
        composable(route = Screen.RemindersList.route){
            RemindersListScreen(navHostController = navHostController)
        }
        composable(
            route = Screen.ReminderEdit.route + "?id={id}",
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://reminders_detail/{id}"
                    action = Intent.ACTION_VIEW
                }
            ),
            arguments = listOf(
                navArgument(
                    name = "id"
                ){
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ){
            ReminderEditScreen(navHostController = navHostController)
        }
        composable(route = Screen.Registration.route){
            RegistrationScreen(navController = navHostController)
        }
        composable(
            route = Screen.Logout.route,
        ) {
            LoginScreen(
                mode = "logout",
                navController = navHostController
            )
        }
        composable(
            route = Screen.Login.route,
        ) {
            LoginScreen(
                mode = "login",
                navController = navHostController
            )
        }
        composable(route = Screen.Profile.route){
            ProfileScreen("Levente Fazekas")
        }
        composable(route = Screen.Maps.route){
            MapScreen()
        }
    }

}