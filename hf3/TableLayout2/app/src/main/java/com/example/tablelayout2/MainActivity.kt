package com.example.tablelayout2

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import java.lang.IndexOutOfBoundsException

class Product(val code: String, val name:String, val price:String)

var productList:Array<Product> = arrayOf()

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productCodeView:EditText = findViewById(R.id.editTextText)
        val productNameView:EditText = findViewById(R.id.editTextText2)
        val productPriceView:EditText = findViewById(R.id.editTextText3)

        val addProduct:Button = findViewById(R.id.button)
        addProduct.setOnClickListener{
            addProduct(productCodeView.text.toString(), productNameView.text.toString(), productPriceView.text.toString())
            productCodeView.setText("")
            productNameView.setText("")
            productPriceView.setText("")
        }

        val cancel:Button = findViewById(R.id.button2)
        cancel.setOnClickListener{
            productCodeView.setText("")
            productNameView.setText("")
            productPriceView.setText("")
        }

        val table:TableLayout = findViewById(R.id.tableLayout)
        val showProducts:Button = findViewById(R.id.button3)
        showProducts.setOnClickListener{
            showProducts(table)
        }
    }

    private fun makeProduct(productCode:String, productName:String, productPrice:String):Product{
        return Product(productCode, productName, productPrice)
    }

    private fun addProduct(productCode:String, productName:String, productPrice:String){
        val product = makeProduct(productCode, productName, productPrice)
        productList += product
    }

    private fun showProducts(table:TableLayout){
        table.removeAllViews()

        val rows = arrayOf(
            TableRow(this),
            TableRow(this),
            TableRow(this),
            TableRow(this),
            TableRow(this)
        )

        val layoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.MATCH_PARENT,
            TableRow.LayoutParams.WRAP_CONTENT,
            1.0f
        )

        val border = GradientDrawable()
        border.setColor(Color.TRANSPARENT)
        border.setStroke(1, Color.WHITE)

        val listSize = productList.size

        for(i in 0..listSize){
            val codeText = TextView(this)
            codeText.layoutParams = layoutParams
            codeText.gravity = Gravity.CENTER
            codeText.background = border
            val nameText = TextView(this)
            nameText.layoutParams = layoutParams
            nameText.gravity = Gravity.CENTER
            nameText.background = border
            val priceText = TextView(this)
            priceText.layoutParams = layoutParams
            priceText.gravity = Gravity.CENTER
            priceText.background = border

            try{
                val product = productList[i]
                codeText.text = product.code
                nameText.text = product.name
                priceText.text = product.price

                rows[i].addView(codeText)
                rows[i].addView(nameText)
                rows[i].addView(priceText)
                table.addView(rows[i])
            }catch(e:IndexOutOfBoundsException){
                break
            }
        }

    }
}