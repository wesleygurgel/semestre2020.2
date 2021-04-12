package com.example.questaoprova01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var valor1: EditText? = null
    private var valor2: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        valor1 = findViewById(R.id.edtValor1)
        valor2 = findViewById(R.id.edtValor2)

    }

    fun next(view: View){
        val intent = Intent(this, MainActivity2::class.java)

        val valor1 = valor1?.text.toString()
        val valor2 = valor2?.text.toString()

        intent.putExtra("valor1", valor1)
        intent.putExtra("valor2", valor2)

        startActivityForResult(intent, 10)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10){
            var mensagem = data?.getStringExtra("mensagem")
            var txtMensagem = findViewById<TextView>(R.id.txtMensagem)
            txtMensagem.text = mensagem
        }


    }

}