package com.easytech.devexperto_androiddesdecero.recyclerview_exercise.model.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.easytech.devexperto_androiddesdecero.R
import com.proyectos.angie.blockbuster.model.Movie

class MoviesAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    //Se va a llamar cuando el recyclerView requiera de una nueva vista para mostrar algo por pantalla, porque no existan vistas que podamos reciclar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater
                                .from(parent.context)
                                .inflate(R.layout.item_movie,parent,false) //Siempre attach to root a false, porque el recyclerView se encarga de gestionar el viewGroup de las vistas
       return ViewHolder(view)
    }
    //Se va a llamar cuando actualizamos los datos de una vista, independientemente si ésta se ha creado por primera vez o es reciclada (ha salido de la pantalla)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie= movies[position]
        holder.bind(movie)
    }
    //Numero de elementos que tiene la lista
    override fun getItemCount(): Int = movies.size


    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        private val cover=view.findViewById<ImageView>(R.id.movieCover)
        private val title=view.findViewById<TextView>(R.id.movieTitle)

        fun bind(movie: Movie) {
            title.text=movie.name
            Glide.with(cover.context).load(movie.cover).into(cover)
        }
    }

}