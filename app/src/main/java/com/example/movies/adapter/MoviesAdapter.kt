package com.example.movies.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.movies.R
import com.example.movies.model.datamodel.Movie

class MoviesAdapter (
    private var movies: MutableList<Movie>
    ) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
            val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_movie, parent, false)
            return MovieViewHolder(view)
        }

        override fun getItemCount(): Int = movies.size

        override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            holder.bind(this.movies[position])
        }

        fun appendMovies(movies: List<Movie>) {
            this.movies = movies.toMutableList()
            notifyItemRangeInserted(
                this.movies.size,
                movies.size - 1
            )
        }

        inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            private val poster: ImageView = itemView.findViewById(R.id.item_movie_poster)
            private val title: TextView = itemView.findViewById(R.id.movie_title)

            fun bind(movie: Movie) {
                Glide.with(itemView)
                    .load("https://image.tmdb.org/t/p/w342${movie.posterPath}")
                    .transform(CenterCrop())
                    .into(poster)
                title.setText(movie.title)
            }
        }
    }