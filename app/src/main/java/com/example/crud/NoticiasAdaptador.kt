package com.example.crud

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

public class NoticiasAdaptador(private var noticias: MutableList<String>): RecyclerView.Adapter<NoticiasAdaptador.NoticiasHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticiasHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_noticia,parent,false)
        return NoticiasHolder(view)
    }

    override fun onBindViewHolder(holder: NoticiasHolder, position: Int) {
        val actual = this.noticias[position]
        holder.bind(actual)
    }

    override fun getItemCount(): Int {
       return this.noticias.size
    }

    class NoticiasHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(noticia: String) = with(itemView){
            val txtTitulo: TextView = findViewById(R.id.txtTitulo)
            txtTitulo.text = noticia
        }
    }
}