package com.example.crud

class Noticia {
    var titulo: String
    var imagen: String
    var descripcion: String

    constructor(titulo: String, descripcion: String, imagen: String) {
        this.titulo = titulo
        this.imagen = imagen
        this.descripcion = descripcion
    }
}