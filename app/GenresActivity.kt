package com.example.epicreel

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GenresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_genres)

        val rvMovies = findViewById<RecyclerView>(R.id.rvMovies)
        rvMovies.layoutManager = GridLayoutManager(this, 2)

        val movies = listOf(
            Movie(1, "Inception", "2h 28m", 4.8),
            Movie(2, "The Dark Knight", "2h 32m", 4.9),
            Movie(3, "Interstellar", "2h 49m", 4.7),
            Movie(4, "Inception", "3h 10m", 3.9),
            Movie(4, "The Dark Knight", "1h 15m", 2.7),
            Movie(4, "Titanic", "2h 20m", 4.5),
            Movie(4, "The Dark Knight", "1h 15m", 2.7),
            Movie(4, "Titanic", "2h 20m", 4.5)



        )

        val movieAdapter = MovieAdapter(movies) { movie ->
            Toast.makeText(this, "اخترت: ${movie.title}", Toast.LENGTH_SHORT).show()
        }

        rvMovies.adapter = movieAdapter
    }
}