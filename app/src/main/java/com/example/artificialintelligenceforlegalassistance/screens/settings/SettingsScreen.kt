package com.example.artificialintelligenceforlegalassistance.screens.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Logout
import androidx.compose.material.icons.rounded.ContactPage
import androidx.compose.material.icons.rounded.ContactPhone
import androidx.compose.material.icons.rounded.Key
import androidx.compose.material.icons.rounded.PrivacyTip
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.artificialintelligenceforlegalassistance.components.AilaAppBar
import com.example.artificialintelligenceforlegalassistance.components.AilaBottomAppBar
import com.example.artificialintelligenceforlegalassistance.navigation.AilaScreens
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {

    Column(verticalArrangement = Arrangement.Top) {
        AilaAppBar(title = "Settings", showProfile = true, navController = navController )

        Row(modifier = Modifier
            .padding(start = 30.dp, bottom = 15.dp, top = 15.dp)
            .clickable { }) {
            Icon(imageVector = Icons.Rounded.Key, contentDescription = "logout", tint = Color(0xFF92CBDF))
            Spacer(modifier = Modifier.padding(start = 60.dp))
            Text(text = "Account Edit")
        }
        Divider(modifier = Modifier
            .height(2.dp)
            .padding(start = 20.dp, end = 20.dp))
        Row(modifier = Modifier
            .padding(start = 30.dp, bottom = 15.dp, top = 15.dp)
            .clickable { }) {
            Icon(imageVector = Icons.Rounded.PrivacyTip, contentDescription = "logout", tint = Color(0xFF92CBDF))
            Spacer(modifier = Modifier.padding(start = 60.dp))
            Text(text = "Privacy Policy")
        }
        Divider(modifier = Modifier
            .height(2.dp)
            .padding(start = 20.dp, end = 20.dp))
        Row(modifier = Modifier
            .padding(start = 30.dp, bottom = 15.dp, top = 15.dp)
            .clickable {  }) {
            Icon(imageVector = Icons.Rounded.ContactPage, contentDescription = "logout", tint = Color(0xFF92CBDF))
            Spacer(modifier = Modifier.padding(start = 60.dp))
            Text(text = "Terms Of Usage")
        }
        Divider(modifier = Modifier
            .height(2.dp)
            .padding(start = 20.dp, end = 20.dp))
        Row(modifier = Modifier
            .padding(start = 30.dp, bottom = 15.dp, top = 15.dp)
            .clickable { }) {
            Icon(imageVector = Icons.Rounded.ContactPhone, contentDescription = "logout", tint = Color(0xFF92CBDF))
            Spacer(modifier = Modifier.padding(start = 60.dp))
            Text(text = "Contact Us")
        }
        Divider(modifier = Modifier
            .height(2.dp)
            .padding(start = 20.dp, end = 20.dp))
        Row(modifier = Modifier
            .padding(start = 30.dp, bottom = 15.dp, top = 15.dp)
            .clickable { FirebaseAuth.getInstance().signOut().run{
                navController.navigate(AilaScreens.LoginScreen.name)
            }}) {

            Icon(imageVector = Icons.Default.Logout, contentDescription = "logout", tint = Color(0xFF92CBDF))
            Spacer(modifier = Modifier.padding(start = 60.dp))
            Text(text = "Log Out")
        }
    }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom) {
            AilaBottomAppBar(navController)
    }
}


