package com.example.crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private var noticias: MutableList<Noticia> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        noticias.add(Noticia("Prueba", "http://gtpreviene.researchmobile.co:3000/uploads/clh4lmsqs9xk5uah_juanito.jpeg"))

        val adaptador: NoticiasAdaptador = NoticiasAdaptador(noticias)

        val listaNoticias:RecyclerView = findViewById(R.id.listaNoticias)
        listaNoticias.layoutManager = LinearLayoutManager(this)
        listaNoticias.adapter = adaptador

    }
}