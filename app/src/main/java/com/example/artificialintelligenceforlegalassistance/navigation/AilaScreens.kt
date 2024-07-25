package com.example.artificialintelligenceforlegalassistance.navigation

enum class AilaScreens {
    PreSplashScreen,
    SplashScreen,
    SplashScreen2,
    SplashScreen3,
    LoginScreen,
    CreateAccountScreen,
    HomeScreen,
    SearchScreen,
    SettingsScreen,
    StatsScreen,
    ChatScreen,
    RightDetailsScreen,
    FamilySubcategoriesScreen,
    RealEstateSubcategoriesScreen,
    LabourSubcategoriesScreen,
    ConsumerSubcategoriesScreen;
    companion object {
        fun fromRoute(route: String?): AilaScreens
        =when(route?.substringBefore("/")){
            PreSplashScreen.name -> PreSplashScreen
            SplashScreen.name -> SplashScreen
            SplashScreen2.name -> SplashScreen2
            SplashScreen3.name -> SplashScreen3
            LoginScreen.name -> LoginScreen
            CreateAccountScreen.name -> CreateAccountScreen
            HomeScreen.name -> HomeScreen
            SearchScreen.name -> SearchScreen
            SettingsScreen.name -> SettingsScreen
            StatsScreen.name -> StatsScreen
            ChatScreen.name -> ChatScreen
            RightDetailsScreen.name->RightDetailsScreen
            FamilySubcategoriesScreen.name->FamilySubcategoriesScreen
            RealEstateSubcategoriesScreen.name->RealEstateSubcategoriesScreen
            LabourSubcategoriesScreen.name->LabourSubcategoriesScreen
            ConsumerSubcategoriesScreen.name->ConsumerSubcategoriesScreen
                null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}