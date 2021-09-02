package com.example.basictasktracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Build a recycler view with a list of items
        // 1, 2, 3, 4, 5, 6

        // Lookup the recyclerview in activity layout
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        // Initialize contacts
        val listOfItems = mutableListOf<Any>()
        // Create adapter passing in the sample user data
        val adapter = RecyclerViewAdapter(listOfItems)
        // Attach the adapter to the recyclerview to populate items
        recyclerView.adapter = adapter
        // Set layout manager to position the items
        recyclerView.layoutManager = LinearLayoutManager(this)
        // That's all!

        val newTask = findViewById<TextView>(R.id.newTask)

        findViewById<Button>(R.id.button).setOnClickListener {
            // Add a new number in list
            listOfItems.add(newTask.text.toString())
            // Notify Adapter
            adapter.notifyDataSetChanged()

        }

    }
}
