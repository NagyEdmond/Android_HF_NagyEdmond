package com.example.colors

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var list: ListView
    private var letters = mutableListOf("G", "F", "E", "D", "C", "B", "A")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        list = findViewById(R.id.list)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, letters)

        list.adapter = adapter
        registerForContextMenu(list)

        supportActionBar?.apply {
            title = "Colors"
            setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.title){
            "Order" -> {
                letters = letters.sorted().toMutableList()
                adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, letters)
                list.adapter = adapter
                return true
            }

            "Delete" -> {
                letters.clear()
                adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, letters)
                list.adapter = adapter
                return true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(0, v!!.id, 0, "Red")
        menu?.add(0, v!!.id, 0, "Green")
        menu?.add(0, v!!.id, 0, "Yellow")
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        val view = info.targetView as TextView
        return when (item.title){
            "Red" -> {
                view.setTextColor(Color.RED)
                true
            }

            "Green" -> {
                view.setTextColor(Color.GREEN)
                true
            }

            "Yellow" -> {
                view.setTextColor(Color.YELLOW)
                true
            }

            else -> super.onContextItemSelected(item)
        }

    }
}