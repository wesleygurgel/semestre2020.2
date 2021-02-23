package com.example.adapterviewholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    val veiculos = mutableListOf(
            Veiculo("Onix", 2018, 1, true, true),
            Veiculo("Uno", 2007, 0, true, false),
            Veiculo("Del Rey", 1998, 2, false, true),
            Veiculo("Gol", 2014, 3, true, true),
            Veiculo("Onix", 2018, 1, true, true),
            Veiculo("Uno", 2007, 0, true, false),
            Veiculo("Del Rey", 1998, 2, false, true),
            Veiculo("Gol", 2014, 3, true, true),
            Veiculo("Gol", 2014, 3, true, true),
            Veiculo("Onix", 2018, 1, true, true),
            Veiculo("Uno", 2007, 0, true, false),
            Veiculo("Del Rey", 1998, 2, false, true) 
            )

    lateinit var adapter: VeiculoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        val listView = ListView(this)

        setContentView(listView)
        adapter = VeiculoAdapter(this, veiculos)

        listView.adapter = adapter
    }
}