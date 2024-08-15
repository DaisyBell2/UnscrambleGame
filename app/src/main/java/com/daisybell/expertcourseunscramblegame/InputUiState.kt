package com.daisybell.expertcourseunscramblegame

import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

interface InputUiState {

    fun update(inputLayout: TextInputLayout, inputEditText: TextInputEditText)

    abstract class Abstract(
        private val clearText: Boolean,
        private val errorVisible: Boolean,
        private val enabled: Boolean
    ) : InputUiState {
        override fun update(inputLayout: TextInputLayout, inputEditText: TextInputEditText) {
            inputLayout.isErrorEnabled = errorVisible
            if (errorVisible)
                inputLayout.error = inputLayout.context.getString(R.string.incorrect_message)
            inputLayout.isEnabled = enabled
            if (clearText)
                inputEditText.setText(R.string.empty)
        }
    }

    object Initial : Abstract(true, false, true)

    object EnabledNoError : Abstract(false, false, true)

    object Correct : Abstract(false, false, false)

    object Incorrect : Abstract(false, true, true)
}