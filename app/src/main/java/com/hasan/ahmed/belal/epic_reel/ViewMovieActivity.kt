package com.hasan.ahmed.belal.epic_reel

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import com.hasan.ahmed.belal.epic_reel.databinding.ActivityViewMovieBinding
import com.hasan.ahmed.belal.epic_reel.model.Movies

class ViewMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityViewMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val json = intent.getStringExtra("movie")
        if (json != null) {
            val movie = Gson().fromJson(json, Movies::class.java)
            binding.movieImage.setImageResource(movie.image)
            binding.movieTitle.text = movie.name
            binding.date.text = movie.date
            binding.time.text = movie.time
            binding.description.text = movie.description
            binding.rate.text = movie.rating
        }




    }
}
