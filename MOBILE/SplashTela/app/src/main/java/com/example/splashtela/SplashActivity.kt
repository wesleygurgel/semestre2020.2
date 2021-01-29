package com.example.splashtela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Thread{
            SystemClock.sleep(2500)

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }.start()
    }
}