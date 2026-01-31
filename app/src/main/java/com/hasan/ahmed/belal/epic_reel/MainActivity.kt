package com.hasan.ahmed.belal.epic_reel

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.hasan.ahmed.belal.epic_reel.Adapter.MoviesAdapter
import com.hasan.ahmed.belal.epic_reel.Adapter.ReleasesMoviesAdapter
import com.hasan.ahmed.belal.epic_reel.Adapter.TrendMoviesAdapter
import com.hasan.ahmed.belal.epic_reel.databinding.ActivityMainBinding
import com.hasan.ahmed.belal.epic_reel.model.Movies

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.selectedItemId = R.id.nav_home
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
//                R.id.nav_search -> {
//                    startActivity(Intent(this, SearchActivity::class.java)) true
//                }

                R.id.nav_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }

        val movies = mutableListOf<Movies>()
        movies.add(
            Movies(
                "Interstellar",
                R.drawable.interstellar,
                "2014",
                "2h 18m",
                "4.9",
                "Interstellar is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter."
            )
        )
        movies.add(
            Movies(
                "The Dark knight",
                R.drawable.the_dark_knight,
                "2008",
                "2h 18m",
                "4.8",
                "The Dark knight is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter"
            )
        )
        val adapter = MoviesAdapter(movies)
        binding.posters.adapter = adapter
        binding.posters.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val trendingMovies = mutableListOf<Movies>()

        trendingMovies.add(
            Movies(
                "Interstellar",
                R.drawable.interstellar_poster,
                "2014",
                "2h 18m",
                "4.9",
                "Interstellar is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter."
            )
        )
        trendingMovies.add(
            Movies(
                "The Dark knight",
                R.drawable.the_dark_knight_poster,
                "2008",
                "2h 18m",
                "4.8",
                "The Dark knight is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter"
            )
        )
        trendingMovies.add(
            Movies(
                "Interstellar",
                R.drawable.interstellar_poster,
                "2014",
                "2h 18m",
                "4.9",
                "Interstellar is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter."
            )
        )
        trendingMovies.add(
            Movies(
                "The Dark knight",
                R.drawable.the_dark_knight_poster,
                "2008",
                "2h 18m",
                "4.8",
                "The Dark knight is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter"
            )
        )
        trendingMovies.add(
            Movies(
                "Interstellar",
                R.drawable.interstellar_poster,
                "2014",
                "2h 18m",
                "4.9",
                "Interstellar is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter."
            )
        )
        trendingMovies.add(
            Movies(
                "The Dark knight",
                R.drawable.the_dark_knight_poster,
                "2008",
                "2h 18m",
                "4.8",
                "The Dark knight is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter"
            )
        )


        val trendingMoviesAdapter = TrendMoviesAdapter(trendingMovies)
        binding.trendingMovies.adapter = trendingMoviesAdapter
        binding.trendingMovies.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val releasesMovies = mutableListOf<Movies>()
        releasesMovies.add(
            Movies(
                "The Dark knight",
                R.drawable.the_dark_knight_poster,
                "2008",
                "2h 18m",
                "4.8",
                "The Dark knight is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter"
            )
        )

        releasesMovies.add(
            Movies(
                "Interstellar",
                R.drawable.interstellar_poster,
                "2014",
                "2h 18m",
                "4.9",
                "Interstellar is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter."
            )
        )
        releasesMovies.add(
            Movies(
                "The Dark knight",
                R.drawable.the_dark_knight_poster,
                "2008",
                "2h 18m",
                "4.8",
                "The Dark knight is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter"
            )
        )

        releasesMovies.add(
            Movies(
                "Interstellar",
                R.drawable.interstellar_poster,
                "2014",
                "2h 18m",
                "4.9",
                "Interstellar is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter."
            )
        )
        releasesMovies.add(
            Movies(
                "The Dark knight",
                R.drawable.the_dark_knight_poster,
                "2008",
                "2h 18m",
                "4.8",
                "The Dark knight is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter"
            )
        )

        releasesMovies.add(
            Movies(
                "Interstellar",
                R.drawable.interstellar_poster,
                "2014",
                "2h 18m",
                "4.9",
                "Interstellar is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter."
            )
        )

        val releasesMoviesAdapter = ReleasesMoviesAdapter(releasesMovies)
        binding.releasesMovies.adapter = releasesMoviesAdapter
        binding.releasesMovies.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


    }
}