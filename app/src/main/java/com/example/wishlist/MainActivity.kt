package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text
import java.util.*


class MainActivity : AppCompatActivity() {

    lateinit var items: MutableList<Item>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        items = mutableListOf ()
        val itemsRv = findViewById<RecyclerView>(R.id.itemsRv)
        val button = findViewById<Button>(R.id.button)
        val adapter = ItemAdapter(items)
        val itemNameInput = findViewById<EditText>(R.id.itemName)
        val itemPriceInput = findViewById<EditText>(R.id.itemPrice)
        val storeNameInput = findViewById<EditText>(R.id.storeName)

        itemsRv.adapter = adapter
        itemsRv.layoutManager = LinearLayoutManager(this)


        button.setOnClickListener {
            val newItem = Item(itemNameInput.text.toString(), itemPriceInput.text.toString(), storeNameInput.text.toString())
            items.add(newItem)
            adapter.notifyDataSetChanged()
            itemsRv.smoothScrollToPosition(items.lastIndex)




        }

    }

}