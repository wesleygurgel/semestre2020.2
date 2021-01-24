package com.example.meuprimeiroprojeto

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    val TAG = "MyApp"

    private var contador: Int = 0
    private lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        button2 = findViewById(R.id.button2)

        val valorRecebido = intent.getStringExtra("button1Text")
        var value = Integer.parseInt(valorRecebido as String)
        contador = value+1

        button2.text = contador.toString()
//        button2.text = value
//        txtEmail.text = email

        Log.d(TAG, "onCreate")

    }

    fun back(view: View){
        onBackPressed()
//        Toast.makeText(this, "Nome = $nome\nE-mail = $email", Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
//        super.onBackPressed()

        val i = intent
        i.putExtra("incrementar", contador)
        setResult(Activity.RESULT_OK, i)
        finish()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }
}