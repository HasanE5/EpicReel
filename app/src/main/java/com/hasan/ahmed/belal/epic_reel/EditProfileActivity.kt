package com.hasan.ahmed.belal.epic_reel

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hasan.ahmed.belal.epic_reel.databinding.ActivityEditProfileBinding
import com.hasan.ahmed.belal.epic_reel.model.User

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharePref = getSharedPreferences("AppPref", MODE_PRIVATE)
        val gson = Gson()

        val currentUserJson = sharePref.getString("currentUser", null)
        if (currentUserJson == null) {
            Toast.makeText(this, "Error: No user data found.", Toast.LENGTH_SHORT).show()
            finish()
            return
        }
        val currentUser = gson.fromJson(currentUserJson, User::class.java)

        binding.etName.setText(currentUser.fullName)
        binding.etEmail.setText(currentUser.email)

        binding.cancelButton.setOnClickListener {
            finish()
        }

        binding.saveButton.setOnClickListener {
            val newFullName = binding.etName.text.toString()
            val newEmail = binding.etEmail.text.toString()

            if (newFullName.isEmpty() || newEmail.isEmpty()) {
                Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            if (newFullName == currentUser.fullName && newEmail == currentUser.email) {
                Toast.makeText(this, "No changes were made.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val usersJson = sharePref.getString("users", null)
            val users: MutableList<User> = if (usersJson == null) mutableListOf() else {
                gson.fromJson(usersJson, object : TypeToken<MutableList<User>>() {}.type)
            }

            val userToUpdate = users.find { it.email == currentUser.email }
            if (userToUpdate != null) {
                userToUpdate.fullName = newFullName
                userToUpdate.email = newEmail

                currentUser.fullName = newFullName
                currentUser.email = newEmail

                val editor = sharePref.edit()
                editor.putString("users", gson.toJson(users))
                editor.putString("currentUser", gson.toJson(currentUser))
                editor.apply()

                Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Error: Could not update profile. Please log in again.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
