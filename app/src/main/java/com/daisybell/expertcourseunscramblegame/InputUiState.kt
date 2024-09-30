package com.daisybell.expertcourseunscramblegame

import com.daisybell.expertcourseunscramblegame.views.input.layout.UpdateTextInputLayout
import java.io.Serializable

interface InputUiState : Serializable {

    fun update(inputLayout: UpdateTextInputLayout)

    abstract class Abstract(
        private val errorVisible: Boolean,
        private val enabled: Boolean
    ) : InputUiState {
        override fun update(inputLayout: UpdateTextInputLayout, ) {
            inputLayout.update(errorVisible, enabled)
        }
    }

    object Initial : Abstract(false, true)

    object EnabledNoError : Abstract(false, true)

    object Correct : Abstract(false, false)

    object Incorrect : Abstract(true, true)
}