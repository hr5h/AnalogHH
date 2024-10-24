package com.hrsh.analoghh.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(navController: NavHostController, viewModel: MainViewModel) {
    val offers = viewModel.offers.collectAsState().value
    val vacancies = viewModel.vacancies.collectAsState().value
    NavHost(navController = navController, startDestination = Screen.SearchScreen.route){
        composable(route = Screen.SearchScreen.route) {
            SearchScreen(navController, offers, vacancies)
        }
        composable(route = Screen.VacanciesScreen.route) {
            VacanciesScreen(navController, vacancies)
        }
        composable(route = Screen.FavoriteScreen.route) {
            FavoriteScreen()
        }
        composable(route = Screen.ResponseScreen.route) {
            ResponseScreen()
        }
        composable(route = Screen.MessageScreen.route) {
            MessageScreen()
        }
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen()
        }
    }
}