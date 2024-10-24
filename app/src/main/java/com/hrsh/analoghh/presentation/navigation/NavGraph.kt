package com.hrsh.analoghh.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hrsh.analoghh.presentation.main.MainViewModel
import com.hrsh.analoghh.presentation.screens.FavoriteScreen
import com.hrsh.analoghh.presentation.screens.MessageScreen
import com.hrsh.analoghh.presentation.screens.ProfileScreen
import com.hrsh.analoghh.presentation.screens.ResponseScreen
import com.hrsh.analoghh.presentation.screens.Screen
import com.hrsh.analoghh.presentation.screens.SearchScreen
import com.hrsh.analoghh.presentation.screens.VacanciesScreen

@Composable
fun NavGraph(navController: NavHostController, viewModel: MainViewModel) {
    val offers = viewModel.offers.collectAsState().value
    val vacancies = viewModel.vacancies.collectAsState().value
    val favoriteVacancies = viewModel.favoriteVacancies.collectAsState().value
    NavHost(navController = navController, startDestination = Screen.SearchScreen.route){
        composable(route = Screen.SearchScreen.route) {
            SearchScreen(navController, offers, vacancies, favoriteVacancies.size, viewModel::insertFavorite, viewModel::deleteFavorite)
        }
        composable(route = Screen.VacanciesScreen.route) {
            VacanciesScreen(navController, vacancies, favoriteVacancies.size, viewModel::insertFavorite, viewModel::deleteFavorite)
        }
        composable(route = Screen.FavoriteScreen.route) {
            FavoriteScreen(navController, favoriteVacancies, viewModel::insertFavorite, viewModel::deleteFavorite)
        }
        composable(route = Screen.ResponseScreen.route) {
            ResponseScreen(navController, favoriteVacancies.size)
        }
        composable(route = Screen.MessageScreen.route) {
            MessageScreen(navController, favoriteVacancies.size)
        }
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen(navController, favoriteVacancies.size)
        }
    }
}