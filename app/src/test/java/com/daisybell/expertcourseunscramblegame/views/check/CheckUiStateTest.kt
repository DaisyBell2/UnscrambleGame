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
        val uiState = CheckUiState.Enabled
        val sut = FakeButton()

        uiState.update(sut)

        assertEquals(View.VISIBLE, sut.visibility)
        assertEquals(true, sut.enabled)
    }

    @Test
    fun testDisabled() {
        val uiState = CheckUiState.Disabled
        val sut = FakeButton()

        uiState.update(sut)

        assertEquals(View.VISIBLE, sut.visibility)
        assertEquals(false, sut.enabled)
    }

    @Test
    fun testGone() {
        val uiState = CheckUiState.Gone
        val sut = FakeButton()

        uiState.update(sut)

        assertEquals(View.GONE, sut.visibility)
        assertEquals(false, sut.enabled)
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