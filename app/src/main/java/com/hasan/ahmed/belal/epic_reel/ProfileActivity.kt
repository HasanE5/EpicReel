package com.hasan.ahmed.belal.epic_reel

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import com.hasan.ahmed.belal.epic_reel.databinding.ActivityProfileBinding
import com.hasan.ahmed.belal.epic_reel.model.Movies
import com.hasan.ahmed.belal.epic_reel.model.User

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharePref = getSharedPreferences("AppPref", MODE_PRIVATE)
        val currentUserJson =  sharePref.getString("currentUser", null)

        val moviesJson = intent.getStringExtra("movies")
        val allMovies = if (moviesJson.isNullOrEmpty() || moviesJson == "null") {
            mutableListOf<Movies>()
        } else {
            Gson().fromJson(moviesJson, Array<Movies>::class.java).toMutableList()
        }

        binding.btnEdit.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            intent.putExtra("currentUser", currentUserJson)
            startActivity(intent)

        }

        binding.bottomNav.selectedItemId = R.id.nav_profile
        binding.bottomNav.setOnItemSelectedListener { item ->
            val currentMoviesJson = Gson().toJson(allMovies)
            when (item.itemId) {
                R.id.nav_profile -> true
                R.id.nav_search -> {
                    val intent = Intent(this, SearchActivity::class.java)
                    intent.putExtra("movies", currentMoviesJson)
                    startActivity(intent)
                    true
                }
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
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

        binding.btnManageGenres.setOnClickListener {
            val inetnt = Intent(this, GenresActivity::class.java)
            startActivity(inetnt)
        }

        val gson = Gson()
        if (currentUserJson != null) {
            val currentUser = gson.fromJson(currentUserJson, User::class.java)
            binding.etName.setText(currentUser.fullName)
            binding.etEmail.setText(currentUser.email)
        }

        binding.btnLogout.setOnClickListener {
            val editor = sharePref.edit()
            editor.putBoolean("isLoggedIn", false)
            // Also clear the user data on logout
            editor.remove("currentUser")
            editor.apply()

            val intent = Intent(this, SignUpActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

    }
}
