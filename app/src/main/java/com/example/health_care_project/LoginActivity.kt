package com.example.health_care_project

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var edUsername: EditText
    private lateinit var edPassword: EditText
    private lateinit var btn: Button
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        edUsername = findViewById(R.id.editTextLoginUsername)
        edPassword = findViewById(R.id.editTextLoginPassword)
        btn = findViewById(R.id.buttonLogin)
        tv = findViewById(R.id.textViewNewUser)

        btn.setOnClickListener {
            val username = edUsername.text.toString()
            val password = edPassword.text.toString()
            val db = Database(applicationContext, "healthcare", null, 1)
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(applicationContext, "Please fill all details", Toast.LENGTH_SHORT).show()
            } else {
                if (db.login(username, password)==1){
                    Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
                    val sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("username", username)
                    editor.apply()

                    startActivity(Intent(this@LoginActivity, homeActivity::class.java))
                }else{
                    Toast.makeText(applicationContext, "Invalid Username and Password", Toast.LENGTH_SHORT).show()

                }
            }
        }

        tv.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
    }
}
