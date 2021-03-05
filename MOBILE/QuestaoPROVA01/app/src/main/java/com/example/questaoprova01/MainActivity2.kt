package com.example.questaoprova01

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val txtValor1 = findViewById<TextView>(R.id.txtNome)
        val txtValor2 = findViewById<TextView>(R.id.txtEmail)

        val valor1 = intent.getStringExtra("valor1")
        val valor2 = intent.getStringExtra("valor2")

        txtValor1.text = valor1
        txtValor2.text = valor2
    }

    override fun onBackPressed() {
        val i = intent
        val valor1_string = intent.getStringExtra("valor1")
        val valor2_string = intent.getStringExtra("valor2")

        val valor1_int = Integer.parseInt(valor1_string)
        val valor2_int = Integer.parseInt(valor2_string)

        val valor = (valor1_int+valor2_int).toString()
        i.putExtra("mensagem", valor)
        setResult(Activity.RESULT_OK, i)
        finish()
    }
}