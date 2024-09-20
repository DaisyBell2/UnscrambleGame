package com.daisybell.expertcourseunscramblegame

import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.io.Serializable

interface InputUiState : Serializable {

    fun update(inputLayout: TextInputLayout, inputEditText: TextInputEditText)

    abstract class Abstract(
        private val errorVisible: Boolean,
        private val enabled: Boolean
    ) : InputUiState {
        override fun update(inputLayout: TextInputLayout, inputEditText: TextInputEditText) {
            inputLayout.isErrorEnabled = errorVisible
            if (errorVisible)
                inputLayout.error = inputLayout.context.getString(R.string.incorrect_message)
            inputLayout.isEnabled = enabled
        }
    }

    data class Initial(private val userInput: String) : Abstract(false, true) {
        override fun update(inputLayout: TextInputLayout, inputEditText: TextInputEditText) {
            super.update(inputLayout, inputEditText)
            inputEditText.setText(userInput)
        }
    }

    class EnabledNoError : Abstract(false, true)

    class Correct : Abstract(false, false)

    class Incorrect : Abstract(true, true)
}