package com.olivinskiy.schedule

import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class ScheduleActivity : AppCompatActivity() {
    private lateinit var daySpinner: Spinner
    private lateinit var subjectSpinner1: Spinner
    private lateinit var subjectSpinner2: Spinner
    private lateinit var subjectSpinner3: Spinner
    private lateinit var subjectSpinner4: Spinner
    private lateinit var room1Field: EditText
    private lateinit var room2Field: EditText
    private lateinit var room3Field: EditText
    private lateinit var room4Field: EditText
    private lateinit var saveButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        // Инициализация элементов интерфейса
        daySpinner = findViewById(R.id.daySpinner)
        subjectSpinner1 = findViewById(R.id.subjectSpinner1)
        subjectSpinner2 = findViewById(R.id.subjectSpinner2)
        subjectSpinner3 = findViewById(R.id.subjectSpinner3)
        subjectSpinner4 = findViewById(R.id.subjectSpinner4)
        room1Field = findViewById(R.id.room1Field)
        room2Field = findViewById(R.id.room2Field)
        room3Field = findViewById(R.id.room3Field)
        room4Field = findViewById(R.id.room4Field)
        saveButton = findViewById(R.id.saveButton)

        // Заполнение Spinner для выбора дня недели
        val daysOfWeek = arrayOf("Понедельник", "Вторник", "Среда", "Четверг", "Пятница")
        val dayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, daysOfWeek)
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        daySpinner.adapter = dayAdapter

        // Заполнение Spinner для выбора предметов
        val subjects = arrayOf("Математика", "Физика", "История", "Английский", "Программирование")
        val subjectAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, subjects)
        subjectAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        subjectSpinner1.adapter = subjectAdapter
        subjectSpinner2.adapter = subjectAdapter
        subjectSpinner3.adapter = subjectAdapter
        subjectSpinner4.adapter = subjectAdapter

        // Сохранение расписания
        saveButton.setOnClickListener {
            val selectedDay = daySpinner.selectedItem.toString()

            val schedule = """
                1 пара: ${subjectSpinner1.selectedItem} в аудитории ${room1Field.text}
                2 пара: ${subjectSpinner2.selectedItem} в аудитории ${room2Field.text}
                3 пара: ${subjectSpinner3.selectedItem} в аудитории ${room3Field.text}
                4 пара: ${subjectSpinner4.selectedItem} в аудитории ${room4Field.text}
            """.trimIndent()

            // Сохранение расписания в SharedPreferences
            val sharedPreferences = getSharedPreferences("SchedulePrefs", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString(selectedDay, schedule)
            editor.apply()

            Toast.makeText(this, "Расписание для $selectedDay сохранено", Toast.LENGTH_SHORT).show()
        }
    }
}

