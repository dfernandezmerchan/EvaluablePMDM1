package com.example.evaluablepmdm

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.URLUtil
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio1 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //boton volver atras
        val btnvolver = findViewById<Button>(R.id.volver)
        btnvolver.setOnClickListener {finish()}

        val botonabrir = findViewById<Button>(R.id.abrirutrl)
        val textourl = findViewById<EditText>(R.id.campodetextourl)


        botonabrir.setOnClickListener {
            val texto = textourl.text.toString()
            if (texto.isEmpty() || !URLUtil.isValidUrl(texto)) {

                Toast.makeText( this , "por favot introduce una url valida", Toast.LENGTH_SHORT).show()

            } else {
                val abrirurl = Intent(Intent.ACTION_VIEW, Uri.parse(texto))
                startActivity(abrirurl)

            }

        }







    }
}