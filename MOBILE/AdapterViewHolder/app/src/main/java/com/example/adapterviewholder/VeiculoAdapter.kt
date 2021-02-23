package com.example.adapterviewholder

import android.content.Context
import android.content.res.TypedArray
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class VeiculoAdapter (
    private var ctx: Context,
    private var veiculos: List<Veiculo>
    ): BaseAdapter() {

    private val logos: TypedArray by lazy {
        ctx.resources.obtainTypedArray(R.array.logos)
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val veiculo = veiculos[position]

        val holder: ViewHolder
        val row: View

        if(convertView == null){

            Log.d("holder", "Nova Posição: $position")

            row = LayoutInflater.from(ctx).inflate(R.layout.item_veiculo, parent, false)
            holder = ViewHolder(row)
            row.tag = holder

        }else{

            Log.d("holder", "Posição Existente: $position")


            row = convertView
            holder = convertView.tag as ViewHolder
        }


        holder.imgLogo.setImageDrawable(logos.getDrawable(veiculo.fabricante))
        holder.txtModelo.text = veiculo.modelo
        holder.txtAno.text = veiculo.ano.toString()
        holder.txtCombustivel.text = ctx.getString(getCombustivel(veiculo))

        return row

    }

    override fun getItem(position: Int): Any = veiculos[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = veiculos.size

    companion object{
        data class  ViewHolder(val view: View){
            val imgLogo: ImageView = view.findViewById(R.id.imgLogo)
            val txtModelo: TextView = view.findViewById(R.id.txtModelo)
            val txtAno: TextView = view.findViewById(R.id.txtAno)
            val txtCombustivel: TextView = view.findViewById(R.id.txtCombustivel)
        }
    }

    private fun getCombustivel(veiculo: Veiculo): Int =
            if (veiculo.gasolina && veiculo.etanol) R.string.combus_flex
            else if (veiculo.gasolina) R.string.combus_gasolina
            else if (veiculo.etanol) R.string.combus_etanol
            else R.string.combus_invalido

}