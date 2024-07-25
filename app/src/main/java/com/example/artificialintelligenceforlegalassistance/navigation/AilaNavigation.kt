package com.example.artificialintelligenceforlegalassistance.navigation



import PreSplashScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.artificialintelligenceforlegalassistance.screens.chat.ChatsScreen
import com.example.artificialintelligenceforlegalassistance.screens.home.ConsumerSubcategoriesScreen
import com.example.artificialintelligenceforlegalassistance.screens.home.FamilySubcategoriesScreen
import com.example.artificialintelligenceforlegalassistance.screens.home.HomeScreen
import com.example.artificialintelligenceforlegalassistance.screens.home.LabourSubcategoriesScreen
import com.example.artificialintelligenceforlegalassistance.screens.home.RealEstateSubcategoriesScreen
import com.example.artificialintelligenceforlegalassistance.screens.login.LoginScreen
import com.example.artificialintelligenceforlegalassistance.screens.search.RightDetailsScreen
import com.example.artificialintelligenceforlegalassistance.screens.search.SearchScreen
import com.example.artificialintelligenceforlegalassistance.screens.settings.SettingsScreen
import com.example.artificialintelligenceforlegalassistance.screens.splash.SplashScreen
import com.example.artificialintelligenceforlegalassistance.screens.splash.SplashScreen2
import com.example.artificialintelligenceforlegalassistance.screens.splash.SplashScreen3
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AilaNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = if (FirebaseAuth.getInstance().currentUser?.email.isNullOrEmpty())
            AilaScreens.SplashScreen.name
        else
            AilaScreens.PreSplashScreen.name){
        composable(AilaScreens.PreSplashScreen.name){
            PreSplashScreen(navController)
        }
        composable(AilaScreens.SplashScreen.name){
            SplashScreen(navController)
        }
        composable(AilaScreens.SplashScreen2.name){
            SplashScreen2(navController)
        }
        composable(AilaScreens.SplashScreen3.name){
            SplashScreen3(navController)
        }
        composable(AilaScreens.HomeScreen.name){
            HomeScreen(navController)
        }
        composable(AilaScreens.LoginScreen.name){
            LoginScreen(navController)
        }
        composable(AilaScreens.ChatScreen.name){
            ChatsScreen(navController,paddingValues = PaddingValues(16.dp))
        }
        composable(AilaScreens.SettingsScreen.name){
            SettingsScreen(navController)
        }
        composable(AilaScreens.SearchScreen.name){
            SearchScreen(navController)
        }
        composable(
            route = "${AilaScreens.RightDetailsScreen.name}/{article}",
            arguments = listOf(navArgument("article") { type = NavType.StringType })
        ) { backStackEntry ->
            val article = backStackEntry.arguments?.getString("article") ?: ""
            RightDetailsScreen(navController, article)
        }
        composable(AilaScreens.FamilySubcategoriesScreen.name){
            FamilySubcategoriesScreen(navController)
        }
        composable(AilaScreens.RealEstateSubcategoriesScreen.name){
            RealEstateSubcategoriesScreen(navController)
        }
        composable(AilaScreens.LabourSubcategoriesScreen.name){
            LabourSubcategoriesScreen(navController)
        }
        composable(AilaScreens.ConsumerSubcategoriesScreen.name){
            ConsumerSubcategoriesScreen(navController)
        }

    }
}




