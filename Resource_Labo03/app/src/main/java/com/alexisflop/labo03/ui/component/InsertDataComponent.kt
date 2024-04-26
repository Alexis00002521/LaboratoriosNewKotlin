package com.alexisflop.labo03.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexisflop.labo03.model.ObjectClass
import com.alexisflop.labo03.viewmodel.DataViewModel

@Composable
fun InsertDataComponent(modifier: Modifier = Modifier) {
    val textFieldPropertyOne: MutableState<String> = remember { mutableStateOf("") }
    val textFieldPropertyTwo: MutableState<String> = remember { mutableStateOf("") }
    val viewModel = DataViewModel()

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(modifier = Modifier.padding(bottom = 5.dp), text = "Insert your data here")

        TextField(modifier = Modifier.padding(bottom = 5.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            value = textFieldPropertyOne.value,
            onValueChange = { textFieldPropertyOne.value = it },
            placeholder = {
                Text(text = "Insert first property here")
            })

        TextField(modifier = Modifier.padding(bottom = 5.dp), singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            value = textFieldPropertyTwo.value,
            onValueChange = { textFieldPropertyTwo.value = it },
            placeholder = {
                Text(text = "Insert second property here")
            })

        Button(
            modifier = Modifier.padding(bottom = 5.dp),
            onClick = { /*TODO*/
        val myList: MutableList<ObjectClass> = mutableListOf(
            ObjectClass("uno", "1"),
            ObjectClass("dos", "2"),
            ObjectClass("tres", "3"),
            ObjectClass("cuatro", "4")
        )
            viewModel.setData(myList)
        }) {
            Text(text = "Set data to object")
        }
    }
}

@Preview(showSystemUi = false)
@Composable
private fun InsertDataComponentPreview() {
    InsertDataComponent(modifier = Modifier)
}