package com.example.health_care_project

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BookAppointmentActivity : AppCompatActivity() {

    private lateinit var datePickerDialog: DatePickerDialog
    private lateinit var timePickerDialog: TimePickerDialog
    private lateinit var dateButton: Button
    private lateinit var timeButton: Button
    private lateinit var buttonAppBack: Button
    private lateinit var buttonAppBook: Button

    private lateinit var ed1: EditText
    private lateinit var ed2: EditText
    private lateinit var ed3: EditText
    private lateinit var ed4: EditText
    private lateinit var tv: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_appointment)



        // Initialize views
        tv = findViewById(R.id.textViewAppTitle)
        ed1 = findViewById(R.id.editTextAppFullName)
        ed2 = findViewById(R.id.editTextAppAddress)
        ed3 = findViewById(R.id.editTextAppContactNumber)
        ed4 = findViewById(R.id.editTextAppFees)
        dateButton = findViewById(R.id.ButtonAppDate)
        timeButton = findViewById(R.id.ButtonAppTime)
        buttonAppBack = findViewById(R.id.ButtonAppBack) // Corrected ID
        buttonAppBook = findViewById(R.id.ButtonAppBook)

        // Set EditTexts to non-editable
        ed1.isFocusable = false
        ed2.isFocusable = false
        ed3.isFocusable = false
        ed4.isFocusable = false

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

        // Initialize Date and Time Pickers
        initDatePicker()
        initTimePicker()

        // Set button listeners
        dateButton.setOnClickListener {
            datePickerDialog.show()
        }

        timeButton.setOnClickListener {
            timePickerDialog.show()
        }

        buttonAppBack.setOnClickListener {
            startActivity(Intent(this@BookAppointmentActivity, FindDoctorActivity::class.java))
        }


        buttonAppBook.setOnClickListener {
            // Add your booking logic here
        }
    }

    private fun initDatePicker() {
        val dateListener = DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            val date = "${dayOfMonth}/${month + 1}/$year"
            dateButton.text = date
        }

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        datePickerDialog = DatePickerDialog(
            this,
            dateListener,
            year,
            month,
            day
        )
        datePickerDialog.datePicker.minDate = calendar.timeInMillis + 86400000 // Set min date to tomorrow
    }

    private fun initTimePicker() {
        val timeListener = TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
            val time = String.format("%02d:%02d", hourOfDay, minute)
            timeButton.text = time
        }

        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        timePickerDialog = TimePickerDialog(
            this,
            timeListener,
            hour,
            minute,
            true
        )
    }
}
