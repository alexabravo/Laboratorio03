package com.example.crud

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

public class NoticiasAdaptador(var noticias: MutableList<Noticia>): RecyclerView.Adapter<NoticiasAdaptador.NoticiasHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiasHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_noticia, parent, false)
        return NoticiasHolder(view)
    }

    override fun onBindViewHolder(holder: NoticiasHolder, position: Int) {
        val actual: Noticia = this.noticias[position]
        holder.bind(actual)
    }

    override fun getItemCount(): Int {
        return this.noticias.size
    }

    class NoticiasHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(noticia: Noticia) = with(itemView){
            val txtTitulo: TextView = findViewById(R.id.txtTitulo)
            val imagen: ImageView = findViewById(R.id.imagen)

            txtTitulo.text = noticia.titulo

            Picasso.get().load(noticia.imagen).into(imagen);
        }
    }
}