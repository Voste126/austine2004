package com.example.calculatorintentweb204

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var Buttoncalc:Button ?=null
    var Buttonintent:Button ?=null
    var Buttonweb:Button ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Buttoncalc=findViewById(R.id.btn_calculator)
        Buttonintent=findViewById(R.id.btn_intent)
        Buttonweb=findViewById(R.id.btn_web)


        Buttonintent!!.setOnClickListener {
            val intent=Intent(this,intentactivity::class.java)
            startActivity(intent)
        }
        Buttonweb!!.setOnClickListener {
            val web=Intent(this,webactivity::class.java)
            startActivity(web)
        }
        Buttoncalc!!.setOnClickListener {
            val calculator=Intent(this,CalculatorActivity::class.java)
            startActivity(calculator)
        }
    }
}