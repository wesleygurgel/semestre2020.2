package com.example.atividade04_exercicio01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), ButtonFragment.ChangeColorListener {

    private var colorFragment: ColorFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorFragment = supportFragmentManager.findFragmentById(R.id.fragColor) as ColorFragment
    }

    override fun ChangeColor(color: Int) {
        colorFragment?.setColorBackground(color)
    }
}