package com.hasan.ahmed.belal.epic_reel.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.hasan.ahmed.belal.epic_reel.ViewMovieActivity
import com.hasan.ahmed.belal.epic_reel.databinding.AllMoviesBinding
import com.hasan.ahmed.belal.epic_reel.model.Movies


class AllMoviesAdapter(
    private val list: MutableList<Movies>
) : RecyclerView.Adapter<AllMoviesAdapter.ViewHolder>() {

    class ViewHolder(val binding: AllMoviesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = AllMoviesBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = list[position]
        holder.binding.movieTitle.text = movie.name
        holder.binding.movieImage.setImageResource(movie.image)
        holder.binding.movieRate.text = movie.rating

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ViewMovieActivity::class.java)
            intent.putExtra("movie", Gson().toJson(movie))
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size


}