package com.olivinskiy.schedule

import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class ScheduleList : AppCompatActivity() {
    private lateinit var daySpinner: Spinner
    private lateinit var scheduleTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_list)

        daySpinner = findViewById(R.id.daySpinner)
        scheduleTextView = findViewById(R.id.scheduleTextView)
        val daysOfWeek = arrayOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, daysOfWeek)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        daySpinner.adapter = adapter

        daySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedDay = parent.getItemAtPosition(position) as String
                loadScheduleForDay(selectedDay)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val glowColor = ContextCompat.getColor(this, R.color.glowColor)

        val colorStateList = ColorStateList(
            arrayOf(intArrayOf(android.R.attr.state_checked), intArrayOf(-android.R.attr.state_checked)),
            intArrayOf(glowColor, ContextCompat.getColor(this, android.R.color.darker_gray))
        )

        bottomNavigationView.itemIconTintList = colorStateList
        bottomNavigationView.selectedItemId = R.id.schedule_item
        bottomNavigationView.itemBackground = null

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_item -> {
                    val intent = Intent(this, ViewScheduleActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    true
                }
                R.id.schedule_item -> {
                    val intent = Intent(this, ScheduleList::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    true
                }
                else -> false
            }
        }
    }
    private fun loadScheduleForDay(day: String) {
        val sharedPreferences = getSharedPreferences("SchedulePrefs", MODE_PRIVATE)
        val schedule = sharedPreferences.getString(day, "Расписание не установлено")
        scheduleTextView.text = schedule
    }
}