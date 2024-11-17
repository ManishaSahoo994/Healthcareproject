package com.example.health_care_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity

class LabTestActivity : AppCompatActivity() {

    private val packages = arrayOf(
        arrayOf("Package 1 : Full Body Checkup", "", "", "", "900"),
        arrayOf("Package 2 : Blood Glucose Fasting", "", "", "", "299"),
        arrayOf("Package 3 : Covid-19", "", "", "", "600"),
        arrayOf("Package 4 : Thyroid Checkup", "", "", "", "799"),
        arrayOf("Package 5 : Immunity Check", "", "", "", "999"),
    )

    private val packageDetails = """
        Blood Glucose Fasting
        Complete Hemogram
        Hba1c
        Kidney Function Test
        LDH Lactate Dehydrogenase, Serum
        Liver Function Test
        Blood Glucose Fasting
        COVID-19 Antibody - IgG
        Thyroid Profile-Total (T3, T4, ~ TSH Ultra-sensitive)
        Complete Hemogram
        CRP (C Reactive Protein) Quantitative, Serum
        Iron Studies
        Kidney Function Test
        Vitamin D Total-25 Hydroxy
        Liver Function Test
        Lipid Profile
    """.trimIndent()

    private lateinit var btnGoToCart: Button
    private lateinit var btnBack: Button
    private lateinit var listView: ListView
    private lateinit var sa: SimpleAdapter
    private val list = ArrayList<HashMap<String, String>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab_test)

        // Initialize views
        btnGoToCart = findViewById(R.id.buttonLTGoToCart)
        btnBack = findViewById(R.id.buttonLTBack)
        listView = findViewById(R.id.listviewLT)

        // Back button click listener
        btnBack.setOnClickListener {
            startActivity(Intent(this, LabTestActivity  ::class.java))
        }

        // Populate the list
        for (packageItem in packages) {
            val item = HashMap<String, String>()
            item["line1"] = packageItem[0]
            item["line2"] = packageItem[1]
            item["line3"] = packageItem[2]
            item["line4"] = packageItem[3]
            item["line5"] = "Total Cost: ${packageItem[4]}/-"
            list.add(item)
        }

        // Create and set the adapter
        sa = SimpleAdapter(
            this, list, R.layout.multi_lines,
            arrayOf("line1", "line2", "line3", "line4", "line5"),
            intArrayOf(R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e)
        )
        listView.adapter = sa
    }
}
