package com.example.calculatorintentweb204

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    lateinit var butadd: Button
    lateinit var butsubtract: Button
    lateinit var butmultiplication: Button
    lateinit var butdivision: Button
    lateinit var edt_Fnum: EditText
    lateinit var edt_Snum: EditText
    lateinit var txt_answer: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        butadd = findViewById(R.id.btn_sum)
        butdivision = findViewById(R.id.btn_div)
        butmultiplication = findViewById(R.id.btn_multi)
        butsubtract = findViewById(R.id.btn_sub)
        edt_Fnum = findViewById(R.id.edit_1)
        edt_Snum = findViewById(R.id.edit_2)
        txt_answer = findViewById(R.id.txt_ans)

        butadd.setOnClickListener {
            var firstnum = edt_Fnum.text.toString()
            var secondnum = edt_Snum.text.toString()

            if (firstnum.isEmpty() or  secondnum.isEmpty()) {
                txt_answer.text = "please fill in all the details"
            } else {
                var answer = firstnum.toDouble() + secondnum.toDouble()
                txt_answer.text = answer.toString()
            }

        }
        butsubtract.setOnClickListener {
            var firstnum = edt_Fnum.text.toString()
            var secondnum = edt_Snum.text.toString()

            if (firstnum.isEmpty() and  secondnum.isEmpty()) {
                txt_answer.text = "please fill in all the details"
            } else {
                var answer = firstnum.toDouble() - secondnum.toDouble()
                txt_answer.text = answer.toString()
            }
        }
        butmultiplication.setOnClickListener {
            var firstnum = edt_Fnum.text.toString()
            var secondnum = edt_Snum.text.toString()

            if (firstnum.isEmpty() and   secondnum.isEmpty()) {
                txt_answer.text = "please fill in all the details"
            } else {
                var answer = firstnum.toDouble() * secondnum.toDouble()
                txt_answer.text = answer.toString()
            }

        }
        butdivision.setOnClickListener {
            var firstnum = edt_Fnum.text.toString()
            var secondnum = edt_Snum.text.toString()

            if (firstnum.isEmpty() and   secondnum.isEmpty()) {
                txt_answer.text = "please fill in all the details"
            } else {
                var answer = firstnum.toDouble() / secondnum.toDouble()
                txt_answer.text = answer.toString()
            }

        }
    }
}