package com.example.health_care_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {


    private lateinit var edUsername: EditText
    private lateinit var edEmail: EditText
    private lateinit var edPassword: EditText
    private lateinit var edConfirm: EditText
    private lateinit var btn: Button
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)


        edUsername = findViewById(R.id.editTextAppFullName)
        edPassword = findViewById(R.id.editTextAppContactNumber)
        edEmail = findViewById(R.id.editTextRegEmail)
        edConfirm = findViewById(R.id.editTextAppFees)
        btn = findViewById(R.id.buttonBOOKAppointment)
        tv = findViewById(R.id.textViewExistingUser)

        tv.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }

        btn.setOnClickListener {
            val username = edUsername.text.toString()
            val email = edEmail.text.toString()
            val password = edPassword.text.toString()
            val confirm = edConfirm.text.toString()


            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(applicationContext, "Please fill all details", Toast.LENGTH_SHORT).show()
            } else {
                if (password == confirm) {
                    if (isValid(password)) {
                        Toast.makeText(applicationContext, "Record Inserted", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Password must contain at least 8 characters, including a letter, digit, and special symbol",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(applicationContext, "Password and confirm password didn't match", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun isValid(password: String): Boolean {
        var hasLetter = false
        var hasDigit = false
        var hasSpecial = false

        if (password.length < 8) {
            return false
        } else {
            for (char in password) {
                if (char.isLetter()) hasLetter = true
                if (char.isDigit()) hasDigit = true
                if (char in "!@#\$%^&*()-_+=<>?/.,:;{}[]|~`") hasSpecial = true
            }
            return hasLetter && hasDigit && hasSpecial
        }
    }
}
