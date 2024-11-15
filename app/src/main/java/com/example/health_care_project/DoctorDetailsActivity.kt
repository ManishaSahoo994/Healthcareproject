package com.example.health_care_project

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DoctorDetailsActivity : AppCompatActivity() {

    private val doctorDetails1 = arrayOf(
        arrayOf("Doctor Name: Arjit Sasta", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No: 9856093456", "600"),
        arrayOf("Doctor Name: Prasad Sasta", "Hospital Address: Nigdi", "Exp: 10yrs", "Mobile No: 879056778", "800"),
        arrayOf("Doctor Name: Nihar Prusty", "Hospital Address: Pune", "Exp: 8yrs", "Mobile No: 8909353856", "500"),
        arrayOf("Doctor Name: Deepak Sahoo", "Hospital Address: Delhi", "Exp: 3yrs", "Mobile No: 987895679", "600"),
        arrayOf("Doctor Name: Ashok Panda", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No: 890967236", "800")
    )
    private val doctorDetails2 = arrayOf(
        arrayOf("Doctor Name: Arjit Sasta", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No: 9856093456", "600"),
        arrayOf("Doctor Name: Prasad Sasta", "Hospital Address: Nigdi", "Exp: 10yrs", "Mobile No: 879056778", "800"),
        arrayOf("Doctor Name: Nihar Prusty", "Hospital Address: Pune", "Exp: 8yrs", "Mobile No: 8909353856", "500"),
        arrayOf("Doctor Name: Deepak Sahoo", "Hospital Address: Delhi", "Exp: 3yrs", "Mobile No: 987895679", "600"),
        arrayOf("Doctor Name: Ashok Panda", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No: 890967236", "800")
    )
    private val doctorDetails3 = arrayOf(
        arrayOf("Doctor Name: Arjit Sasta", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No: 9856093456", "600"),
        arrayOf("Doctor Name: Prasad Sasta", "Hospital Address: Nigdi", "Exp: 10yrs", "Mobile No: 879056778", "800"),
        arrayOf("Doctor Name: Nihar Prusty", "Hospital Address: Pune", "Exp: 8yrs", "Mobile No: 8909353856", "500"),
        arrayOf("Doctor Name: Deepak Sahoo", "Hospital Address: Delhi", "Exp: 3yrs", "Mobile No: 987895679", "600"),
        arrayOf("Doctor Name: Ashok Panda", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No: 890967236", "800")
    )
    private val doctorDetails4 = arrayOf(
        arrayOf("Doctor Name: Arjit Sasta", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No: 9856093456", "600"),
        arrayOf("Doctor Name: Prasad Sasta", "Hospital Address: Nigdi", "Exp: 10yrs", "Mobile No: 879056778", "800"),
        arrayOf("Doctor Name: Nihar Prusty", "Hospital Address: Pune", "Exp: 8yrs", "Mobile No: 8909353856", "500"),
        arrayOf("Doctor Name: Deepak Sahoo", "Hospital Address: Delhi", "Exp: 3yrs", "Mobile No: 987895679", "600"),
        arrayOf("Doctor Name: Ashok Panda", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No: 890967236", "800")
    )
    private val doctorDetails5 = arrayOf(
        arrayOf("Doctor Name: Arjit Sasta", "Hospital Address: Pimpri", "Exp: 5yrs", "Mobile No: 9856093456", "600"),
        arrayOf("Doctor Name: Prasad Sasta", "Hospital Address: Nigdi", "Exp: 10yrs", "Mobile No: 879056778", "800"),
        arrayOf("Doctor Name: Nihar Prusty", "Hospital Address: Pune", "Exp: 8yrs", "Mobile No: 8909353856", "500"),
        arrayOf("Doctor Name: Deepak Sahoo", "Hospital Address: Delhi", "Exp: 3yrs", "Mobile No: 987895679", "600"),
        arrayOf("Doctor Name: Ashok Panda", "Hospital Address: Katraj", "Exp: 7yrs", "Mobile No: 890967236", "800")
    )

    private lateinit var doctorDetails: Array<Array<String>>
    private lateinit var tv: TextView
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor_details)

        tv = findViewById(R.id.DDTittle)
        btn = findViewById(R.id.buttonDDBack)

        val title = intent.getStringExtra("title")
        tv.text = title

        doctorDetails = when (title) {
            "family physicians" -> doctorDetails1
            "Diticians" -> doctorDetails2
            "Details" -> doctorDetails3
            "surgen" -> doctorDetails4
            else -> doctorDetails5
        }

        btn.setOnClickListener {
            startActivity(Intent(this@DoctorDetailsActivity, FindDoctorActivity::class.java))

        }

        val list = ArrayList<HashMap<String, String>>()
        for (details in doctorDetails) {
            val item = HashMap<String, String>()
            item["line1"] = details[0]
            item["line2"] = details[1]
            item["line3"] = details[2]
            item["line4"] = details[3]
            item["line5"] = "Consultation fees: ${details[4]}/-"
            list.add(item)
        }

        val sa = SimpleAdapter(
            this,
            list,
            R.layout.multi_lines,
            arrayOf("line1", "line2", "line3", "line4", "line5"),
            intArrayOf(R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e)
        )

        val listView: ListView = findViewById(R.id.ListviewDD)
        listView.adapter = sa

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@DoctorDetailsActivity, BookAppointmentActivity::class.java)
            intent.putExtra("text1", title)
            intent.putExtra("text2", doctorDetails[i][0])
            intent.putExtra("text3", doctorDetails[i][1])
            intent.putExtra("text4", doctorDetails[i][3])
            intent.putExtra("text5", doctorDetails[i][4])
            startActivity(intent)
        }


    }
}