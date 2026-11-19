package com.technischools.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var odkurzaczWlaczony = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editNumerPrania = findViewById<EditText>(R.id.editNumerPrania)
        val textNumerPrania = findViewById<TextView>(R.id.textNumerPrania)
        val buttonOdkurzacz = findViewById<Button>(R.id.buttonOdkurzacz)
        val textStanOdkurzacza = findViewById<TextView>(R.id.textStanOdkurzacza)

        findViewById<Button>(R.id.buttonZatwierdz).setOnClickListener {
            val numerPrania = editNumerPrania.text.toString().toIntOrNull()
            if (numerPrania != null && numerPrania in 1..12) {
                textNumerPrania.text = "Numer prania: $numerPrania"
            }
        }

        buttonOdkurzacz.setOnClickListener {
            odkurzaczWlaczony = !odkurzaczWlaczony
            buttonOdkurzacz.text = if (odkurzaczWlaczony) "Wyłącz" else "Włącz"
            textStanOdkurzacza.text = if (odkurzaczWlaczony) "Odkurzacz włączony" else "Odkurzacz wyłączony"
        }
    }
}
