package com.example.health_care_project

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class FindDoctorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_doctor)

        val exit: CardView = findViewById(R.id.cardFDBack)
        exit.setOnClickListener {
            startActivity(Intent(this@FindDoctorActivity, HomeActivity::class.java))
        }

        val familyPhysician: CardView = findViewById(R.id.cardFDFamilyPhysican)
        familyPhysician.setOnClickListener {
            val intent = Intent(this@FindDoctorActivity, DoctorDetailsActivity::class.java)
            intent.putExtra("title", "Family Physician")
            startActivity(intent)
        }

        val dietician: CardView = findViewById(R.id.cardFDDitician)
        dietician.setOnClickListener {
            val intent = Intent(this@FindDoctorActivity, DoctorDetailsActivity::class.java)
            intent.putExtra("title", "Dietician")
            startActivity(intent)
        }

        val dentist: CardView = findViewById(R.id.cardFDDentist)
        dentist.setOnClickListener {
            val intent = Intent(this@FindDoctorActivity, DoctorDetailsActivity::class.java)
            intent.putExtra("title", "Dentist")
            startActivity(intent)
        }

        val surgeon: CardView = findViewById(R.id.cardFDSurgeon)
        surgeon.setOnClickListener {
            val intent = Intent(this@FindDoctorActivity, DoctorDetailsActivity::class.java)
            intent.putExtra("title", "Surgeon")
            startActivity(intent)
        }

        val cardiologist: CardView = findViewById(R.id.cardFDCardiologist)
        cardiologist.setOnClickListener {
            val intent = Intent(this@FindDoctorActivity, DoctorDetailsActivity::class.java)
            intent.putExtra("title", "Cardiologist")
            startActivity(intent)
        }
    }
}
