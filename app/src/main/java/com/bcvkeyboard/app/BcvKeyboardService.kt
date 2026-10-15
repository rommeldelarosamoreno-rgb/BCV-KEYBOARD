Kotlin


package com.bcvkeyboard.app

import android.inputmethodservice.InputMethodService
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class BcvKeyboardService : InputMethodService() {

    private lateinit var tvCalcPreview: TextView
    private var currentInput: String = ""

    override fun onCreateInputView(): View {
        val view = layoutInflater.inflate(R.layout.keyboard_view, null)

        tvCalcPreview = view.findViewById(R.id.tvCalcPreview)
        val btnUsdBcv = view.findViewById<Button>(R.id.btnUsdBcv)
        val btnEurBcv = view.findViewById<Button>(R.id.btnEurBcv)
        val btnBinanceP2p = view.findViewById<Button>(R.id.btnBinanceP2p)

        // Acción Botón USD BCV (Inserta la tasa de ejemplo o simulada)
        btnUsdBcv.setOnClickListener {
            insertText("36.50") // Ejemplo de tasa BCV USD
        }

        // Acción Botón EUR BCV
        btnEurBcv.setOnClickListener {
            insertText("39.80") // Ejemplo de tasa BCV EUR
        }

        // Acción Botón Binance P2P (Función Premium / Bloqueo o aviso)
        btnBinanceP2p.setOnClickListener {
            insertText("37.20 [P2P]") // Ejemplo tasa Binance
        }

        // Simulación de la calculadora predictiva básica (Gratuita)
        tvCalcPreview.setOnClickListener {
            // Si el usuario toca la sugerencia de cálculo, inserta el resultado simulado
            insertText("50.00")
        }

        return view
    }

    private fun insertText(text: String) {
        val ic = currentInputConnection
        ic?.commitText(text, 1)
    }

    override fun onStartInputView(info: EditorInfo?, restarting: Boolean) {
        super.onStartInputView(info, restarting)
        // Reiniciar estado al abrir el teclado en una app como WhatsApp
        currentInput = ""
        tvCalcPreview.text = "Calculadora lista (ej: 5*10)"
    }
}
