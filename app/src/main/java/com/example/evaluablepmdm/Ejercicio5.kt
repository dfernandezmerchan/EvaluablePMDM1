package com.example.evaluablepmdm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class Ejercicio5 : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private var valorAnterior = Double.NaN
    private var operacionActual = ""
    private var nuevaOperacion = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio5)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvDisplay = findViewById(R.id.tvDisplay)

        // 1. Configurar los botones numéricos (0-9) en bucle para ahorrar código
        val botonesNumeros = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        for (id in botonesNumeros) {
            findViewById<Button>(id).setOnClickListener { boton ->
                alPulsarNumero((boton as Button).text.toString())
            }
        }

        // 2. Configurar botón de punto decimal
        findViewById<Button>(R.id.btnPunto).setOnClickListener { alPulsarPunto() }

        // 3. Configurar botones de operaciones
        findViewById<Button>(R.id.btnSumar).setOnClickListener { alPulsarOperacion("+") }
        findViewById<Button>(R.id.btnRestar).setOnClickListener { alPulsarOperacion("-") }
        findViewById<Button>(R.id.btnMultiplicar).setOnClickListener { alPulsarOperacion("*") }
        findViewById<Button>(R.id.btnDividir).setOnClickListener { alPulsarOperacion("/") }

        // 4. Configurar botón de igual (=)
        findViewById<Button>(R.id.btnIgual).setOnClickListener {
            calcularResultado()
            operacionActual = "" // Resetea la operación tras calcular
        }

        // 5. Configurar botón de Reset (C)
        findViewById<Button>(R.id.btnReset).setOnClickListener {
            valorAnterior = Double.NaN
            operacionActual = ""
            tvDisplay.text = "0"
            nuevaOperacion = true
        }
    }

    private fun alPulsarNumero(numero: String) {
        if (nuevaOperacion) {
            tvDisplay.text = numero
            nuevaOperacion = false
        } else {
            tvDisplay.append(numero)
        }
    }

    private fun alPulsarPunto() {
        if (nuevaOperacion) {
            tvDisplay.text = "0."
            nuevaOperacion = false
        } else if (!tvDisplay.text.contains(".")) {
            tvDisplay.append(".")
        }
    }

    private fun alPulsarOperacion(operacion: String) {
        if (!valorAnterior.isNaN()) {
            calcularResultado()
        }

        // Guardamos el número actual en pantalla y la operación a realizar
        valorAnterior = tvDisplay.text.toString().toDoubleOrNull() ?: Double.NaN
        operacionActual = operacion
        nuevaOperacion = true // El siguiente número pulsado borrará la pantalla
    }

    private fun calcularResultado() {
        if (valorAnterior.isNaN() || operacionActual.isEmpty()) return

        val valorActual = tvDisplay.text.toString().toDoubleOrNull() ?: return
        var resultado = 0.0

        when (operacionActual) {
            "+" -> resultado = valorAnterior + valorActual
            "-" -> resultado = valorAnterior - valorActual
            "*" -> resultado = valorAnterior * valorActual
            "/" -> {
                if (valorActual != 0.0) {
                    resultado = valorAnterior / valorActual
                } else {
                    tvDisplay.text = "Error"
                    nuevaOperacion = true
                    return
                }
            }
        }

        // Formatear el resultado para quitar el ".0" si el número es entero (ej. 5.0 -> 5)
        val formato = DecimalFormat("#.####")
        tvDisplay.text = formato.format(resultado)

        valorAnterior = resultado
        nuevaOperacion = true
    }
}
