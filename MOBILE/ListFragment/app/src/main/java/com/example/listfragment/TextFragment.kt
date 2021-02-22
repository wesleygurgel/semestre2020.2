package com.example.listfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class TextFragment : Fragment(){

    private var txtMsg : TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_text, container, false)

        txtMsg = view.findViewById(R.id.txt_msg)

        return view
    }

    fun setMsg(text: String){
        txtMsg?.text = text
    }

}