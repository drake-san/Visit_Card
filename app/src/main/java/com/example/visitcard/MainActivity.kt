package com.example.visitcard


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitcard.ui.theme.VisitCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisitCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.primarySurface
                ) {
                    VisitCard()
                }
            }
        }
    }
}

@Composable
fun VisitCard(
    name: String = "Drake San ☁",
    phoneNumber: String = "+237 620 21 19 18",
    mail: String = "gouetfredericarthur@gmail.com",
    location: String = "Yaounde, Cameroon"
)
{
    val drakeLogo = painterResource(id = R.drawable.gmail_pic)
    val androidLogo = painterResource(id = R.drawable.android_logo)

    Column(
       modifier = Modifier
           .fillMaxHeight()
           .fillMaxWidth()
           .background(Color(0xFF262539))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = drakeLogo,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .clip(CircleShape)
                    .size(102.dp, 100.dp)
            )
            Text(
                text = name,
                fontSize = 32.sp,
                color = Color.White
            )

        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 60.dp)
        ) {
            Row(horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = androidLogo,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(133.dp,120.dp)
                )
                Text(
                    text = "Developer",
                    fontSize = 24.sp,
                    color = Color.White
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 60.dp)
        ) {
            VisitCardDivider(Icons.Filled.Phone, phoneNumber)
            VisitCardDivider(Icons.Filled.Email, mail)
            VisitCardDivider(Icons.Filled.LocationOn, location)
        }
    }
}

@Composable
fun VisitCardDivider(icon: ImageVector, text: String) {
    val dividerColor = Color(0xFF817676)

    Divider(
        thickness = 3.dp,
        color = dividerColor,
        modifier = Modifier.padding(horizontal = 35.dp)
    )
    Row(modifier = Modifier.padding(vertical = 20.dp)) {
        Icon(
            icon,
            contentDescription = null,
            tint = Color(0xFF3DDC84),
            modifier = Modifier
                .size(25.dp)
        )
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 35.dp)
        )
    }
}

@Preview
@Composable
fun VisitCardPreview() {
    VisitCardTheme {
        VisitCard()
    }
}