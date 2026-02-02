package com.hasan.ahmed.belal.epic_reel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hasan.ahmed.belal.epic_reel.databinding.ActivityFavoritesBinding
import com.hasan.ahmed.belal.epic_reel.databinding.ActivityGenresBinding

class GenresActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGenresBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityGenresBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        val genreList = listOf(
            Genre(R.drawable.ic_launcher_background, "Action", 120),
            Genre(R.drawable.ic_launcher_background, "Comedy", 85),
            Genre(R.drawable.ic_launcher_background, "Horror", 60),
            Genre(R.drawable.ic_launcher_background, "Drama", 150),
            Genre(R.drawable.ic_launcher_background, "Sci-Fi", 95),
            Genre(R.drawable.ic_launcher_background, "Romance", 70)
        )
        val genreAdapter = GenreAdapter(genreList)

        binding.rvGenres.adapter = genreAdapter

    }
}