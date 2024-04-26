package com.alexis.practicaapp.ui.data

data class Libro(val nombre: String, val autor: String)

val libros = listOf(
    Libro("Luna de Pluton", "Dross"),
    Libro("El Exito", "TheGrefg")
)

val librosUnicos = libros.distinctBy { it.nombre }