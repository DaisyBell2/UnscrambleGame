package com.daisybell.expertcourseunscramblegame.views.input.layout

import com.daisybell.expertcourseunscramblegame.InputUiState

interface UpdateTextInputLayout {

    fun update(state: InputUiState)

    fun update(errorVisible: Boolean, enabled: Boolean)
}