package com.example.listfragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment
import java.lang.RuntimeException

class AlimentoFragment : ListFragment() {

    private var adapter: ArrayAdapter<Aliment>? = null
    private var listener: OnItemClickAlimento? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context !is OnItemClickAlimento){
            throw RuntimeException("Não é do tipo OnTimeClickAlimento")
        }

        listener = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1)

        var nomes = requireActivity()
            .resources
            .getStringArray(R.array.alimentos_nomes)

        var precos = requireActivity()
            .resources
            .getStringArray(R.array.alimentos_precos)

        for (i in nomes.indices){
            var alimento = Aliment(nomes[i], precos[i].toDouble())
            adapter?.add(alimento)
        }

        listAdapter = adapter
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        val alimento = adapter?.getItem(position)
        listener?.onClickAlimento(alimento!!)
    }

    interface OnItemClickAlimento{
        fun onClickAlimento(alimento: Aliment)
    }

}