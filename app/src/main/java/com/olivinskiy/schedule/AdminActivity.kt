package com.olivinskiy.schedule

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AdminActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        val passwordField = findViewById<EditText>(R.id.passwordField)
        val loginButton = findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val password = passwordField.text.toString()

            if (password == "123456") {
                val intent = Intent(this, ScheduleActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Неправильный пароль!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
