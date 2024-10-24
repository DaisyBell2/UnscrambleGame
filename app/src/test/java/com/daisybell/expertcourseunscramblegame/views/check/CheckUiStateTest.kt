package com.daisybell.expertcourseunscramblegame.views.check

import android.view.View
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author DaisyBell on 24.10.2024
 */
class CheckUiStateTest {

    @Test
    fun testEnabled() {
        val enabled = CheckUiState.Enabled
        val button = FakeButton()

        enabled.update(button)

        assertEquals(View.VISIBLE, button.visibility)
        assertEquals(true, button.enabled)
    }

    @Test
    fun testDisabled() {
        val disabled = CheckUiState.Disabled
        val button = FakeButton()

        disabled.update(button)

        assertEquals(View.VISIBLE, button.visibility)
        assertEquals(false, button.enabled)
    }

    @Test
    fun testGone() {
        val gone = CheckUiState.Gone
        val button = FakeButton()

        gone.update(button)

        assertEquals(View.GONE, button.visibility)
        assertEquals(false, button.enabled)
    }

}

private class FakeButton : UpdateCheckButton {
    override fun update(state: CheckUiState) {
        throw IllegalStateException("not used here")
    }

    var visibility: Int? = null
    var enabled: Boolean? = null

    override fun update(visibility: Int, enabled: Boolean) {
        this.visibility = visibility
        this.enabled = enabled
    }

}