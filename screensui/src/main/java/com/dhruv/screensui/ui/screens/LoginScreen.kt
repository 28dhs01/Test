package com.dhruv.screensui.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )
}

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    var username: String by rememberSaveable { mutableStateOf("") }
    var password: String by rememberSaveable { mutableStateOf("") }
    var passwordClickState: Boolean by rememberSaveable {
        mutableStateOf(false)
    }
    var accountBoxIconClickState: Boolean by rememberSaveable {
        mutableStateOf(false)
    }
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(100.dp)
                .clip(
                    RoundedCornerShape(20)
                )
                .background(MaterialTheme.colorScheme.primaryContainer),
            imageVector = Icons.Filled.Person,
            contentDescription = "imageProfile",
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )
        LoginTitle(text = "Login")
        LoginTitle(text = "Welcome back!")
        Spacer(modifier = Modifier.height(16.dp))
        LoginTextField(
            value = username,
            placeholderText = "Enter Your Username / Email",
            imageVector = Icons.Filled.AccountBox,
            trailingIconClickedOrNot = accountBoxIconClickState,
            trailingIconClicked = {}
        ) { updatedUsername ->
            username = updatedUsername
        }
        Spacer(modifier = Modifier.height(16.dp))
        LoginTextField(
            value = password,
            placeholderText = "Enter Your Password",
            imageVector = if( passwordClickState ) Icons.Filled.Info else Icons.Filled.Lock,
            trailingIconClickedOrNot = passwordClickState,
            trailingIconClicked = {
                passwordClickState = it
            },
            isPassword = true
        ) { updatedPassword ->
            password = updatedPassword
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Forgot Password",
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier.fillMaxWidth(0.9f),
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(text = "Don't have an account?", fontWeight = FontWeight.SemiBold)
            Text(
                text = "Sign up",
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        }

    }
}


@Composable
fun LoginTitle(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 32.sp
    )
}

@Composable
fun LoginTextField(
    value: String,
    placeholderText: String,
    imageVector: ImageVector,
    isPassword: Boolean = false,
    trailingIconClickedOrNot: Boolean = false,
    trailingIconClicked: (Boolean) -> Unit,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(0.9f),
        value = value,
        onValueChange = { changedValue ->
            onValueChange(changedValue)
        },
        singleLine = true,
        placeholder = {
            Text(text = placeholderText)
        },
        trailingIcon = {
            Icon(modifier = Modifier.clickable {
                trailingIconClicked(!trailingIconClickedOrNot)
            }, imageVector = imageVector, contentDescription = null)
        },
        visualTransformation = if (isPassword && !trailingIconClickedOrNot) PasswordVisualTransformation() else VisualTransformation.None,
        keyboardOptions = if( isPassword ) KeyboardOptions(keyboardType = KeyboardType.NumberPassword) else KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}