package com.example.atividade04_exercicio02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class RightFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.right_fragment, container, false)
        v.findViewById<TextView>(R.id.txt_right)

        return v
    }

    fun setText(contador: Int){

        val v = view
        v?.findViewById<TextView>(R.id.txt_left)

    }

}