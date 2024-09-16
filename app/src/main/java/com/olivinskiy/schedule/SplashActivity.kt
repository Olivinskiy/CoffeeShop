package com.olivinskiy.schedule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val lottieView = findViewById<LottieAnimationView>(R.id.lottie)
        lottieView.repeatCount = LottieDrawable.INFINITE
        lottieView.playAnimation()

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, ViewScheduleActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}