package com.daisybell.expertcourseunscramblegame.views.input

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @author DaisyBell on 24.10.2024
 */
class InputUiStateTest {

    @Test
    fun testInitial() {
        val uiState = InputUiState.Initial("test")
        val sut = FakeInput()

        uiState.update(sut)

        assertEquals("test", sut.userInput)
        assertEquals(false, sut.errorVisible)
        assertEquals(true, sut.enabled)
    }

    @Test
    fun testEnabledNoError() {
        val uiState = InputUiState.EnabledNoError
        val sut = FakeInput()

        uiState.update(sut)

        assertEquals(false, sut.errorVisible)
        assertEquals(true, sut.enabled)
    }

    @Test
    fun testCorrect() {
        val uiState = InputUiState.Correct
        val sut = FakeInput()

        uiState.update(sut)

        assertEquals(false, sut.errorVisible)
        assertEquals(false, sut.enabled)
    }

    @Test
    fun testIncorrect() {
        val uiState = InputUiState.Incorrect
        val sut = FakeInput()

        uiState.update(sut)

        assertEquals(true, sut.errorVisible)
        assertEquals(true, sut.enabled)
    }

}

private class FakeInput : UpdateInput {

    override fun update(state: InputUiState) {
        throw IllegalStateException("not used here")
    }

    var userInput: String? = null
    var errorVisible: Boolean? = null
    var enabled: Boolean? = null

    override fun update(userInput: String) {
        this.userInput = userInput
    }

    override fun update(errorVisible: Boolean, enabled: Boolean) {
        this.errorVisible = errorVisible
        this.enabled = enabled
    }

}