package com.daisybell.expertcourseunscramblegame

import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.io.Serializable

interface InputUiState : Serializable {

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

    class Initial : Abstract(true, false, true)

    class EnabledNoError : Abstract(false, false, true)

    class Correct : Abstract(false, false, false)

    class Incorrect : Abstract(false, true, true)
}