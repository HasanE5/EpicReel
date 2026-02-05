package com.hasan.ahmed.belal.epic_reel

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import com.hasan.ahmed.belal.epic_reel.databinding.ActivityCreatAccountBinding
import com.hasan.ahmed.belal.epic_reel.model.User

class CreatAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreatAccountBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityCreatAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val users = mutableListOf<User>()
        binding.btnSgin.setOnClickListener {
            val name = binding.EditTextFullName.text.toString()
            val email = binding.EditTextEmail.text.toString()
            val pass = binding.EditTextPassword.text.toString()
            val confirmPass = binding.EditTextConfirmPassword.text.toString()

            if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                android.widget.Toast.makeText(this, "Enter all fields", android.widget.Toast.LENGTH_SHORT).show()
            } else if (pass != confirmPass) {
                binding.EditTextConfirmPassword.error = "password does not match"
            } else if (pass == confirmPass && pass.length < 8) {
                binding.EditTextPassword.error = "password must be at least 8 characters"
            }else {
                val sharedPref = getSharedPreferences("AppPref", MODE_PRIVATE)
                val editor = sharedPref.edit()

                val newUser = User(name, email, pass, false)
                editor.putString("savedUser", newUser.toJSON())
                editor.apply()

                val intent = android.content.Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }

        binding.TextSignUp.setOnClickListener {
            finish()
        }

    }
}