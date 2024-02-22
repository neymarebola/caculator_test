package com.example.calculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var inputEdittext: EditText
    private var input : String = "";
    private lateinit var zero: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button

    private lateinit var add: Button
    private lateinit var sub: Button
    private lateinit var mul: Button
    private lateinit var div: Button
    private lateinit var dot: Button
    private lateinit var equal: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

        inputEdittext.setOnClickListener {
            hideKeyboard(inputEdittext)
        }

        zero.setOnClickListener {
            input += "0"
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }

        one.setOnClickListener {
            input += "1"
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }

        two.setOnClickListener {
            input += "2"
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }
        three.setOnClickListener {
            input += "3"
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }
        four.setOnClickListener {
            input += "4"
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }
        five.setOnClickListener {
            input += "5"
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }
        six.setOnClickListener {
            input += "6"
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }
        seven.setOnClickListener {
            input += "7"
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }
        eight.setOnClickListener {
            input += "8"
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }
        nine.setOnClickListener {
            input += "9"
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }

        add.setOnClickListener {
            input += "+"
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }
        sub.setOnClickListener {
            input += "-"
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }
        mul.setOnClickListener {
            input += "*"
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }
        div.setOnClickListener {
            input += "/"
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }
        dot.setOnClickListener {
            input += "."
            inputEdittext.setText(input)
            inputEdittext.setSelection(inputEdittext.text.length)
        }

        var res = ""
        equal.setOnClickListener {
            res = evaluateExpression(input).toString()
            input = ""
            inputEdittext.setText(res)
            inputEdittext.setSelection(inputEdittext.text.length)
        }
    }

    private fun initView() {
        inputEdittext = findViewById(R.id.edt_input)
        zero = findViewById(R.id.btn_0)
        one = findViewById(R.id.btn_1)
        two = findViewById(R.id.btn_2)
        three = findViewById(R.id.btn_3)
        four = findViewById(R.id.btn_4)
        five = findViewById(R.id.btn_5)
        six = findViewById(R.id.btn_6)
        seven = findViewById(R.id.btn_7)
        eight = findViewById(R.id.btn_8)
        nine = findViewById(R.id.btn_9)

        add = findViewById(R.id.btn_add)
        sub = findViewById(R.id.btn_sub)
        mul = findViewById(R.id.btn_mul)
        div = findViewById(R.id.btn_div)
        dot = findViewById(R.id.btn_dot)
        equal = findViewById(R.id.btn_equal)
    }

    private fun evaluateExpression(expression: String): Double {
        return try {
            val exp = ExpressionBuilder(expression).build()
            exp.evaluate()
        } catch (e: Exception) {
            Double.NaN
        }
    }

    private fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}