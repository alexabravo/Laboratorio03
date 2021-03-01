package com.example.crud

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NoticiasAdaptador(var noti: ArrayList<Noticia>, var contexto: Context): BaseAdapter(){

    var diseño = contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return noti.size
    }

    override fun getItem(p0: Int): Any {
        return noti[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var vista = p1
        if(vista == null) {
            vista = diseño.inflate(R.layout.item_noticia, p2,false)
        }

        var vistatit = vista?.findViewById<TextView>(R.id.txtTitulo)
        var vistadesc = vista?.findViewById<TextView>(R.id.txtDescripcion)
        var vistaimg = vista?.findViewById<ImageView>(R.id.imagen)

        vistatit?.text = noti[p0].titulo
        vistadesc?.text = noti[p0].descripcion
        Picasso.get().load(noti[p0].imagen!!).into(vistaimg)

        return vista!!
    }
}