package com.hasan.ahmed.belal.epic_reel

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
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

        val savedJson = sharePref.getString("savedUser", null)
        val gson = Gson()

        binding.btnSign.setOnClickListener {
            val email = binding.editText.text.toString()
            val password = binding.editTextEnterPassword.text.toString()

            if (savedJson != null) {
                val savedUser = gson.fromJson(savedJson, User::class.java)
                if (savedUser.email == email && savedUser.password == password) {
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                    val editor = sharePref.edit()
                    editor.putBoolean("isLoggedIn", true)
                    editor.apply()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please sign up first", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textSignUp.setOnClickListener {
            val intent = Intent(this, CreatAccountActivity::class.java)
            startActivity(intent)
        }
    }
}
