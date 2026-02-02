package com.hasan.ahmed.belal.epic_reel

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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

        binding.bottomNav.selectedItemId = R.id.nav_search
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_search -> true
                R.id.nav_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.nav_profile -> {
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }

        val file = intent.getStringExtra("movies")

        val allMovies = Gson().fromJson(file, Array<Movies>::class.java).toMutableList()

        val searchMovies = mutableListOf<Movies>()
        val adapter = SearchAdapter(searchMovies)

        binding.btnSearch.setOnClickListener {
            val searchText = binding.etName.text.toString()

            for (movie in allMovies) {
                if (movie.name.contains(searchText, ignoreCase = true)) {
                    searchMovies.add(movie)
                }

                if (searchMovies.isEmpty()) {
                    binding.tvNotFound.visibility = View.VISIBLE
                }
            }
        }


    }
}