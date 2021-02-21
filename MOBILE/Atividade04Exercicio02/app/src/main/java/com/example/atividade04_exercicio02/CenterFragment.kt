package com.example.atividade04_exercicio02

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import java.lang.RuntimeException

class CenterFragment : Fragment(), View.OnClickListener {

    var listener: ChangeTextListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context !is ChangeTextListener){
            throw RuntimeException("Não é um ChangeTextListener")
        }

        listener = context


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.center_fragment, container, false)

        val button = view.findViewById<Button>(R.id.incrementar_button).setOnClickListener(this)


        return view

    }

    override fun onClick(v: View) {
        listener!!.increment()
    }


    interface ChangeTextListener{
        fun increment()
    }




}