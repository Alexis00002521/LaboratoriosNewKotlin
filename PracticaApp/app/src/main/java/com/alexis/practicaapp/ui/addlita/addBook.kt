package com.alexis.practicaapp.ui.addlita

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexis.practicaapp.ui.data.Libro
import com.alexis.practicaapp.ui.data.libros
import kotlinx.coroutines.delay


suspend fun fetchDataFromDatabase(): List<Libro> {
    delay(10000)
    return libros
}

@Composable
fun MyComposable() {
    val dataState: MutableState<List<Libro>?> = remember { mutableStateOf(null) }
    val snackbarHostState = remember { SnackbarHostState()}


    LaunchedEffect(Unit) {
        val data = fetchDataFromDatabase()
        dataState.value = data
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { Padding ->
        Column (modifier = Modifier
            .padding(Padding)){
            Button(
                onClick = {

                }
            )
            {
                Text("Get Data",textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()

                )
            }
            if (dataState.value == null) {
                Text("Cargando datos...")

            } else {
                dataState.value!!.forEach {
                    Card ( modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)

                    ){
                        Text(
                            text = " Nombre ${it.nombre}" , modifier = Modifier .padding(5.dp)
                        )
                        Text(
                            text = " Autor ${it.autor}" , modifier = Modifier .padding(5.dp)
                        )

                    }
                }
                LaunchedEffect(Unit) {
                    delay(500)
                    snackbarHostState.showSnackbar("Datos cargados corretamente")
                }

            }



        }
    }


}



@Preview(showBackground = true)
@Composable
fun preview (){
    MyComposable()
}


