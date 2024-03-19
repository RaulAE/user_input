package com.example.user_input

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    val costPerHour = 1.50
    var numberOfHours: Int = 0
    var totalCharges: Double = 0.00
    var lotChoice = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val hours: EditText = findViewById(R.id.txtHours)
        val group: Spinner = findViewById(R.id.spnGroup)
        val charges: Button = findViewById(R.id.btnChange)
        val result: TextView = findViewById(R.id.txtResults)

        charges.setOnClickListener{
            numberOfHours = hours.text.toString().toInt()
            val currency = DecimalFormat("$###,###.00")
            totalCharges = costPerHour * numberOfHours.toDouble()
            lotChoice = group.selectedItem.toString()
            val totalChargesFormatted = currency.format(totalCharges)

            result.text = "Cost for parking in $lotChoice for $numberOfHours hours is $totalChargesFormatted"

        }
    }
}