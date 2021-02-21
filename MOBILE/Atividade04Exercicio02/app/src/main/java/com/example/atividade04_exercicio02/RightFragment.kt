package com.example.atividade04_exercicio02

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class RightFragment : Fragment() {

    private var txtCount: TextView? = null

    private var count: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.right_fragment, container, false)

        txtCount = view.findViewById(R.id.txt_right)

        if (savedInstanceState != null){
            this.count = savedInstanceState.getInt("count")
        }

        txtCount!!.text = count.toString()

        return view
    }



    fun increment(){
        count++

        txtCount!!.text = count.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("count", count)
    }

}