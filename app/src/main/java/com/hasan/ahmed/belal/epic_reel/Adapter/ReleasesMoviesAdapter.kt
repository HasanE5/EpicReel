package com.hasan.ahmed.belal.epic_reel.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hasan.ahmed.belal.epic_reel.databinding.ReleasesMoviesBinding
import com.hasan.ahmed.belal.epic_reel.databinding.TrendingMoviesBinding
import com.hasan.ahmed.belal.epic_reel.model.Movies



class ReleasesMoviesAdapter(
    private val list: MutableList<Movies>
) : RecyclerView.Adapter<ReleasesMoviesAdapter.ViewHolder>() {

    class ViewHolder(val binding: ReleasesMoviesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ReleasesMoviesBinding.inflate(
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
    }

    override fun getItemCount(): Int = list.size
}