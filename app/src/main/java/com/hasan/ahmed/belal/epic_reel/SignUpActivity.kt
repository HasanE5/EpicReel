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
import com.hasan.ahmed.belal.epic_reel.databinding.ActivitySignUpBinding
import com.hasan.ahmed.belal.epic_reel.model.User

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharePref = getSharedPreferences("AppPref", MODE_PRIVATE)
        if (sharePref.getBoolean("isLoggedIn", false)) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            return
        }

        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.SignUp) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnSign.setOnClickListener {
            val email = binding.editText.text.toString()
            val password = binding.editTextEnterPassword.text.toString()

            val usersJson = sharePref.getString("users", null)
            val gson = Gson()
            val users: MutableList<User> = if (usersJson == null) {
                mutableListOf()
            } else {
                gson.fromJson(usersJson, object : TypeToken<MutableList<User>>() {}.type)
            }

            val user = users.find { it.email == email && it.password == password }

            if (user != null) {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                val editor = sharePref.edit()
                editor.putBoolean("isLoggedIn", true)

                editor.putString("currentUser", gson.toJson(user))
                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textSignUp.setOnClickListener {
            val intent = Intent(this, CreatAccountActivity::class.java)
            startActivity(intent)
        }
    }
}
