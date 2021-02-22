package com.example.listfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), AlimentoFragment.OnItemClickAlimento {

    private var textFragment: TextFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textFragment = supportFragmentManager
            .findFragmentById(R.id.frag_text) as TextFragment
    }

    override fun onClickAlimento(alimento: Aliment) {
        textFragment?.setMsg("O preço do ${alimento.nome} é R$ ${alimento.preco} ")
    }


}