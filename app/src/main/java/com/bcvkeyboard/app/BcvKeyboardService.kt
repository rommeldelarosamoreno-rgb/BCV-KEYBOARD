package com.bcvkeyboard.app

import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.view.View
import android.widget.Button

class BcvKeyboardService : InputMethodService(), KeyboardView.OnKeyboardActionListener {

    private lateinit var keyboardView: KeyboardView
    private lateinit var keyboard: Keyboard

    override fun onCreateInputView(): View {
        // Usamos la nueva referencia de layout: keyboard_layout
        val view = layoutInflater.inflate(R.layout.keyboard_layout, null)

        // Botón Dólar (Solo envía el número)
        val btnDolar = view.findViewById<Button>(R.id.btn_dolar)
        btnDolar?.setOnClickListener {
            currentInputConnection?.commitText("37.00", 1)
        }

        // Botón Euro (Solo envía el número)
        val btnEuro = view.findViewById<Button>(R.id.btn_euro)
        btnEuro?.setOnClickListener {
            currentInputConnection?.commitText("40.20", 1)
        }

        // Botón Binance (Solo envía el número)
        val btnBinance = view.findViewById<Button>(R.id.btn_binance)
        btnBinance?.setOnClickListener {
            currentInputConnection?.commitText("37.20", 1)
        }

        // Configurar Teclado con la nueva referencia de xml: qwerty_map
        keyboardView = view.findViewById(R.id.keyboard_view)
        keyboard = Keyboard(this, R.xml.qwerty_map)
        keyboardView.keyboard = keyboard
        keyboardView.isPreviewEnabled = false // Desactiva el cuadro blanco flotante
        keyboardView.setOnKeyboardActionListener(this)

        return view
    }

    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
        val ic = currentInputConnection ?: return
        when (primaryCode) {
            Keyboard.KEYCODE_DELETE -> {
                ic.deleteSurroundingText(1, 0)
            }
            10 -> { // Enter / Línea nueva
                ic.sendKeyEvent(android.view.KeyEvent(android.view.KeyEvent.ACTION_DOWN, android.view.KeyEvent.KEYCODE_ENTER))
                ic.sendKeyEvent(android.view.KeyEvent(android.view.KeyEvent.ACTION_UP, android.view.KeyEvent.KEYCODE_ENTER))
            }
            else -> {
                val code = primaryCode.toChar()
                ic.commitText(code.toString(), 1)
            }
        }
    }

    override fun onPress(primaryCode: Int) {}
    override fun onRelease(primaryCode: Int) {}
    override fun onText(text: CharSequence?) {
        currentInputConnection?.commitText(text, 1)
    }
    override fun swipeLeft() {}
    override fun swipeRight() {}
    override fun swipeDown() {}
    override fun swipeUp() {}
}
