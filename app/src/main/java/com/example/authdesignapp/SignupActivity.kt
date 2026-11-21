package com.example.authdesignapp // ⚠️ Keep your actual package name on line 1

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val etUsername = findViewById<TextInputEditText>(R.id.etSignupUsername)
        val etPassword = findViewById<TextInputEditText>(R.id.etSignupPassword)
        val etStudentNumber = findViewById<TextInputEditText>(R.id.etStudentNumber)
        val etLastName = findViewById<TextInputEditText>(R.id.etLastName)
        val etFirstName = findViewById<TextInputEditText>(R.id.etFirstName)
        val etProgram = findViewById<TextInputEditText>(R.id.etProgram)
        val etSpecialty = findViewById<TextInputEditText>(R.id.etSpecialty)
        val etYearLevel = findViewById<TextInputEditText>(R.id.etYearLevel)
        val btnRegister = findViewById<MaterialButton>(R.id.btnRegister)
        val tvBackToLogin = findViewById<TextView>(R.id.tvBackToLogin)

        btnRegister.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val studentNumber = etStudentNumber.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val firstName = etFirstName.text.toString().trim()
            val program = etProgram.text.toString().trim()
            val specialty = etSpecialty.text.toString().trim()
            val yearLevel = etYearLevel.text.toString().trim()

            if (username.isEmpty() || password.isEmpty() || studentNumber.isEmpty() ||
                lastName.isEmpty() || firstName.isEmpty() || program.isEmpty() ||
                specialty.isEmpty() || yearLevel.isEmpty()
            ) {
                Toast.makeText(this, "Please complete all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Save student data locally
            val prefs = getSharedPreferences("StudentPrefs", MODE_PRIVATE)
            prefs.edit().apply {
                putString("USERNAME", username)
                putString("PASSWORD", password)
                putString("STUDENT_NUMBER", studentNumber)
                putString("LAST_NAME", lastName)
                putString("FIRST_NAME", firstName)
                putString("PROGRAM", program)
                putString("SPECIALTY", specialty)
                putString("YEAR_LEVEL", yearLevel)
                apply()
            }

            Toast.makeText(this, "Account created! Please sign in.", Toast.LENGTH_SHORT).show()
            finish() // Returns to MainActivity (Login)
        }

        tvBackToLogin.setOnClickListener {
            finish()
        }
    }
}