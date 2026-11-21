package com.example.authdesignapp // ⚠️ Keep your actual package name on line 1

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsername = findViewById<TextInputEditText>(R.id.etLoginUsername)
        val etPassword = findViewById<TextInputEditText>(R.id.etLoginPassword)
        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val tvGoToSignup = findViewById<TextView>(R.id.tvGoToSignup)

        // Retrieve saved student data if user signed up earlier
        val prefs = getSharedPreferences("StudentPrefs", MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val savedUser = prefs.getString("USERNAME", null)
            val savedPass = prefs.getString("PASSWORD", null)

            // Allow login if credentials match registered account, OR allow quick demo login
            if (savedUser != null && username == savedUser && password == savedPass) {
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
                finish()
            } else if (savedUser == null) {
                // Default demo profile if logging in directly without signing up first
                prefs.edit().apply {
                    putString("STUDENT_NUMBER", "2024-104892")
                    putString("LAST_NAME", "Martinez")
                    putString("FIRST_NAME", "Kit Dustin")
                    putString("PROGRAM", "BS Computer Science")
                    putString("SPECIALTY", "Digital Forensics")
                    putString("YEAR_LEVEL", "3rd Year")
                    apply()
                }
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
            }
        }

        tvGoToSignup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}