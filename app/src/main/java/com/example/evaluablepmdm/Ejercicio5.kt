package com.example.evaluablepmdm

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ejercicio5 : AppCompatActivity() {

    private lateinit var tvDisplay: TextView

    private var numeroAnterior = 0.0
    private var operacion = ""
    private var nuevoNumero = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio5)

        tvDisplay = findViewById(R.id.tvDisplay)

        // Números
        findViewById<Button>(R.id.btn0).setOnClickListener { pulsarNumero("0") }
        findViewById<Button>(R.id.btn1).setOnClickListener { pulsarNumero("1") }
        findViewById<Button>(R.id.btn2).setOnClickListener { pulsarNumero("2") }
        findViewById<Button>(R.id.btn3).setOnClickListener { pulsarNumero("3") }
        findViewById<Button>(R.id.btn4).setOnClickListener { pulsarNumero("4") }
        findViewById<Button>(R.id.btn5).setOnClickListener { pulsarNumero("5") }
        findViewById<Button>(R.id.btn6).setOnClickListener { pulsarNumero("6") }
        findViewById<Button>(R.id.btn7).setOnClickListener { pulsarNumero("7") }
        findViewById<Button>(R.id.btn8).setOnClickListener { pulsarNumero("8") }
        findViewById<Button>(R.id.btn9).setOnClickListener { pulsarNumero("9") }

        // Punto
        findViewById<Button>(R.id.btnPunto).setOnClickListener {
            pulsarPunto()
        }

        // Operaciones
        findViewById<Button>(R.id.btnSumar).setOnClickListener {
            pulsarOperacion("+")
        }

        findViewById<Button>(R.id.btnRestar).setOnClickListener {
            pulsarOperacion("-")
        }

        findViewById<Button>(R.id.btnMultiplicar).setOnClickListener {
            pulsarOperacion("*")
        }

        findViewById<Button>(R.id.btnDividir).setOnClickListener {
            pulsarOperacion("/")
        }

        // Igual
        findViewById<Button>(R.id.btnIgual).setOnClickListener {
            calcular()
        }

        // Borrar
        findViewById<Button>(R.id.btnReset).setOnClickListener {
            tvDisplay.text = "0"
            numeroAnterior = 0.0
            operacion = ""
            nuevoNumero = true
        }
    }

    private fun pulsarNumero(numero: String) {

        if (nuevoNumero) {
            tvDisplay.text = numero
            nuevoNumero = false
        } else {
            tvDisplay.append(numero)
        }
    }

    private fun pulsarPunto() {

        if (nuevoNumero) {
            tvDisplay.text = "0."
            nuevoNumero = false
        } else if (!tvDisplay.text.contains(".")) {
            tvDisplay.append(".")
        }
    }

    private fun pulsarOperacion(op: String) {

        numeroAnterior = tvDisplay.text.toString().toDouble()
        operacion = op
        nuevoNumero = true
    }

    private fun calcular() {

        val numeroActual = tvDisplay.text.toString().toDouble()
        var resultado = 0.0

        when (operacion) {

            "+" -> resultado = numeroAnterior + numeroActual
            "-" -> resultado = numeroAnterior - numeroActual
            "*" -> resultado = numeroAnterior * numeroActual
            "/" -> {
                if (numeroActual != 0.0) {
                    resultado = numeroAnterior / numeroActual
                } else {
                    tvDisplay.text = "Error"
                    nuevoNumero = true
                    return
                }
            }
        }

        tvDisplay.text = resultado.toString()
        nuevoNumero = true
    }
}