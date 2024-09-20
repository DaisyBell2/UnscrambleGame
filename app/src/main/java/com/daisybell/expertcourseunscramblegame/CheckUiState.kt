package com.daisybell.expertcourseunscramblegame

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import java.io.Serializable

interface CheckUiState : Serializable {
    fun update(button: AppCompatButton)

    abstract class Abstract(
        private val visible: Int,
        private val enabled: Boolean
    ) : CheckUiState {
        override fun update(button: AppCompatButton) = with(button) {
            visibility = visible
            isEnabled = enabled
        }
    }

    class Disabled : Abstract(View.VISIBLE, false)

    class Enabled : Abstract(View.VISIBLE, true)

    class Invisible : Abstract(View.GONE, false)
}