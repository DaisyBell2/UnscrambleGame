package com.daisybell.expertcourseunscramblegame.views.check

interface UpdateCheckButton {

    fun update(state: CheckUiState)

    fun update(visibility: Int, enabled: Boolean)
}