package com.hasan.ahmed.belal.epic_reel

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import androidx.cardview.widget.CardView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat

class SettingsActivity : AppCompatActivity() {

    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings
        )


        val cvAbout = findViewById<CardView>(R.id.cvAbout)
        cvAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }


        // SharedPreferences لتخزين إعدادات المستخدم
        sharedPrefs = getSharedPreferences("AppSettingsPrefs", MODE_PRIVATE)

        // Dark Mode Toggle
        val swDarkMode = findViewById<SwitchCompat>(R.id.swDarkMode)

        // استرجاع القيمة المخزنة سابقًا
        val isDarkMode = sharedPrefs.getBoolean("DarkMode", false)
        swDarkMode.isChecked = isDarkMode
        applyDarkMode(isDarkMode)

        swDarkMode.setOnCheckedChangeListener { _, isChecked ->
            applyDarkMode(isChecked)
            // حفظ الاختيار
            sharedPrefs.edit().putBoolean("DarkMode", isChecked).apply()
        }

        // Push Notifications Toggle
        val swPushNotifications = findViewById<SwitchCompat>(R.id.swPushNotifications)

        // استرجاع القيمة المخزنة سابقًا
        val isPushEnabled = sharedPrefs.getBoolean("PushNotifications", true)
        swPushNotifications.isChecked = isPushEnabled

        swPushNotifications.setOnCheckedChangeListener { _, isChecked ->
            // حفظ الاختيار
            sharedPrefs.edit().putBoolean("PushNotifications", isChecked).apply()
            // هنا ممكن تضيف كود لتفعيل/إلغاء إشعارات التطبيق
        }


        // Back button
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }

    private fun applyDarkMode(enabled: Boolean) {
        if (enabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}