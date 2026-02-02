package com.hasan.ahmed.belal.epic_reel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.hasan.ahmed.belal.epic_reel.databinding.ActivityCreatAccountBinding

class CreatAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreatAccountBinding
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

        binding.btnSgin.setOnClickListener {
            val name = binding.EditTextFullName.text.toString()
            val email = binding.EditTextEmail.text.toString()
            val pass = binding.EditTextPassword.text.toString()
            val confirmPass = binding.EditTextConfirmPassword.text.toString()

            if (name.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                android.widget.Toast.makeText(this, "الرجاء تعبئة جميع الحقول", android.widget.Toast.LENGTH_SHORT).show()
            } else if (pass != confirmPass) {
                binding.EditTextConfirmPassword.error = "كلمات المرور غير متطابقة"
            } else {

                android.widget.Toast.makeText(this, "تم إنشاء الحساب بنجاح", android.widget.Toast.LENGTH_SHORT).show()
            }
        }


        binding.TextSignUp.setOnClickListener {
            finish()
        }

    }
}