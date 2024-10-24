package com.hrsh.analoghh.presentation

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import com.hrsh.analoghh.R
import com.hrsh.analoghh.domain.entities.Offer
import com.hrsh.analoghh.domain.entities.Vacancy
import com.hrsh.analoghh.presentation.utils.getNoun
import com.hrsh.analoghh.ui.theme.Blue
import com.hrsh.analoghh.ui.theme.Gray2
import com.hrsh.analoghh.ui.theme.Gray4
import kotlin.math.abs

const val COUNT_VACANCIES = 3

@Composable
fun SearchScreen(
    navController: NavHostController,
    offers: List<Offer>,
    vacancies: List<Vacancy>,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        LazyColumn(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
                Search()
            }
            item {
                LazyRow(
                    modifier = Modifier.padding(20.dp)
                ) {
                    items(offers) { offer ->
                        Offer(image = offer.id?.let {
                            when (it) {
                                "near_vacancies" -> R.drawable.near_vacancies
                                "level_up_resume" -> R.drawable.level_up_resume
                                "temporary_job" -> R.drawable.temporary_job
                                else -> null
                            }
                        }, title = offer.title, link = offer.link, buttonText = offer.buttonText)
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            }
            item {
                Text(
                    modifier = Modifier.padding(start = 20.dp, top = 20.dp, bottom = 10.dp),
                    text = "Вакансии для вас",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
            items(vacancies.take(COUNT_VACANCIES)) { vacancy ->
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
            if (vacancies.isNotEmpty()) {
                item {
                    Button(
                        onClick = { navController.navigate("vacancies") }, modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Blue),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, Color.Black)
                    ) {
                        val countVacancies = vacancies.size - COUNT_VACANCIES
                        Text(
                            text = "Еще $countVacancies ${
                                getNoun(
                                    countVacancies,
                                    "вакансия",
                                    "вакансии",
                                    "вакансий"
                                )
                            }", fontSize = 16.sp, color = Color.White, modifier = Modifier
                                .padding(10.dp)
                        )
                    }
                }
            }
            item { Spacer(modifier = Modifier.height(50.dp)) }
        }
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            Menu(navController)
        }
    }
}