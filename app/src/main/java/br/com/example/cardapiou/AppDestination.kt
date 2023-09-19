package br.com.example.cardapiou

sealed class AppDestination(val route: String) {
    object Onboarding: AppDestination("onboarding")
    object Answer: AppDestination("answer")
    object Loading: AppDestination("loading")
}
