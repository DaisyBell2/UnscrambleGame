package com.daisybell.expertcourseunscramblegame

import com.daisybell.expertcourseunscramblegame.views.visiblebutton.VisibilityUiState
import com.daisybell.expertcourseunscramblegame.views.check.CheckUiState
import com.daisybell.expertcourseunscramblegame.views.check.UpdateCheckButton
import com.daisybell.expertcourseunscramblegame.views.input.InputUiState
import com.daisybell.expertcourseunscramblegame.views.input.UpdateInput
import com.daisybell.expertcourseunscramblegame.views.shuffledword.UpdateText
import com.daisybell.expertcourseunscramblegame.views.visiblebutton.UpdateVisibility

interface GameUiState {

    fun update(
        shuffleWordTextView: UpdateText,
        inputView: UpdateInput,
        skip: UpdateVisibility,
        check: UpdateCheckButton,
        next: UpdateVisibility,
    )

    object Empty : GameUiState {
        override fun update(
            shuffleWordTextView: UpdateText,
            inputView: UpdateInput,
            skip: UpdateVisibility,
            check: UpdateCheckButton,
            next: UpdateVisibility
        ) = Unit
    }

    abstract class Abstract(
        private val inputUiState: InputUiState,
        private val checkUiState: CheckUiState,
    ) : GameUiState {
        override fun update(
            shuffleWordTextView: UpdateText,
            inputView: UpdateInput,
            skip: UpdateVisibility,
            check: UpdateCheckButton,
            next: UpdateVisibility
        ) {
            inputView.update(inputUiState)
            check.update(checkUiState)
        }
    }

    data class Initial(
        private val shuffledWord: String,
        private val userInput: String = "",
    ) : Abstract(
        inputUiState = InputUiState.Initial(userInput),
        checkUiState = CheckUiState.Disabled,
    ) {
        override fun update(
            shuffleWordTextView: UpdateText,
            inputView: UpdateInput,
            skip: UpdateVisibility,
            check: UpdateCheckButton,
            next: UpdateVisibility
        ) {
            super.update(shuffleWordTextView, inputView, skip, check, next)
            shuffleWordTextView.update(shuffledWord)
            skip.update(VisibilityUiState.Visible)
            next.update(VisibilityUiState.Gone)
        }
    }

    object InsufficientInput : Abstract(
        inputUiState = InputUiState.EnabledNoError,
        checkUiState = CheckUiState.Disabled,
    )

    object SufficientInput : Abstract(
        inputUiState = InputUiState.EnabledNoError,
        checkUiState = CheckUiState.Enabled,
    )

    object Correct : Abstract(
        inputUiState = InputUiState.Correct,
        checkUiState = CheckUiState.Gone,
    ) {
        override fun update(
            shuffleWordTextView: UpdateText,
            inputView: UpdateInput,
            skip: UpdateVisibility,
            check: UpdateCheckButton,
            next: UpdateVisibility
        ) {
            super.update(shuffleWordTextView, inputView, skip, check, next)
            skip.update(VisibilityUiState.Invisible)
            next.update(VisibilityUiState.Visible)
        }
    }

    object InCorrect : Abstract(
        inputUiState = InputUiState.Incorrect,
        checkUiState = CheckUiState.Disabled,
    )

}


