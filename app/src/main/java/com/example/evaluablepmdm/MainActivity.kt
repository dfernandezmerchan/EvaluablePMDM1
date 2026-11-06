package com.example.evaluablepmdm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val eje1 = findViewById<Button>(R.id.actividad1)
        val eje2 = findViewById<Button>(R.id.actividad2)
        val eje3 = findViewById<Button>(R.id.actividad3)
        val eje4 = findViewById<Button>(R.id.actividad4)
        val eje5 = findViewById<Button>(R.id.actividad5)
        val eje6 = findViewById<Button>(R.id.actividad6)

        eje1.setOnClickListener {
            startActivity(Intent(this, Ejercicio1::class.java))
        }

        eje2.setOnClickListener {
            startActivity(Intent(this, Ejercicio2::class.java))
        }

        eje3.setOnClickListener {
            startActivity(Intent(this, Ejercicio3::class.java))
        }

        eje4.setOnClickListener {
            startActivity(Intent(this, Ejercicio4::class.java))
        }






    }
}