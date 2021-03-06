package com.example.basictasktracker

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

// 1. Define Adapter class
// 2. Implement RecyclerView Adapter
// 3. Created ViewHolder
// 4. Created stubs for our implement methods

// Bridge the layout file and our data

class RecyclerViewAdapter (private val listOfItems:List<Any>):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>()  {

    // Specify which layout to use for each item inside the recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val items = inflater.inflate(R.layout.item_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(items)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listOfItems.get(position)
        holder.textView.text=item.toString()

    }

    //  Tells RecyclerView how many items it needs to lay out
    override fun getItemCount(): Int {
        return listOfItems.size
    }

    //  Make layout more efficient
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textView =
            itemView.findViewById<TextView>(R.id.textView)

    }
}