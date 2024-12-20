package com.example.health_care_project

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class homeActivity : AppCompatActivity() {

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "").toString()
        Toast.makeText(applicationContext, "Welcome $username", Toast.LENGTH_SHORT).show()

        val exit: CardView = findViewById(R.id.cardExit)
        exit.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
            startActivity(Intent(this@homeActivity, LoginActivity::class.java))
        }

        val findDoctor: CardView = findViewById(R.id.cardFindDoctor)
        findDoctor.setOnClickListener {
            startActivity(Intent(this@homeActivity, FindDoctorActivity::class.java))
        }
        val LabTest: CardView = findViewById(R.id.cardLabTest)
            LabTest.setOnClickListener {
            startActivity(Intent(this@homeActivity, LabTestActivity::class.java))
        }



    }
}
