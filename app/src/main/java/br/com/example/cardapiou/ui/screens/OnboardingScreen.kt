package br.com.example.cardapiou.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(
    onClick: () -> Unit
) {
    val colorPrimary = Color(0xFF7F03FC)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "CARDAPI-OU\nOnboarding",
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.DarkGray,
                fontFamily = FontFamily.SansSerif
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            textAlign = TextAlign.Center
        )
        val nameInput = remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 24.dp, end = 24.dp),
            label = {
                Text(text = "Digite seu nome", color = Color.DarkGray)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            value = nameInput.value,
            onValueChange = { name ->
                nameInput.value = name
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Gray,
                focusedBorderColor = Color.DarkGray,
                textColor = Color.DarkGray
            )
        )
        val emailInput = remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 24.dp, end = 24.dp),
            label = {
                Text(text = "Digite seu email", color = Color.DarkGray)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            value = emailInput.value,
            onValueChange = { email ->
                emailInput.value = email
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Gray,
                focusedBorderColor = Color.DarkGray,
                textColor = Color.DarkGray
            )
        )
        val phoneInput = remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 24.dp, end = 24.dp),
            label = {
                Text(text = "Telefone", color = Color.DarkGray)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            value = phoneInput.value,
            onValueChange = { phone ->
                phoneInput.value = phone
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Gray,
                focusedBorderColor = Color.DarkGray,
                textColor = Color.DarkGray
            )
        )
        val nascimentoInput = remember {
            mutableStateOf("")
        }
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 24.dp, end = 24.dp),
            label = {
                Text(text = "Nascimento", color = Color.DarkGray)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            value = nascimentoInput.value,
            onValueChange = { nascimento ->
                nascimentoInput.value = nascimento
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = Color.Gray,
                focusedBorderColor = Color.DarkGray,
                textColor = Color.DarkGray
            )
        )
        val buttonEnabled = remember {
            mutableStateOf(false)
        }
        buttonEnabled.value =
            nascimentoInput.value.length > 3 &&
                    nameInput.value.length > 3 &&
                    emailInput.value.length > 3 &&
                    phoneInput.value.length > 3
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
                containerColor = colorPrimary,
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

@Preview(showSystemUi = false, showBackground = true)
@Composable
fun OnboardingPreview() {
    OnboardingScreen{}

}