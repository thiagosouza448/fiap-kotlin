package br.com.example.cardapiou

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.example.cardapiou.ui.screens.AnswerScreen
import br.com.example.cardapiou.ui.screens.LoadingScreen
import br.com.example.cardapiou.ui.screens.OnboardingScreen
import br.com.example.cardapiou.ui.theme.CardapiouTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            CardapiouTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = AppDestination.Loading.route
                    ) {
                        composable(AppDestination.Onboarding.route) {
                            OnboardingScreen {
                                navController.navigate(AppDestination.Answer.route)
                            }
                        }
                        composable(AppDestination.Answer.route) {
                            AnswerScreen {
                                navController.navigate(AppDestination.Loading.route)
                            }
                        }
                        composable(AppDestination.Loading.route) {
                            LoadingScreen {
                                navController.navigate(AppDestination.Onboarding.route)
                            }
                        }

                    }
                }
            }
        }
    }
}



