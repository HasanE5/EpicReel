package com.hasan.ahmed.belal.epic_reel

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
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
        val savedJson = sharePref.getString("savedUser", null)

        val gson = Gson()

        val savedUser = gson.fromJson(savedJson, User::class.java)

        binding.etName.setText(savedUser.fullName)
        binding.etEmail.setText(savedUser.email)


        binding.cancelButton.setOnClickListener {
            finish()
        }

        binding.saveButton.setOnClickListener {
            val fullName = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            if (fullName.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show()
            } else if (fullName == savedUser.fullName && email == savedUser.email) {
                Toast.makeText(this, "No changes made", Toast.LENGTH_SHORT).show()
            } else {
                val editor = sharePref.edit()
                savedUser.fullName = fullName
                savedUser.email = email
                val updatedUserJson = gson.toJson(savedUser)
                editor.putString("savedUser", updatedUserJson)
                editor.apply()
                Toast.makeText(this, "Profile updated successfully", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
