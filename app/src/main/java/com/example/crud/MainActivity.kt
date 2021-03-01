package com.example.crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.GridView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var noticias = ArrayList<Noticia>()

    var tit = arrayOf(
            "Eleccion CC 2021-2026",
            "Vacuna Anticovid-19",
            "Nuevo Normal GT",
            "Crisis Migratoria"
    )

    var desc = arrayOf(
            "CSU aplaza la designación de magistrados a la CC por acción de amparo",
            "Vacuna covid-19: mitos y datos sobre los efectos secundarios y su aplicación",
            "Niños vuelven a las escuelas mientras autoridades entregan alimentos y útiles escolares en medio de la pandemia por el coronavirus",
            "Rescatan a 147 migrantes guatemaltecos que viajaban en tráiler en Chiapas"
    )

    var img = arrayOf(
            "https://www.prensalibre.com/wp-content/uploads/2021/02/6b1a2443-7deb-453c-8579-33f0e26ccab5.jpg?quality=82&w=760&h=430&crop=1",
            "https://www.prensalibre.com/wp-content/uploads/2021/02/AFP_93V4HN.jpg?quality=82&w=760&h=430&crop=1",
            "https://www.prensalibre.com/wp-content/uploads/2021/02/escuela-reu.jpg?quality=82&w=760&h=430&crop=1",
            "https://www.prensalibre.com/wp-content/uploads/2021/02/Migrantes-1.jpeg?quality=82&w=760&h=430&crop=1"
    )

    var accion = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            val agregar: Button = findViewById(R.id.button)
            agregar.setOnClickListener { addItem() }
            for(i in tit.indices) {
                noticias.add(Noticia(tit[i], desc[i], img[i]))
            }
            renderGrid(noticias)
    }

    private fun addItem() {
        if(!accion) {
            accion = true
            val randomNum = Random.nextInt(0, 9)
            noticias.add(Noticia(tit[randomNum], desc[randomNum], img[randomNum]))
            renderGrid(noticias)
        }
    }

    private fun renderGrid(notilist: ArrayList<Noticia>) {
        val NoticiasAdaptador = NoticiasAdaptador(notilist, this)

        var grid_view = findViewById<GridView>(R.id.gridView)
        grid_view.adapter = NoticiasAdaptador

        grid_view.setOnItemLongClickListener { arg0, arg1, position, arg3 ->
            if(!accion) {
                accion = true
                val randomNum = Random.nextInt(0, 9)
                noticias.set(position, Noticia(tit[randomNum], desc[randomNum], img[randomNum]))
                renderGrid(noticias)
            }
            true
        }

        grid_view.setOnItemClickListener { arg0, arg1, position, arg3 ->
            if(!accion) {
                accion = true
                noticias.removeAt(position)
                renderGrid(noticias)
            }
            true
        }

        accion = false
    }
}