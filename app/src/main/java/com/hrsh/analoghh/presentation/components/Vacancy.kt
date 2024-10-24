package com.hrsh.analoghh.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrsh.analoghh.R
import com.hrsh.analoghh.ui.theme.Gray1
import com.hrsh.analoghh.ui.theme.Gray3
import com.hrsh.analoghh.ui.theme.Green
import java.text.SimpleDateFormat
import java.util.Locale

@SuppressLint("SimpleDateFormat")
@Composable
fun Vacancy(
    lookingNumber: Int?,
    isFavorite: Boolean,
    title: String,
    town: String,
    company: String,
    experience: String,
    publishedDate: String
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
        .clip(RoundedCornerShape(8.dp))
        .background(Gray1)) {
        Image(painter = if(isFavorite) painterResource(id = R.drawable.favorite) else painterResource(id = R.drawable.heart), contentDescription = "favorite", modifier = Modifier
            .padding(20.dp)
            .size(30.dp)
            .align(Alignment.TopEnd))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            lookingNumber?.let { Text(text = "Сейчас просматривает $it человек", fontSize = 14.sp, color = Green) }
            Text(text = title, fontSize = 16.sp, color = Color.White, modifier = Modifier.padding(5.dp))
            Text(text = town, fontSize = 14.sp, color = Color.White, modifier = Modifier.padding(5.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = company, fontSize = 14.sp, color = Color.White, modifier = Modifier.padding(5.dp))
                Image(painter = painterResource(id = R.drawable.verification), contentDescription = "verification", modifier = Modifier.size(16.dp))
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.portfolio), contentDescription = "portfolio", modifier = Modifier.size(16.dp))
                Text(text = experience, fontSize = 14.sp, color = Color.White, modifier = Modifier.padding(5.dp))
            }
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            val date = dateFormat.parse(publishedDate)
            val formattedDate = date?.let {
                SimpleDateFormat("d MMMM", Locale.getDefault()).format(
                    it
                )
            }
            Text(text = "Опубликовано $formattedDate", color = Gray3, fontSize = 14.sp, modifier = Modifier.padding(5.dp))
            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Green),
                shape = RoundedCornerShape(50.dp)
            ) {
                Text(text = "Откликнуться", fontSize = 14.sp, color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun PreviewVacancy() {
    Vacancy(1, false, "UI/UX Designer", "Минск", "Мобирикс", "Без опыта", "2024-02-20")
}