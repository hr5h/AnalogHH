package com.hrsh.analoghh.presentation

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.hrsh.analoghh.R
import com.hrsh.analoghh.ui.theme.Gray4

@Composable
fun Menu(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MenuButton(text = "Поиск", image = R.drawable.search) { navController.navigate(Screen.SearchScreen.route) }
        MenuButton(text = "Избранное", image = R.drawable.favorite) { navController.navigate(Screen.FavoriteScreen.route) }
        MenuButton(text = "Отклики", image = R.drawable.response) { navController.navigate(Screen.ResponseScreen.route) }
        MenuButton(text = "Сообщение", image = R.drawable.message) { navController.navigate(Screen.MessageScreen.route) }
        MenuButton(text = "Профиль", image = R.drawable.profile) { navController.navigate(Screen.ProfileScreen.route) }
    }
}

@Composable
fun MenuButton(text: String, image: Int, onClick: () -> Unit) {
    IconButton(onClick = { onClick() }, modifier = Modifier
        .height(50.dp)
        .width(80.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = text,
                modifier = Modifier.size(24.dp)
            )
            Text(text = text, fontSize = 10.sp, color = Gray4)
        }
    }
}