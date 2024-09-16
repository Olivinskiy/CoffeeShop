package com.olivinskiy.schedule

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class ViewScheduleActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_schedule)




        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        val glowColor = ContextCompat.getColor(this, R.color.glowColor)

        val colorStateList = ColorStateList(
            arrayOf(intArrayOf(android.R.attr.state_checked), intArrayOf(-android.R.attr.state_checked)),
            intArrayOf(glowColor, ContextCompat.getColor(this, android.R.color.darker_gray))
        )

        bottomNavigationView.itemIconTintList = colorStateList
        bottomNavigationView.selectedItemId = R.id.menu_item
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

        val bgImage: ImageView = findViewById(R.id.bgimage)

        // Скрываем ImageView до начала анимации
        bgImage.visibility = View.INVISIBLE

        // Загружаем анимацию
        val slideInAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in)

        // Устанавливаем анимацию и показываем ImageView
        bgImage.post {
            bgImage.visibility = View.VISIBLE
            bgImage.startAnimation(slideInAnimation)
        }

        // Загрузка дней недели в Spinner

    }




}

