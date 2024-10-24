package com.daisybell.expertcourseunscramblegame.views.input

interface UpdateInput {

    fun update(state: InputUiState)

    fun update(userInput: String)

    fun update(errorVisible: Boolean, enabled: Boolean)
}