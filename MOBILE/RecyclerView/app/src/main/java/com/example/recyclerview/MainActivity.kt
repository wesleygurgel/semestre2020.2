package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private var messages = mutableListOf<Message>()

    private var adapter = MessageAdapter(messages, this::onMessageItemClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)
        val edtTitle = findViewById<TextInputEditText>(R.id.edTitle)
        val edtText = findViewById<TextInputEditText>(R.id.edText)

        fabAdd.setOnClickListener{
            val message = Message(edtTitle.text.toString(), edtText.text.toString())
            messages.add(message)
            adapter.notifyItemInserted(messages.lastIndex)

            edtTitle.text?.clear()
            edtText.text?.clear()
            edtTitle.requestFocus()
        }
    }

    fun initSwipeDelete(){
        val swipe = object: ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ){
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                messages.removeAt(position)
                adapter.notifyItemRemoved(position)

            }

        }

        val rvMessages = findViewById<RecyclerView>(R.id.rvMessages)
        val itemTouchHelper = ItemTouchHelper(swipe)
        itemTouchHelper.attachToRecyclerView(rvMessages)
    }


    private fun initRecyclerView(){
        val rvMessages = findViewById<RecyclerView>(R.id.rvMessages)
        rvMessages.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        rvMessages.layoutManager = layoutManager

        initSwipeDelete()
    }

    fun onMessageItemClick(message: Message){
        val s = "${message.title}\n${message.text}"

        Toast.makeText(this, s, Toast.LENGTH_LONG).show()
    }
}