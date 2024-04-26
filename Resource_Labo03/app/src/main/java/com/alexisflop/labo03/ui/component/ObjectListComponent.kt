package com.alexisflop.labo03.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexisflop.labo03.model.ObjectClass
import com.alexisflop.labo03.viewmodel.DataViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ObjectListComponent(modifier: Modifier = Modifier) {

    val data: MutableState<MutableList<ObjectClass>> = remember {mutableStateOf(mutableListOf()) }
    val viewModel = DataViewModel()
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { 
            GlobalScope.launch(Dispatchers.IO) {
                Thread.sleep(1000)
                data.value = viewModel.getData()
            }
        }) {
            Text(text = "Get OBJECTS from database")
        }
        LazyColumn(
            modifier = Modifier
                .weight(9f)
                .fillMaxWidth()
                .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        ) {
            itemsIndexed(data.value){index, item ->
                Text(text = item.propertyOne)
                
            }
            /*TODO: Desplegar la lista que se encuentra en DummyData, haciendo uso de lo antes estudiado en Kotlin
            *  Ademas, cada objeto tiene que ser mapeado de manera especifica con los atirbutos que se especifican y un icono representativo*/
        }
    }
}

@Preview(showSystemUi = false)
@Composable
private fun ObjectListComponentPreview() {
    ObjectListComponent()
}