package br.com.example.cardapiou.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnswerScreen(
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "antes de iniciarmos...",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.DarkGray,
                fontFamily = FontFamily.SansSerif
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "você tem algum tipo de intolerância\nalimentar",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.DarkGray,
                fontFamily = FontFamily.SansSerif
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp)
        )
        val selectedFoodIntolerance = remember {
            mutableStateOf(0)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedFoodIntolerance.value == 1,
                onClick = { selectedFoodIntolerance.value = 1 },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.DarkGray
                )
            )
            Text(
                text = "glúten", style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    fontFamily = FontFamily.SansSerif
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedFoodIntolerance.value == 2,
                onClick = { selectedFoodIntolerance.value = 2 },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.DarkGray
                )
            )
            Text(
                text = "Lactose", style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    fontFamily = FontFamily.SansSerif
                )
            )
        }

        Text(
            text = "Alergia a algum tipo de alimento?",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.DarkGray,
                fontFamily = FontFamily.SansSerif
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp)
        )
        val selectedFoodAllergy = remember {
            mutableStateOf(0)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedFoodAllergy.value == 1,
                onClick = { selectedFoodAllergy.value = 1 },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.DarkGray
                )
            )
            Text(
                text = "Frutos do Mar", style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    fontFamily = FontFamily.SansSerif
                )
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedFoodAllergy.value == 2,
                onClick = { selectedFoodAllergy.value = 2 },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color.DarkGray
                )
            )
            Text(
                text = "Porco", style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.DarkGray,
                    fontFamily = FontFamily.SansSerif
                )
            )
        }
        val buttonEnabled = remember {
            mutableStateOf(false)
        }
        buttonEnabled.value = selectedFoodAllergy.value != 0 && selectedFoodIntolerance.value != 0
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(60.dp)
                .padding(24.dp),
            shape = RoundedCornerShape(8.dp),
            onClick = {
                onClick()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray,
            ),
            enabled = buttonEnabled.value
        ) {
            Text(
                text = "Iniciar",
                style = TextStyle(fontSize = 18.sp),
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnswerPreview(){
    AnswerScreen{}
}