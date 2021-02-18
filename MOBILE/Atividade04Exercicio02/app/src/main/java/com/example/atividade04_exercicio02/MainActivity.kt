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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm : FragmentManager = supportFragmentManager

        val f_left : Fragment = LeftFragment()
        val f_right : Fragment = RightFragment()

        val ft : FragmentTransaction = fm.beginTransaction()
        ft.add(R.id.left_fragment, f_left)
        ft.add(R.id.right_fragment, f_right)
        ft.commit()

    }

    override fun changeText(texto: Int) {

    }


}