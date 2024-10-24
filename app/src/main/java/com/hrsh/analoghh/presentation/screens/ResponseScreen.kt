package com.hrsh.analoghh.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.hrsh.analoghh.presentation.components.Menu

@Composable
fun ResponseScreen(navController: NavHostController, countFavoriteVacancies: Int) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Menu(navController, countFavoriteVacancies)
        }
    }
}