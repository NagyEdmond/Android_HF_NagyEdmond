package com.example.currency

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import java.util.zip.Inflater

class CustomListAdapter(
    context: Context,
    private val imgList: List<Int>,
    private val abbrList: List<String>,
    private val nameList: List<String>,
    private val buyingList: List<String>,
    private val sellingList: List<String>
    ):ArrayAdapter<String>(context, R.layout.custom_list_item, abbrList){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rowView = inflater.inflate(R.layout.custom_list_item, parent, false)

            val imgView: ImageView = rowView.findViewById(R.id.imageView)
            val abbrView: TextView = rowView.findViewById(R.id.abr)
            val nameView: TextView = rowView.findViewById(R.id.name)
            val buyingView: TextView = rowView.findViewById(R.id.buying)
            val sellingView: TextView = rowView.findViewById(R.id.selling)

            imgView.setImageResource(imgList[position])
            abbrView.text = abbrList[position]
            nameView.text = nameList[position]
            buyingView.text = buyingList[position]
            sellingView.text = sellingList[position]

            return rowView

        }
    }

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgList = listOf(
            R.drawable.europe,
            R.drawable.usa,
            R.drawable.uk,
            R.drawable.australia,
            R.drawable.canada,
            R.drawable.switzerland,
            R.drawable.denmark,
            R.drawable.hungary
        )

        val abbrList = listOf(
            "EUR", "USD", "GBP", "AUD", "CAD", "CHF", "DKK", "HUF"
        )

        val nameList = listOf(
            "Euro", "Dollar american", "Lira sterlina", "Dolar australian",
            "Dolar canadian", "Franc elvetian", "Coroana daneza", "Forint maghiar"
        )

        val buyingList = listOf(
            "4,4100 RON", "3,9750 RON", "6,1250 RON", "2,9600 RON",
            "3,0950 RON", "4,2300 RON", "0,5850 RON", "0,0136 RON"
        )

        val sellingList = listOf(
            "4,5500 RON", "4,1450 RON", "6,3550", "3,0600 RON",
            "3,2650 RON", "4,3300 RON", "0,6150 RON", "0,0146 RON"
        )

        val listView: ListView = findViewById(R.id.list)

        val adapter = CustomListAdapter(this, imgList, abbrList, nameList, buyingList, sellingList)

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedName = nameList[position]
            val selectedBuy = buyingList[position]
            Toast.makeText(this, "$selectedName: $selectedBuy", Toast.LENGTH_SHORT).show()
        }
    }
}