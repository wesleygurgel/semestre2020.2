package com.example.atividade04_exercicio02

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import java.lang.RuntimeException

class CenterFragment : Fragment(), View.OnClickListener {

    var contador: Int = 0
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
        var v = inflater.inflate(R.layout.center_fragment, container, false)

        v.findViewById<Button>(R.id.frame_button).setOnClickListener(this)

        return v
    }

    override fun onClick(v: View?) {

        listener?.changeText(contador)

    }

    interface ChangeTextListener{
        fun changeText(texto: Int)
    }


}