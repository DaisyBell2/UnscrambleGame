package com.daisybell.expertcourseunscramblegame

import android.view.View
import com.daisybell.expertcourseunscramblegame.views.visiblebutton.UpdateVisibleEnabledButton
import java.io.Serializable

interface CheckUiState : Serializable {
    fun update(button: UpdateVisibleEnabledButton)

    abstract class Abstract(
        private val visible: Int,
        private val enabled: Boolean = true
    ) : CheckUiState {
        override fun update(button: UpdateVisibleEnabledButton) {
            button.update(visible, enabled)
        }
    }

    object Disabled : Abstract(View.VISIBLE, false)

    object Visible : Abstract(View.VISIBLE, true)

    object Invisible : Abstract(View.INVISIBLE, false)

    object Gone : Abstract(View.GONE, false)
}