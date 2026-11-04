package com.example.evaluablepmdm

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //boton de volver
        val btnvolver = findViewById<Button>(R.id.volver)
        btnvolver.setOnClickListener {finish()}


        val accion = findViewById<Button>(R.id.accion)
        accion.setOnClickListener {
            val eje2 = Intent(this, Ejercicio2_2::class.java)
            val pendingintent = PendingIntent.getActivity(this, 0, eje2, PendingIntent.FLAG_IMMUTABLE)

            Handler(Looper.getMainLooper()).postDelayed({
                pendingintent.send()
            }, 10000)
            Toast.makeText(this, "se va a abrir la actividad 2.2 en 10 segundos", Toast.LENGTH_SHORT).show()

        }




    }
}