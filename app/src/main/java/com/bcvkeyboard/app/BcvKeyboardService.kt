package com.bcvkeyboard.app

import android.inputmethodservice.InputMethodService
import android.view.View
import android.widget.Button

class BcvKeyboardService : InputMethodService() {

    override fun onCreateInputView(): View {
        val view = layoutInflater.inflate(R.layout.keyboard_view, null)

        val btnBcv = view.findViewById<Button>(R.id.btn_bcv_rate)
        btnBcv.text = "BCV: Bs. 36.50 (Pegar)"
        
        btnBcv.setOnClickListener {
            val ic = currentInputConnection
            ic?.commitText("Bs. 36.50", 1)
        }

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
