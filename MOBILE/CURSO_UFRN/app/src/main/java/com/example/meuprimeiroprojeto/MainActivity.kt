package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var contador: Int = 1
    private lateinit var button1: Button
    private var edtEmail: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button1)
    }

    fun next(view: View){
        val intent = Intent(this, MainActivity2::class.java)

        val textButton1 = button1.text

        intent.putExtra("button1Text", textButton1)

//        startActivity(intent)
        startActivityForResult(intent, 10)


//        Toast.makeText(this, "Nome = $nome\nE-mail = $email", Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //Tratamento dos dados vindos da Activity Fechada
        if (requestCode == 10){
            var valor_recebido = data?.getIntExtra("incrementar", 0)
            if (valor_recebido != null){
                contador = valor_recebido + 1
            }
            button1 = findViewById(R.id.button1)
            button1.text = contador.toString()
        }
    }
}