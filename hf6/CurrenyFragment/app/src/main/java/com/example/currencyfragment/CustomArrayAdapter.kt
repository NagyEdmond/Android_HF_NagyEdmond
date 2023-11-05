package com.example.currencyfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CustomArrayAdapter(
    context: Context,
    private val imgList: List<Int>,
    private val abbrList: List<String>,
    private val nameList: List<String>,
    private val buyingList: List<String>,
    private val sellingList: List<String>
):ArrayAdapter<String>(context, R.layout.custom_list_item, abbrList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
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