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
import com.hrsh.analoghh.R
import com.hrsh.analoghh.domain.entities.Offer
import com.hrsh.analoghh.domain.entities.Vacancy
import com.hrsh.analoghh.presentation.utils.getNoun
import com.hrsh.analoghh.ui.theme.Blue
import com.hrsh.analoghh.ui.theme.Gray2
import com.hrsh.analoghh.ui.theme.Gray4
import kotlin.math.abs

@Composable
fun VacanciesScreen(
    navController: NavHostController,
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
                SearchBack(navController)
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, top = 10.dp, end = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    val countVacancies = vacancies.size
                    Text(
                        text = "$countVacancies ${
                            getNoun(
                                countVacancies,
                                "вакансия",
                                "вакансии",
                                "вакансий"
                            )
                        }",
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "По соответствию", color = Blue, modifier = Modifier.padding(end = 20.dp))
                        Column {
                            Image(painter = painterResource(id = R.drawable.arrow_top), contentDescription = "arrow_top", modifier = Modifier.size(10.dp))
                            Image(painter = painterResource(id = R.drawable.arrow_down), contentDescription = "arrow_down", modifier = Modifier.size(10.dp))
                        }
                    }
                }
            }
            items(vacancies) { vacancy ->
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
            Menu(navController)
        }
    }
}