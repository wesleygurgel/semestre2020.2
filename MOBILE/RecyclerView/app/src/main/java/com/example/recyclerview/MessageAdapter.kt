package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(
    private val messages: List<Message>,
    private val callback: (Message)-> Unit
): RecyclerView.Adapter<MessageAdapter.VH>() {

    override fun onBindViewHolder(holder: VH, position: Int) {
        val (title, text) = messages[position]
        holder.txtTitle.text = title
        holder.txtText.text = text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        val vh = VH(view)

        vh.itemView.setOnClickListener{
            val message = messages[vh.adapterPosition]
            callback(message)
        }

        return vh
    }

    override fun getItemCount(): Int = messages.size


    class VH(itemView: View): RecyclerView.ViewHolder(itemView){

        val txtTitle: TextView = itemView.findViewById(R.id.txtTitle)
        val txtText: TextView = itemView.findViewById(R.id.txtText)

    }




}