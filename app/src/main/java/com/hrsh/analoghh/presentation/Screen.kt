package com.hrsh.analoghh.presentation

sealed class Screen(val route: String) {
    data object SearchScreen: Screen("search")
    data object VacanciesScreen: Screen("vacancies")
    data object FavoriteScreen: Screen("favorite")
    data object ResponseScreen: Screen("response")
    data object MessageScreen: Screen("message")
    data object ProfileScreen: Screen("profile")
}