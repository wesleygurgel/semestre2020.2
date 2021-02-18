package com.example.atividade04_exercicio01

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import java.lang.RuntimeException

class ButtonFragment : Fragment(), View.OnClickListener {

    var listener: ChangeColorListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context !is ChangeColorListener){
            throw RuntimeException("Não é um ChangeColorListener")
        }

        listener = context

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.fragment_button, container, false)

        v.findViewById<Button>(R.id.btn_black).setOnClickListener(this)
        v.findViewById<Button>(R.id.btn_blue).setOnClickListener(this)
        v.findViewById<Button>(R.id.btn_green).setOnClickListener(this)
        v.findViewById<Button>(R.id.btn_red).setOnClickListener(this)
        v.findViewById<Button>(R.id. btn_yellow).setOnClickListener(this)

        return v
    }

    override fun onClick(v: View?) {

        var color: Int = 0
        var id = v?.id

        when(id){
            R.id.btn_black -> color = Color.BLACK
            R.id.btn_yellow -> color = Color.YELLOW
            R.id.btn_red -> color = Color.RED
            R.id.btn_green -> color = Color.GREEN
            R.id.btn_blue -> color = Color.BLUE
        }

        listener?.ChangeColor(color)
    }

    interface ChangeColorListener{
        fun ChangeColor(color: Int)
    }

}