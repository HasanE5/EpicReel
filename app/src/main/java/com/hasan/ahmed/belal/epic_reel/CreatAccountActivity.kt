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
import com.hasan.ahmed.belal.epic_reel.databinding.ActivityCreatAccountBinding
import com.hasan.ahmed.belal.epic_reel.model.User

class CreatAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreatAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCreatAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSgin.setOnClickListener {
            val name = binding.EditTextFullName.text.toString()
            val email = binding.EditTextEmail.text.toString()
            val pass = binding.EditTextPassword.text.toString()
            val confirmPass = binding.EditTextConfirmPassword.text.toString()

            if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Enter all fields", Toast.LENGTH_SHORT).show()
            } else if (pass != confirmPass) {
                binding.EditTextConfirmPassword.error = "Password does not match"
            } else if (pass.length < 8) {
                binding.EditTextPassword.error = "Password must be at least 8 characters"
            } else {
                val sharedPref = getSharedPreferences("AppPref", MODE_PRIVATE)
                val gson = Gson()
                val usersJson = sharedPref.getString("users", null)
                val users: MutableList<User> = if (usersJson == null) {
                    mutableListOf()
                } else {
                    gson.fromJson(usersJson, object : TypeToken<MutableList<User>>() {}.type)
                }

                if (users.any { it.email == email }) {
                    Toast.makeText(this, "This email is already registered", Toast.LENGTH_SHORT).show()
                } else {
                    val newUser = User(name, email,pass, false)
                    users.add(newUser)
                    val newUsersJson = gson.toJson(users)
                    val editor = sharedPref.edit()
                    editor.putString("users", newUsersJson)
                    editor.apply()

                    Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, SignUpActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
        binding.TextSignUp.setOnClickListener {
            finish()
        }
    }
}