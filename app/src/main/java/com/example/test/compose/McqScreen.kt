package com.example.test.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Option(
    val name: String,
    var selected: Boolean,
    val id: Int
)

val response = listOf("India", "Australia", "England", "South Africa")

fun getList(): List<Option> {
    val optionsList = mutableListOf<Option>()
    response.forEachIndexed { index, name ->
        optionsList.add(Option(name = name, selected = false, id = index))
    }
    return optionsList
}

@Composable
fun McqScreen(modifier: Modifier = Modifier, optionsList: List<Option>) {

    val options = remember {
        mutableStateOf(optionsList)
    }
    Column(modifier = modifier.fillMaxSize()) {
        Question(
            Modifier
                .fillMaxWidth()
                .padding(8.dp))
        Options(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .weight(1f),
            options = options.value
        ) { selectedId ->
            options.value = options.value.map {
                if (it.id == selectedId) it.copy(selected = !it.selected) else it.copy(selected = false)
            }
        }
        SubmitButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            enabled = options.value.any { it.selected })
    }
}

@Composable
fun SubmitButton(modifier: Modifier = Modifier, enabled: Boolean) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        Button(modifier = Modifier.weight(0.45f), shape = MaterialTheme.shapes.extraLarge, onClick = {}) {
            Text(text = "Cancel")
        }
        Spacer(modifier = Modifier.weight(0.10f))
        Button(modifier = Modifier.weight(0.45f), shape = MaterialTheme.shapes.extraLarge, onClick = {}, enabled = enabled) {
            Text(text = "Submit")
        }
    }
}

@Composable
fun Options(modifier: Modifier, options: List<Option>, selectedOption: (Int) -> Unit) {
    Column(
        modifier = modifier
    ) {
        options.forEach {option->
            SingleOption(optionText = option.name, selected = option.selected) {
                val anySelected = options.any {
                    it.selected
                }
                selectedOption(option.id)
            }
        }
    }
}

@Composable
fun SingleOption(
    modifier: Modifier = Modifier,
    optionText: String,
    selected: Boolean,
    onSelected: () -> Unit
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(modifier = Modifier.weight(1f), text = optionText)
        RadioButton(selected = selected, onClick = { onSelected() })
    }
}

@Composable
fun Question(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "Which country has won the 2011 Cricket World Cup?",
        color = MaterialTheme.colorScheme.error
    )
}
