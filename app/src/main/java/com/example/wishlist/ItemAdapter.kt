package com.example.wishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ItemAdapter(private val items: MutableList<Item>): RecyclerView.Adapter<ItemAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Your holder should contain a member variable for any view that will be set as you render
        // a row
        val itemNameTextView: TextView
        val itemPriceTextView: TextView
        val storeNameTextView: TextView


        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            itemNameTextView = itemView.findViewById(R.id.itemNameTV)
            itemPriceTextView = itemView.findViewById(R.id.itemPriceTV)
            storeNameTextView = itemView.findViewById(R.id.storeNameTV)


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.list, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val itemM = items.get(position)
        // Set item views based on views and data model
        holder.itemNameTextView.text = itemM.itemName
        holder.itemPriceTextView.text = itemM.itemPrice
        holder.storeNameTextView.text = itemM.storeName

    }

    override fun getItemCount(): Int {
       return items.size
    }

    }
