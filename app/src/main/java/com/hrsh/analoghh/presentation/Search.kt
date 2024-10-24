package com.hrsh.analoghh.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.hrsh.analoghh.R
import com.hrsh.analoghh.ui.theme.Gray2
import com.hrsh.analoghh.ui.theme.Gray4

@Composable
fun Search() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TextField(
            value = "Должность. ключевые слова",
            onValueChange = {},
            modifier = Modifier.clip(RoundedCornerShape(8.dp)),
            readOnly = true,
            enabled = false,
            textStyle = TextStyle(fontSize = 16.sp),
            colors = TextFieldDefaults.colors(
                disabledTextColor = Gray4,
                disabledContainerColor = Gray2,
                disabledIndicatorColor = Color.Transparent
            ),
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = "search",
                    modifier = Modifier.size(20.dp)
                )
            })
        Image(
            painter = painterResource(R.drawable.filter),
            contentDescription = "filter",
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Gray2)
                .padding(14.dp)
        )
    }
}

@Composable
fun SearchBack(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TextField(
            value = "Должность. ключевые слова",
            onValueChange = {},
            modifier = Modifier.clip(RoundedCornerShape(8.dp)),
            readOnly = true,
            enabled = false,
            textStyle = TextStyle(fontSize = 16.sp),
            colors = TextFieldDefaults.colors(
                disabledTextColor = Gray4,
                disabledContainerColor = Gray2,
                disabledIndicatorColor = Color.Transparent
            ),
            leadingIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "back", modifier = Modifier.size(30.dp), tint = Color.White)
                }
            })
        Image(
            painter = painterResource(R.drawable.filter),
            contentDescription = "filter",
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Gray2)
                .padding(14.dp)
        )
    }
}