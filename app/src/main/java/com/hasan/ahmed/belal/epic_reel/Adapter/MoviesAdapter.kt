package com.hasan.ahmed.belal.epic_reel.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.hasan.ahmed.belal.epic_reel.ViewMovieActivity
import com.hasan.ahmed.belal.epic_reel.model.Movies
import com.hasan.ahmed.belal.epic_reel.databinding.BigPosterBinding


class MoviesAdapter(
    private val list: MutableList<Movies>
) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    class ViewHolder(val binding: BigPosterBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BigPosterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = list[position]


        holder.binding.title.text = movie.name
        holder.binding.imagePoster.setImageResource(movie.image)
        holder.binding.rate.text = movie.rating
        holder.binding.date.text = movie.date
        holder.binding.time.text = movie.time
        holder.binding.description.text = movie.description

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ViewMovieActivity::class.java)
            intent.putExtra("movie", Gson().toJson(movie))
            context.startActivity(intent)
        }
    }



    override fun getItemCount(): Int = list.size
}