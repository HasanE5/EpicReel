package com.hasan.ahmed.belal.epic_reel.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hasan.ahmed.belal.epic_reel.Movie
import com.hasan.ahmed.belal.epic_reel.R

class MovieAdapter(
    private val movies: List<Movie>,
    private val onMovieClick: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val poster: ImageView = itemView.findViewById(R.id.ivMoviePoster)
        private val title: TextView = itemView.findViewById(R.id.tvMovieTitle)
        private val genre: TextView = itemView.findViewById(R.id.tvMovieGenre)
        private val duration: TextView = itemView.findViewById(R.id.tvMovieDuration)
        private val year: TextView = itemView.findViewById(R.id.tvMovieYear)
        private val rating: TextView = itemView.findViewById(R.id.tvRating)

        fun bind(movie: Movie) {
            title.text = movie.title
            duration.text = movie.duration
            rating.text = movie.rating.toString()
            poster.setImageResource(R.drawable.ic_movie_placeholder)

            itemView.setOnClickListener {
                onMovieClick(movie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size
}
