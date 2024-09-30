package com.daisybell.expertcourseunscramblegame.views.visiblebutton

import com.daisybell.expertcourseunscramblegame.CheckUiState

interface UpdateVisibleEnabledButton {

    fun update(state: CheckUiState)

    fun update(visibility: Int, enabled: Boolean)
}