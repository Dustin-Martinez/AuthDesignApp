package com.example.authdesignapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val tvStudentFullName = findViewById<TextView>(R.id.tvStudentFullName)
        val tvStudentNumber = findViewById<TextView>(R.id.tvStudentNumber)
        val tvProgram = findViewById<TextView>(R.id.tvProgram)
        val tvSpecialty = findViewById<TextView>(R.id.tvSpecialty)
        val tvYearLevel = findViewById<TextView>(R.id.tvYearLevel)
        val btnLogout = findViewById<MaterialButton>(R.id.btnLogout)

        val prefs = getSharedPreferences("StudentPrefs", MODE_PRIVATE)
        val studentNumber = prefs.getString("STUDENT_NUMBER", "N/A")
        val lastName = prefs.getString("LAST_NAME", "Last Name")
        val firstName = prefs.getString("FIRST_NAME", "First Name")
        val program = prefs.getString("PROGRAM", "N/A")
        val specialty = prefs.getString("SPECIALTY", "N/A")
        val yearLevel = prefs.getString("YEAR_LEVEL", "N/A")

        tvStudentFullName.text = "$lastName, $firstName"
        tvStudentNumber.text = studentNumber
        tvProgram.text = program
        tvSpecialty.text = specialty
        tvYearLevel.text = yearLevel

        btnLogout.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}