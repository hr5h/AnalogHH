package com.hrsh.analoghh.presentation.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hrsh.analoghh.R
import com.hrsh.analoghh.ui.theme.DarkBlue
import com.hrsh.analoghh.ui.theme.DarkGreen
import com.hrsh.analoghh.ui.theme.Gray1

@Composable
fun Offer(image: Int?, title: String, link: String, buttonText: String?) {
    val ctx = LocalContext.current
    Column(
        modifier = Modifier
            .height(160.dp)
            .width(160.dp)
            .clickable {
                val urlIntent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(link)
                )
                ctx.startActivity(urlIntent)
            }
            .clip(RoundedCornerShape(8.dp))
            .background(Gray1)
            .padding(10.dp)

    ) {
        image?.let {
            Image(
                painter = painterResource(id = image),
                contentDescription = title,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(if(image == R.drawable.near_vacancies) DarkBlue else DarkGreen)
                    .padding(5.dp),
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = title.trim(), fontSize = 14.sp, color = Color.White)
        buttonText?.let { Text(text = buttonText, fontSize = 14.sp, color = Color.Green) }
    }
}