package com.hasan.ahmed.belal.epic_reel.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hasan.ahmed.belal.epic_reel.R

class GenreAdapter(private val genreList: List<Genre>) :
    RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {
    class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val icon: ImageView = itemView.findViewById(R.id.iv_genre_icon)
        val name: TextView = itemView.findViewById(R.id.tv_genre_name)
        val movieCount: TextView = itemView.findViewById(R.id.tv_movie_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_item_genr, parent, false)
        return GenreViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val genre = genreList[position]
        holder.icon.setImageResource(genre.iconResId)
        holder.name.text = genre.name
        holder.movieCount.text = "${genre.movieCount} movies"
    }

    override fun getItemCount() = genreList.size
}
data class Genre(
    val iconResId: Int,
    val name: String,
    val movieCount: Int
)