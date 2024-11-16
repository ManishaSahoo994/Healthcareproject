package com.example.health_care_project

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BookAppointmentActivity : AppCompatActivity() {

    private lateinit var ed1: EditText
    private lateinit var ed2: EditText
    private lateinit var ed3: EditText
    private lateinit var ed4: EditText
    private lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment)

        // Set edge-to-edge content
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.buttonAppBack)) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        tv = findViewById(R.id.textViewAppTitle)
        ed1 = findViewById(R.id.editTextAppFullName)
        ed2 = findViewById(R.id.editTextAppAddress)
        ed3 = findViewById(R.id.editTextAppContactNumber)
        ed4 = findViewById(R.id.editTextAppFees)

        // Set EditTexts to non-editable
        ed1.keyListener = null
        ed2.keyListener = null
        ed3.keyListener = null
        ed4.keyListener = null

        // Get intent data
        val intent = intent
        val title = intent.getStringExtra("text1")
        val fullname = intent.getStringExtra("text2")
        val address = intent.getStringExtra("text3")
        val contact = intent.getStringExtra("text4")
        val fees = intent.getStringExtra("text5")

        // Set data to views
        tv.text = title
        ed1.setText(fullname)
        ed2.setText(address)
        ed3.setText(contact)
        ed4.setText("Cons Fees: $fees/-")
    }
}
