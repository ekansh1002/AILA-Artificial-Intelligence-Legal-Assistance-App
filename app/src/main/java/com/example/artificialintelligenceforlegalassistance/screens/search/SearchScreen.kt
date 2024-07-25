package com.example.artificialintelligenceforlegalassistance.screens.search

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.artificialintelligenceforlegalassistance.components.AilaAppBar
import com.example.artificialintelligenceforlegalassistance.components.InputField
import com.example.artificialintelligenceforlegalassistance.data.MRight
import com.example.artificialintelligenceforlegalassistance.navigation.AilaScreens
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavHostController) {
    var searchResult by remember { mutableStateOf<MRight?>(null) }
    var showFrequentSearches by remember { mutableStateOf(true) }

    val context = LocalContext.current
    val jsonFileString = getJsonDataFromAsset(context, "COI.json")
    val gson = Gson()
    val listOfRights = gson.fromJson(jsonFileString, Array<MRight>::class.java).toList()

    Scaffold(topBar = {
        AilaAppBar(
            title = "Search Your Right",
            icon = Icons.Default.ArrowBack,
            navController = navController,
            showProfile = false
        ) {
            navController.navigate(AilaScreens.HomeScreen.name)
        }
    }) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Column {
                SearchForm(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) { searchQuery ->
                    showFrequentSearches = false
                    val result = listOfRights.find { it.article == searchQuery }
                    searchResult = result
                }

                if (showFrequentSearches) {
                    Spacer(modifier = Modifier.height(13.dp))
                    Text(
                        text = "Most Frequent Searches...",
                        modifier = Modifier.padding(start = 16.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(13.dp))
                    RightList(navController = navController, listOfRights = listOfRights.take(5))
                } else {
                    searchResult?.let { selectedRight ->
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                                .verticalScroll(rememberScrollState())
                                .border(width = 1.dp, color = Color.Gray, shape = RectangleShape)
                                .padding(14.dp)
                        ) {
                            Text(
                                text = "Article ${selectedRight.article}",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(18.dp))
                            Text(
                                text = selectedRight.title,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = selectedRight.description,
                                style = MaterialTheme.typography.bodyLarge,
                                textAlign = TextAlign.Justify
                            )
                        }
                    } ?: run {
                        Card(
                            modifier = Modifier
                                .padding(16.dp)
                                .verticalScroll(rememberScrollState())
                                .border(width = 1.dp, color = Color.Gray, shape = RectangleShape)
                                .background(Color.White)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    text = "No Article Found",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun SearchForm(
    modifier: Modifier = Modifier,
    loading:Boolean = false,
    hint: String = "Search",
    onSearch:(String) -> Unit = {}
) {
    Column {
        val searchQueryState = rememberSaveable {
            mutableStateOf("")
        }
        val keyboardController = LocalSoftwareKeyboardController.current
        val valid = remember(searchQueryState.value) {
            searchQueryState.value.trim().isNotEmpty()
        }

        InputField(
            valueState = searchQueryState,
            labelId = "Search",
            enabled = true,
            onAction = KeyboardActions {
                if (!valid) return@KeyboardActions
                onSearch(searchQueryState.value.trim())
                searchQueryState.value = ""
                keyboardController?.hide()
            }
        )
    }
}

@Composable
fun RightList(navController: NavHostController, listOfRights: List<MRight>) {
    LazyColumn(
        Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(items = listOfRights) { right ->
            RightCard(right = right, navController = navController)
        }
    }
}

@Composable
fun RightCard(right: MRight, navController: NavHostController) {
    Card(
        modifier = Modifier
            .clickable { navController.navigate("${AilaScreens.RightDetailsScreen.name}/${right.article}") }
            .fillMaxWidth()
            .padding(5.dp),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = right.title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = right.description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    return try {
        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        String(buffer, Charsets.UTF_8)
    } catch (ex: Exception) {
        ex.printStackTrace()
        null
    }
}
