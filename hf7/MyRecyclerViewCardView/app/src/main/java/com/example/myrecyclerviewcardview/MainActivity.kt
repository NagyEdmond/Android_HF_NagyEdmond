package com.example.myrecyclerviewcardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView: RecyclerView = findViewById(R.id.recycler)
        val layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager

        val octopus = MyItem(R.drawable.octopus3, "Octopus", "8 tentacled monster")
        val pig = MyItem(R.drawable.disznyo, "Pig", "Delicious in rolls")
        val sheep = MyItem(R.drawable.sheep, "Sheep", "Great for jumpers")
        val rabbit = MyItem(R.drawable.rabbit, "Rabbit", "Nice in a stew")
        val snake = MyItem(R.drawable.cat, "Snake", "Great for shoes")
        val spider1 = MyItem(R.drawable.dog, "Spider", "Scary")
        val spider2 = MyItem(R.drawable.giraffe, "Spider", "Scary")
        val spider3 = MyItem(R.drawable.horse, "Spider", "Scary")
        val spider4 = MyItem(R.drawable.lion, "Spider", "Scary")

        val itemList = listOf(octopus, pig, sheep, rabbit, snake, spider1, spider2, spider3, spider4)

        val customAdapter = CustomArrayAdapter(itemList)

        recyclerView.adapter = customAdapter
    }
}