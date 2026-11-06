package com.example.evaluablepmdm

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java

class Ejercicio3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnvolver = findViewById<Button>(R.id.volver)
        btnvolver.setOnClickListener {finish()}

        findViewById<Button>(R.id.btnPantalla1).setOnClickListener {
            startActivity(Intent(this, ej3_1::class.java))
        }
        findViewById<Button>(R.id.btnPantalla2).setOnClickListener {
            startActivity(Intent(this, ej3_2::class.java))
        }
        findViewById<Button>(R.id.btnPantalla3).setOnClickListener {
            startActivity(Intent(this, ej3_3::class.java))
        }

    }
}