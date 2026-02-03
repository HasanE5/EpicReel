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
            intent.getStringExtra("users")?.let {
                val users = Gson().fromJson(it, Array<User>::class.java).toList()
                val user = users.find { it.email == email && it.password == password }

                if (user != null) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            }


        }


        binding.textSignUp.setOnClickListener {
            val intent = Intent(this, CreatAccountActivity::class.java)
            startActivity(intent)
        }


    }
}