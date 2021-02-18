package com.example.atividade04_exercicio02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class LeftFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.left_fragment, container, false)
        v.findViewById<TextView>(R.id.txt_left)

        return v
    }

    fun setText(contador: Int){

        meutexto = view?.findViewById<TextView>(R.id.txt_left)

    }

}