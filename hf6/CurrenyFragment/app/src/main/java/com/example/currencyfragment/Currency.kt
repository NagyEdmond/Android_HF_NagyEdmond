package com.example.currencyfragment

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.FragmentManager

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Currency.newInstance] factory method to
 * create an instance of this fragment.
 */
class Currency : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.fragment_curreny, container, false)

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

        val listView: ListView = rootView.findViewById(R.id.list)

        val adapter = CustomArrayAdapter(requireActivity(), imgList, abbrList, nameList, buyingList, sellingList)

        listView.adapter = adapter

        val fm : FragmentManager = parentFragmentManager

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedName = nameList[position]
            val selectedBuy = buyingList[position]
            val selectedAbr = abbrList[position]
            val selectedSell = sellingList[position]
            val selectedImg = imgList[position]

            val imgBitmap: Bitmap = BitmapFactory.decodeResource(resources, selectedImg)

            val fragment = CurrencyDetail()
            val bundle = Bundle()
            bundle.putParcelable("image", imgBitmap)
            bundle.putString("name", selectedName)
            bundle.putString("abbr", selectedAbr)
            bundle.putString("buy", selectedBuy)
            bundle.putString("sell", selectedSell)
            fragment.arguments = bundle

            fm.beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit()
        }
        // Inflate the layout for this fragment
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Curreny.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Currency().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}