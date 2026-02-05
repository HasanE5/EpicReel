package com.hasan.ahmed.belal.epic_reel

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.hasan.ahmed.belal.epic_reel.Adapter.SearchAdapter
import com.hasan.ahmed.belal.epic_reel.databinding.ActivitySearchBinding
import com.hasan.ahmed.belal.epic_reel.model.Movies

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val moviesJson = intent.getStringExtra("movies")
        val allMovies = if (moviesJson.isNullOrEmpty() || moviesJson == "null") {
            mutableListOf<Movies>()
        } else {
            Gson().fromJson(moviesJson, Array<Movies>::class.java).toMutableList()
        }

        binding.movies.layoutManager = GridLayoutManager(this, 2)

        binding.btnSearch.setOnClickListener {
            val searchText = binding.etName.text.toString().trim()

            if (searchText.isEmpty()) {
                binding.tvNotFound.text = "Please enter a movie name"
                binding.tvNotFound.visibility = View.VISIBLE
                binding.movies.adapter = null
                return@setOnClickListener
            }

            if (searchText.length <= 2) {
                binding.tvNotFound.text = "This movie not found"
                binding.tvNotFound.visibility = View.VISIBLE
                binding.movies.adapter = null
                return@setOnClickListener
            }

            val searchMovies = allMovies.filter {
                it.name.contains(searchText, ignoreCase = true)
            }

            if (searchMovies.isEmpty()) {
                binding.tvNotFound.text = "This movie not found"
                binding.tvNotFound.visibility = View.VISIBLE
                binding.movies.adapter = null
            } else {
                binding.tvNotFound.visibility = View.GONE
                val adapter = SearchAdapter(searchMovies.toMutableList())
                binding.movies.adapter = adapter
            }
        }

        binding.bottomNav.selectedItemId = R.id.nav_search
        binding.bottomNav.setOnItemSelectedListener { item ->
            val currentMoviesJson = Gson().toJson(allMovies)
            when (item.itemId) {
                R.id.nav_search -> true
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.nav_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    intent.putExtra("movies", currentMoviesJson)
                    startActivity(intent)
                    true
                }
                R.id.nav_favorites -> {
                    val intent = Intent(this, FavoritesActivity::class.java)
                    intent.putExtra("movies", currentMoviesJson)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}
