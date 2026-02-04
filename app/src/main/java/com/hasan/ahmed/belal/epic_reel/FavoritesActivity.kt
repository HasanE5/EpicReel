    package com.hasan.ahmed.belal.epic_reel


    import android.content.Intent
    import android.os.Bundle
    import android.widget.Toast
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat
    import androidx.recyclerview.widget.LinearLayoutManager
    import com.google.gson.Gson
    import com.hasan.ahmed.belal.epic_reel.Adapter.FavoritesAdapter
    import com.hasan.ahmed.belal.epic_reel.Adapter.SearchAdapter
    import com.hasan.ahmed.belal.epic_reel.databinding.ActivityFavoritesBinding

    class FavoritesActivity : AppCompatActivity() {
        private lateinit var binding: ActivityFavoritesBinding
        private lateinit var favoriteItemsList: MutableList<FavoritesAdapter.FavoriteItem>
        private lateinit var favoritesAdapter: FavoritesAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            binding = ActivityFavoritesBinding.inflate(layoutInflater)
            setContentView(binding.root)

            ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }

            loadDummyData()
            favoritesAdapter = FavoritesAdapter(favoriteItemsList) { item, position ->
                favoriteItemsList.removeAt(position)
                favoritesAdapter.notifyItemRemoved(position)
                Toast.makeText(this, "Remove Successfully: ${item.title}", Toast.LENGTH_SHORT).show()
            }

            binding.favoritesRecyclerView.apply {
                adapter = favoritesAdapter
                layoutManager = LinearLayoutManager(this@FavoritesActivity)
            }

            binding.bottomNav.selectedItemId = R.id.nav_favorites
            binding.bottomNav.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_favorites -> true

                    R.id.nav_home -> {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        true
                    }

                    R.id.nav_search -> {
                        val intent = Intent(this, SearchActivity::class.java)
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
        }

        private fun loadDummyData() {
            favoriteItemsList = mutableListOf(
                FavoritesAdapter.FavoriteItem(1, R.drawable.ic_launcher_background, "Shadow Warriors", "Action, Adventure", "2h 5m"),
                FavoritesAdapter.FavoriteItem(2, R.drawable.ic_launcher_background, "Cyber Dreams", "Sci-Fi, Thriller", "1h 45m"),
                FavoritesAdapter.FavoriteItem(3, R.drawable.ic_launcher_background, "The Last Kingdom", "History, Drama", "2h 30m")
            )
        }
    }
