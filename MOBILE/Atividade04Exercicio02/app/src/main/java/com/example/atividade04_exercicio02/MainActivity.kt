package com.example.atividade04_exercicio02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(), CenterFragment.ChangeTextListener {

    private var textoEsquerda: LeftFragment? = null
    private var textoDireita: RightFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm : FragmentManager = supportFragmentManager
        val ft : FragmentTransaction = fm.beginTransaction()


        textoEsquerda = fm.findFragmentById(R.id.left_fragment) as LeftFragment?
        if (textoEsquerda == null){
            textoEsquerda = LeftFragment()
            ft.add(R.id.left_fragment, textoEsquerda as LeftFragment, "textoEsquerda")
        }

        textoDireita = fm.findFragmentById(R.id.right_fragment) as RightFragment?
        if (textoDireita == null){
            textoDireita = RightFragment()
            ft.add(R.id.right_fragment, textoDireita as RightFragment, "textoDireita")
        }

        var buttonFragment: CenterFragment? = fm.findFragmentById(R.id.frame_button) as CenterFragment?
        if (buttonFragment == null){
            buttonFragment = CenterFragment()
            ft.add(R.id.frame_button, buttonFragment, "buttonFragment")
        }

        ft.commit()

    }

    override fun increment() {
        textoEsquerda?.increment()
        textoDireita?.increment()
    }

}