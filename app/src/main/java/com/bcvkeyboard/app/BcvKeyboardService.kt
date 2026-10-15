package com.bcvkeyboard.app

import android.inputmethodservice.InputMethodService
import android.view.View
import android.widget.Button

class BcvKeyboardService : InputMethodService() {

    override fun onCreateInputView(): View {
        val view = layoutInflater.inflate(R.layout.keyboard_view, null)

        // Botón Dólar
        val btnDolar = view.findViewById<Button>(R.id.btn_dolar)
        btnDolar?.setOnClickListener {
            currentInputConnection?.commitText("Dólar: 37.00", 1)
        }

        // Botón Euro
        val btnEuro = view.findViewById<Button>(R.id.btn_euro)
        btnEuro?.setOnClickListener {
            currentInputConnection?.commitText("Euro: 40.20", 1)
        }

        // Botón Binance
        val btnBinance = view.findViewById<Button>(R.id.btn_binance)
        btnBinance?.setOnClickListener {
            currentInputConnection?.commitText("Binance: 37.20", 1)
        }

        // Teclas numéricas
        val btn7 = view.findViewById<Button>(R.id.btn_7)
        btn7?.setOnClickListener {
            currentInputConnection?.commitText("7", 1)
        }

        val btn8 = view.findViewById<Button>(R.id.btn_8)
        btn8?.setOnClickListener {
            currentInputConnection?.commitText("8", 1)
        }

        val btn9 = view.findViewById<Button>(R.id.btn_9)
        btn9?.setOnClickListener {
            currentInputConnection?.commitText("9", 1)
        }

        return view
    }
}
