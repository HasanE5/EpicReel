package com.hasan.ahmed.belal.epic_reel

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.hasan.ahmed.belal.epic_reel.Adapter.AllMoviesAdapter
import com.hasan.ahmed.belal.epic_reel.Adapter.MoviesAdapter
import com.hasan.ahmed.belal.epic_reel.Adapter.ReleasesMoviesAdapter
import com.hasan.ahmed.belal.epic_reel.Adapter.TrendMoviesAdapter
import com.hasan.ahmed.belal.epic_reel.databinding.ActivityMainBinding
import com.hasan.ahmed.belal.epic_reel.model.Movies
import com.hasan.ahmed.belal.epic_reel.model.User
import java.io.Serial

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val allMovies = mutableListOf<Movies>()


        allMovies.add(
            Movies(
                "Avengers Endgame",
                R.drawable.avengers_endgame_poster,
                "2019",
                "3h 1m",
                "4.6",
                "Avengers: Endgame is about the heroes fighting Thanos. They bring back their friends, and Iron Man saves everyone."
            )
        )

        allMovies.add(
            Movies(
                "Star Wars VI",
                R.drawable.star_wars_episode_vi_poster,
                "1983",
                "2h 12m",
                "4.2",
                "Return of the Jedi is about the heroes stopping the evil Empire. Luke faces Darth Vader and the Emperor, while the Rebels destroy the new Death Star. In the end, Vader saves Luke and the galaxy is free."
            )
        )
        allMovies.add(
            Movies(
                "Star Wars III",
                R.drawable.star_wars_episode_iii_poster,
                "2005",
                "2h 20m",
                "3.3",
                "Star Wars: Episode III – Revenge of the Sith is about Anakin becoming Darth Vader and the Jedi being destroyed."
            )
        )
        allMovies.add(
            Movies(
                "Avengers Age Of Ultron",
                R.drawable.avengers_age_of_ultron_poster,
                "2015",
                "2h 21m",
                "3.7",
                "Avengers: Age of Ultron is about the heroes fighting a powerful robot named Ultron. Ultron wants to destroy humanity, so the Avengers join forces to stop him and save the world."
            )
        )
        allMovies.add(
            Movies(
                "Avengers Infinity War",
                R.drawable.avengers_infinity_war_poster,
                "2018",
                "2h 29m",
                "4.2",
                "Avengers: Infinity War is about the heroes trying to stop Thanos. He collects the Infinity Stones to wipe out half of all life. In the end, Thanos wins and many heroes disappear."
            )
        )

        allMovies.add(
            Movies(
                "Interstellar",
                R.drawable.interstellar,
                "2014",
                "2h 18m",
                "4.9",
                "Interstellar is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter."
            )
        )
        allMovies.add(
            Movies(
                "The Dark knight",
                R.drawable.the_dark_knight,
                "2008",
                "2h 18m",
                "4.8",
                "The Dark knight is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter"
            )
        )

        allMovies.add(
            Movies(
                "Scream 7",
                R.drawable.scream7_poster,
                "2026",
                "1h 54m",
                "NEW",
                "Scream 7: is about a new Ghostface killer who goes after Sidney Prescott’s daughter."
            )
        )

        allMovies.add(
            Movies(
                "Super Mario Galaxy",
                R.drawable.super_mario_poster,
                "2026",
                "unknown",
                "NEW",
                "Super Mario Galaxy",
            )
        )
        allMovies.add(
            Movies(
                "Zootopia 2",
                R.drawable.zootopia2_poster,
                "2025",
                "1h 48m",
                "3.4",
                "Zootopia 2 is about Judy and Nick stopping a snake villain in the city.",
            )
        )



        allMovies.add(
            Movies(
                "Odyssey",
                R.drawable.odyssey_poster,
                "2026",
                "unknown",
                "NEW",
                "The Odyssey (2026) is about Odysseus trying to get home after war, facing many dangers.",
            )
        )


        val adapterAll = AllMoviesAdapter(allMovies)
        binding.allMovies.adapter = adapterAll
        binding.allMovies.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val intent = Intent(this, SearchActivity::class.java)


        val bigPosterMovies = mutableListOf<Movies>()
        bigPosterMovies.add(
            Movies(
                "Avengers",
                R.drawable.avengers_endgame_poster,
                "2019",
                "3h 1m",
                "4.6",
                "Avengers: Endgame is about the heroes fighting Thanos. They bring back their friends, and Iron Man saves everyone."
            )
        )
        bigPosterMovies.add(
            Movies(
                "The Dark Knight",
                R.drawable.the_dark_knight,
                "2008",
                "2h 32m",
                "4.7",
                "The Dark Knight is about Batman fighting the Joker, who wants to bring chaos to Gotham City."
            )
        )
        val bigPosterMoviesAdapter = MoviesAdapter(bigPosterMovies)
        binding.posters.adapter = bigPosterMoviesAdapter
        binding.posters.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val trendingMovies = mutableListOf<Movies>()

        trendingMovies.add(
            Movies(
                "Avengers Endgame",
                R.drawable.avengers_endgame_poster,
                "2019",
                "3h 1m",
                "4.6",
                "Avengers: Endgame is about the heroes fighting Thanos. They bring back their friends, and Iron Man saves everyone."
            )
        )

        trendingMovies.add(
            Movies(
                "Star Wars VI",
                R.drawable.star_wars_episode_vi_poster,
                "1983",
                "2h 12m",
                "4.2",
                "Return of the Jedi is about the heroes stopping the evil Empire. Luke faces Darth Vader and the Emperor, while the Rebels destroy the new Death Star. In the end, Vader saves Luke and the galaxy is free."
            )
        )
        trendingMovies.add(
            Movies(
                "Star Wars III",
                R.drawable.star_wars_episode_iii_poster,
                "2005",
                "2h 20m",
                "3.3",
                "Star Wars: Episode III – Revenge of the Sith is about Anakin becoming Darth Vader and the Jedi being destroyed."
            )
        )
        trendingMovies.add(
            Movies(
                "Avengers Age Of Ultron",
                R.drawable.avengers_age_of_ultron_poster,
                "2015",
                "2h 21m",
                "3.7",
                "Avengers: Age of Ultron is about the heroes fighting a powerful robot named Ultron. Ultron wants to destroy humanity, so the Avengers join forces to stop him and save the world."
            )
        )
        trendingMovies.add(
            Movies(
                "Avengers Infinity War",
                R.drawable.avengers_infinity_war_poster,
                "2018",
                "2h 29m",
                "4.2",
                "Avengers: Infinity War is about the heroes trying to stop Thanos. He collects the Infinity Stones to wipe out half of all life. In the end, Thanos wins and many heroes disappear."
            )
        )

        trendingMovies.add(
            Movies(
                "Interstellar",
                R.drawable.interstellar,
                "2014",
                "2h 18m",
                "4.9",
                "Interstellar is about astronauts searching for a new home for humanity while a father tries to reunite with his daughter."
            )
        )
        trendingMovies.add(
            Movies(
                "The Dark knight",
                R.drawable.the_dark_knight,
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
                "Scream 7",
                R.drawable.scream7_poster,
                "2026",
                "1h 54m",
                "NEW",
                "Scream 7: is about a new Ghostface killer who goes after Sidney Prescott’s daughter."
            )
        )

        releasesMovies.add(
            Movies(
                "Super Mario Galaxy",
                R.drawable.super_mario_poster,
                "2026",
                "NEW",
                "NEW",
                "Super Mario Galaxy",
            )
        )
        releasesMovies.add(
            Movies(
                "Zootopia 2",
                R.drawable.zootopia2_poster,
                "2025",
                "1h 48m",
                "3.4",
                "Zootopia 2 is about Judy and Nick stopping a snake villain in the city.",
            )
        )
        releasesMovies.add(
            Movies(
                "Odyssey",
                R.drawable.odyssey_poster,
                "2026",
                "NEW",
                "0.0",
                "The Odyssey (2026) is about Odysseus trying to get home after war, facing many dangers.",
            )
        )

        val releasesMoviesAdapter = ReleasesMoviesAdapter(releasesMovies)
        binding.releasesMovies.adapter = releasesMoviesAdapter
        binding.releasesMovies.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)



        binding.bottomNav.selectedItemId = R.id.nav_home
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_search -> {
                    val allMovies = Gson().toJson(allMovies)
                    val intent = Intent(this, SearchActivity::class.java)
                    intent.putExtra("movies", allMovies)
                    startActivity(intent)
                    true
                }

                R.id.nav_profile -> {
                    val allMovies = Gson().toJson(allMovies)
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("movies", allMovies)
                    startActivity(intent)
                    true
                }

                R.id.nav_favorites -> {
                    val allMovies = Gson().toJson(allMovies)
                    val intent = Intent(this, FavoritesActivity::class.java)
                    intent.putExtra("movies", allMovies)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }
}