package com.example.async

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun iniciar(v: View){
        val btn_iniciar = findViewById<Button>(R.id.btn_iniciar)
        val txt_counter = findViewById<TextView>(R.id.txt_counter)

        var task = CounterTask(btn_iniciar, txt_counter)
        task.execute(10)
    }
}