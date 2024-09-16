package com.olivinskiy.schedule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scheduleButton = findViewById<Button>(R.id.scheduleButton)

        scheduleButton.setOnClickListener {
            val intent = Intent(this, ViewScheduleActivity::class.java)
            startActivity(intent)
        }
        val changeButton = findViewById<Button>(R.id.changeButton)

        changeButton.setOnClickListener {
            val intent = Intent(this, ScheduleActivity::class.java)
            startActivity(intent)
        }
    }
}