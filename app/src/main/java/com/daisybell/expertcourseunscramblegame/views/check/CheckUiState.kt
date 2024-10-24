package com.daisybell.expertcourseunscramblegame.views.check

import android.view.View
import java.io.Serializable

interface CheckUiState : Serializable {
    fun update(button: UpdateCheckButton)

    abstract class Abstract(
        private val visible: Int,
        private val enabled: Boolean = true
    ) : CheckUiState {
        override fun update(button: UpdateCheckButton) {
            button.update(visible, enabled)
        }
    }

    object Disabled : Abstract(View.VISIBLE, false)

    object Enabled : Abstract(View.VISIBLE, true)

    object Gone : Abstract(View.GONE, false)
}