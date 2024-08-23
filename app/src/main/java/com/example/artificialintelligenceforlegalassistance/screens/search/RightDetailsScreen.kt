package com.example.artificialintelligenceforlegalassistance.screens.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.artificialintelligenceforlegalassistance.data.MRight
import com.google.gson.Gson

@Composable
fun RightDetailsScreen(navController: NavController, article: String) {
    val context = LocalContext.current
    val jsonFileString = getJsonDataFromAsset(context, "COI.json")
    val gson = Gson()
    val listOfRights = gson.fromJson(jsonFileString, Array<MRight>::class.java).toList()

    val selectedRight = listOfRights.find { it.article == article }

    selectedRight?.let {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Text(
                text = it.title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = it.description,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
