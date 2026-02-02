package com.hasan.ahmed.belal.epic_reel

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hasan.ahmed.belal.epic_reel.databinding.ActivitySignUpBinding

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

        // 1. منطق زر Sign In (باستخدام الـ ID الخاص بك: btnSign)
        binding.btnSign.setOnClickListener {
            val email = binding.editText.text.toString()
            val password = binding.editTextEnterPassword.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this, "Welcome Back!", Toast.LENGTH_SHORT).show()
                // هنا تضع Intent للشاشة الرئيسية لاحقاً
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        // 2. الانتقال لشاشة إنشاء حساب (باستخدام الـ ID الخاص بك: textSignUp)
        binding.textSignUp.setOnClickListener {
            val intent = Intent(this, CreatAccountActivity::class.java)
            startActivity(intent)
        }


    }
}