package com.example.artificialintelligenceforlegalassistance.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.artificialintelligenceforlegalassistance.R
import com.example.artificialintelligenceforlegalassistance.navigation.AilaScreens

@Preview
@Composable
fun SplashScreen3(navController: NavController = NavController(context = LocalContext.current)) {
    Surface(color = MaterialTheme.colorScheme.background) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterStart),
                //horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img1),
                    contentDescription = "Splash Screen Image",
                    modifier = Modifier
                        .padding(top = 16.dp, start =50.dp)
                        .size(300.dp)
                )

                Spacer(modifier = Modifier.padding(20.dp))

                Text(
                    text = stringResource(id = R.string.app_tagline3),
                    color = Color.Black,
                    modifier = Modifier.padding(start = 35.dp),
                    fontWeight = FontWeight.Bold
                )
            }

            Row(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Next",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {  navController.navigate(AilaScreens.LoginScreen.name) }
                )
            }
        }
    }
}