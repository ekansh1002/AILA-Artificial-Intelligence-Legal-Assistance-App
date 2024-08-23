package com.example.artificialintelligenceforlegalassistance.screens.home

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.artificialintelligenceforlegalassistance.R
import com.example.artificialintelligenceforlegalassistance.components.AilaAppBar
import com.example.artificialintelligenceforlegalassistance.components.AilaBottomAppBar
import com.example.artificialintelligenceforlegalassistance.components.AilaLogo
import com.example.artificialintelligenceforlegalassistance.components.CircleButtons
import com.example.artificialintelligenceforlegalassistance.components.LawChatWithAI
import com.example.artificialintelligenceforlegalassistance.navigation.AilaScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FamilySubcategoriesScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Scaffold(topBar = {
            AilaAppBar(
                title = "",
                icon = Icons.Default.ArrowBack,
                navController = navController,
                showProfile = false
            ) {
                navController.navigate(AilaScreens.HomeScreen.name)
            }
        }) {it->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AilaLogo()
                //Text(text = "AILA", color = Color.Black, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.size(15.dp))
                Text(text = "Ask Anything & get your consultation", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.size(15.dp))
                CircleButtons(image = R.drawable.img2, text = "Family Law")
                Spacer(modifier = Modifier.height(15.dp))
                Text(text = "Subcategories", color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(15.dp))
                FamilyScreen(navController)
                //AilaBottomAppBar(navController)
            }

        }
    }
}

@Composable
fun FamilyScreen(navController: NavController) {
    LazyColumn {
        item {
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                //Text(text = "Create Chat", color = Color.Black, fontSize = 16.sp)
                //Spacer(modifier = Modifier.height(1.dp))
                Row(
                    modifier = Modifier.width(300.dp),
                ) {
                    CircleButtons(image = R.drawable.img2, text = "Divorce"){
                        //navController.navigate(AilaScreens.FamilySubcategoriesScreen.name)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    CircleButtons(image = R.drawable.img1, text = "Child Custody"){
                        //navController.navigate(AilaScreens.RealEstateSubcategoriesScreen.name)
                    }
                }
                Row(
                    modifier = Modifier
                        .width(300.dp)
                        .padding(top = 10.dp)
                ) {
                    CircleButtons(image = R.drawable.labour, text = "Property Division"){
                        //navController.navigate(AilaScreens.LabourSubcategoriesScreen.name)
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    CircleButtons(image = R.drawable.consumer, text = "Alimony"){
                        //navController.navigate(AilaScreens.ConsumerSubcategoriesScreen.name)
                    }
                }
            }
        }
    }
}