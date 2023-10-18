package com.example.calculatorv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
     private val operators = charArrayOf('+', '-', '*', '/')
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcPanel = findViewById<TextView>(R.id.calcPanel)

        val button0 = findViewById<Button>(R.id.zero)
        button0.setOnClickListener{
            addNumber(button0.text.toString(), calcPanel)
        }
        val button1 = findViewById<Button>(R.id.one)
        button1.setOnClickListener{
            addNumber(button1.text.toString(), calcPanel)
        }
        val button2 = findViewById<Button>(R.id.two)
        button2.setOnClickListener{
            addNumber(button2.text.toString(), calcPanel)
        }
        val button3 = findViewById<Button>(R.id.three)
        button3.setOnClickListener{
            addNumber(button3.text.toString(), calcPanel)
        }
        val button4 = findViewById<Button>(R.id.four)
        button4.setOnClickListener{
            addNumber(button4.text.toString(), calcPanel)
        }
        val button5 = findViewById<Button>(R.id.five)
        button5.setOnClickListener{
            addNumber(button5.text.toString(), calcPanel)
        }
        val button6 = findViewById<Button>(R.id.six)
        button6.setOnClickListener{
            addNumber(button6.text.toString(), calcPanel)
        }
        val button7 = findViewById<Button>(R.id.seven)
        button7.setOnClickListener{
            addNumber(button7.text.toString(), calcPanel)
        }
        val button8 = findViewById<Button>(R.id.eight)
        button8.setOnClickListener{
            addNumber(button8.text.toString(), calcPanel)
        }
        val button9 = findViewById<Button>(R.id.nine)
        button9.setOnClickListener{
            addNumber(button9.text.toString(), calcPanel)
        }

        val buttonPlus = findViewById<Button>(R.id.plus)
        buttonPlus.setOnClickListener{
            calcWithOperators(calcPanel)
            addOperator(buttonPlus.text[0], calcPanel)
        }

        val buttonMinus = findViewById<Button>(R.id.minus)
        buttonMinus.setOnClickListener{
            calcWithOperators(calcPanel)
            addOperator(buttonMinus.text[0], calcPanel)
        }

        val buttonMultiply = findViewById<Button>(R.id.multiply)
        buttonMultiply.setOnClickListener{
            calcWithOperators(calcPanel)
            addOperator(buttonMultiply.text[0], calcPanel)
        }

        val buttonDivide = findViewById<Button>(R.id.divide)
        buttonDivide.setOnClickListener{
            calcWithOperators(calcPanel)
            addOperator(buttonDivide.text[0], calcPanel)
        }

        val buttonEqual = findViewById<Button>(R.id.equal)
        buttonEqual.setOnClickListener{
            val result = calcNumbers(calcPanel)
            calcPanel.text = result.toString()
        }

        val buttonClear = findViewById<Button>(R.id.clear)
        buttonClear.setOnClickListener{
            clear(calcPanel)
        }

        val buttonAllClear = findViewById<Button>(R.id.allClear)
        buttonAllClear.setOnClickListener{
            allClear(calcPanel)
        }

        val buttonEuler = findViewById<Button>(R.id.euler)
        buttonEuler.setOnClickListener{
            insertEuler(calcPanel)
        }

        val buttonPoint = findViewById<Button>(R.id.point)
        buttonPoint.setOnClickListener{
            insertPoint(calcPanel)
        }

    }


    private fun addNumber(value: String, calcPanel: TextView){

        val oldText = calcPanel.text.toString()

        val text = oldText + value

        calcPanel.text = text
    }

    private fun addOperator(value: Char, calcPanel: TextView) {
        try {
            val oldText = calcPanel.text.toString()

            val text: String = if (operators.contains(oldText.last())) {
                oldText.substring(0, oldText.length - 1) + value
            } else {
                oldText + value
            }

            calcPanel.text = text
        } catch (e: Exception) {
            // Log the exception
            Log.e("MyTag", "An exception occurred in addOperator: ${e.message}", e)
        }
    }

    private fun calcNumbers(calcPanel: TextView): Number {
        val text = calcPanel.text.toString()

        return if (text.contains('+')) {
            val numbers = text.split('+')

            numbers[0].toFloat() + numbers[1].toFloat()
        }else if (text.contains('-')){
            val numbers = text.split('-')

            numbers[0].toFloat() - numbers[1].toFloat()
        }else if (text.contains('*')){
            val numbers = text.split('*')

            numbers[0].toFloat() * numbers[1].toFloat()
        }else if (text.contains('/')){
            val numbers = text.split('/')

            if (numbers[1].toInt() == 0){
                Toast.makeText(this, "You cannot divide by 0", Toast.LENGTH_SHORT).show()
            }

            numbers[0].toFloat() / numbers[1].toFloat()
        }else{
            0
        }
    }

    private fun calcWithOperators(calcPanel: TextView){

        val splitText = calcPanel.text.toString().split("[+\\-*/]".toRegex())

        if(splitText.last() != "" && splitText.size == 2 && splitText.first() != "") {
            val result = calcNumbers(calcPanel).toString()

            calcPanel.text = result
        }
    }

    private fun clear(calcPanel: TextView){
        var sequence = calcPanel.text.toString()

        sequence = sequence.dropLast(1)

        calcPanel.text = sequence
    }

    private fun allClear(calcPanel: TextView){
        calcPanel.text = ""
    }

    private fun insertEuler(calcPanel: TextView) {
        var text = calcPanel.text.toString()

        if(text == ""){
            text = Math.E.toString()
        }else if(operators.contains(text.last())) {
            text += Math.E
        }else{
            text = Math.E.toString()
        }

        calcPanel.text = text
    }

    private fun insertPoint(calcPanel: TextView){

        val splitText = calcPanel.text.toString().split("[+\\-*/]".toRegex())

        if(!splitText.last().contains('.')){
            calcPanel.text = calcPanel.text.toString() + '.'
        }
    }
}