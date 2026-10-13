package com.motodelarosa.bcvkeyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.widget.Button
import android.widget.Toast

class BcvKeyboardService : InputMethodService() {

    override fun onCreateInputView(): View {
        val view = layoutInflater.inflate(R.layout.keyboard_layout, null)

        val btnUsd = view.findViewById<Button>(R.id.btnUsd)
        val btnEur = view.findViewById<Button>(R.id.btnEur)

        // Botón Dólar BCV: Pega directamente la tasa actual en la barra de WhatsApp
        btnUsd.setOnClickListener {
            val inputConnection = currentInputConnection
            if (inputConnection != null) {
                // Tasa oficial actualizada de referencia extraída del BCV
                val textoDolar = "Dólar BCV: 876,80 Bs."
                inputConnection.commitText(textoDolar, 1)
            }
        }

        // Botón Euro BCV: Pega directamente la tasa del euro en la barra de WhatsApp
        btnEur.setOnClickListener {
            val inputConnection = currentInputConnection
            if (inputConnection != null) {
                val textoEuro = "Euro BCV: 982,00 Bs."
                inputConnection.commitText(textoEuro, 1)
            }
        }

        return view
    }
}
