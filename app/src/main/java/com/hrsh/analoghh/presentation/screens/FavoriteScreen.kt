package com.hrsh.analoghh.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.hrsh.analoghh.R
import com.hrsh.analoghh.domain.entities.Vacancy
import com.hrsh.analoghh.presentation.components.Menu
import com.hrsh.analoghh.presentation.components.SearchBack
import com.hrsh.analoghh.presentation.components.Vacancy
import com.hrsh.analoghh.presentation.utils.getNoun
import com.hrsh.analoghh.ui.theme.Blue
import com.hrsh.analoghh.ui.theme.Gray3

@Composable
fun FavoriteScreen(navController: NavHostController, favoriteVacancies: List<Vacancy>) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            item {
                Column {
                    Text(text = "Избранное", fontSize = 26.sp, modifier = Modifier.padding(top = 30.dp, start = 20.dp, bottom = 30.dp))
                    val countVacancies = favoriteVacancies.size
                    Text(
                        text = "$countVacancies ${
                            getNoun(
                                countVacancies,
                                "вакансия",
                                "вакансии",
                                "вакансий"
                            )
                        }",
                        modifier = Modifier.padding(start = 20.dp, bottom = 10.dp),
                        color = Gray3
                    )
                }
            }
            items(favoriteVacancies) { vacancy ->
                Vacancy(
                    lookingNumber = vacancy.lookingNumber,
                    isFavorite = vacancy.isFavorite,
                    title = vacancy.title,
                    town = vacancy.address,
                    company = vacancy.company,
                    experience = vacancy.experience,
                    publishedDate = vacancy.publishedDate
                )
            }
            item { Spacer(modifier = Modifier.height(50.dp)) }
        }
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Menu(navController, favoriteVacancies.size)
        }
    }
}