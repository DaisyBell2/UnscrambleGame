package com.daisybell.expertcourseunscramblegame

import com.daisybell.expertcourseunscramblegame.views.input.edittext.UpdateTextInputEditText
import com.daisybell.expertcourseunscramblegame.views.input.layout.UpdateTextInputLayout
import com.daisybell.expertcourseunscramblegame.views.shuffledword.UpdateShuffleWordTextView
import com.daisybell.expertcourseunscramblegame.views.visiblebutton.UpdateVisibleEnabledButton
import java.io.Serializable

interface GameUiState : Serializable {

    fun update(
        shuffleWordTextView: UpdateShuffleWordTextView,
        textInputLayout: UpdateTextInputLayout,
        textInputEditText: UpdateTextInputEditText,
        skipVisibleEnabledButton: UpdateVisibleEnabledButton,
        checkVisibleEnabledButton: UpdateVisibleEnabledButton,
        nextVisibleEnabledButton: UpdateVisibleEnabledButton,
    )

    data class Initial(
        private val shuffledWord: String,
        private val userInput: String = "",
    ) : GameUiState {
        override fun update(
            shuffleWordTextView: UpdateShuffleWordTextView,
            textInputLayout: UpdateTextInputLayout,
            textInputEditText: UpdateTextInputEditText,
            skipVisibleEnabledButton: UpdateVisibleEnabledButton,
            checkVisibleEnabledButton: UpdateVisibleEnabledButton,
            nextVisibleEnabledButton: UpdateVisibleEnabledButton
        ) {
            shuffleWordTextView.update(shuffledWord)
            textInputLayout.update(InputUiState.Initial)
            textInputEditText.update(userInput)
            skipVisibleEnabledButton.update(CheckUiState.Visible)
            checkVisibleEnabledButton.update(CheckUiState.Disabled)
            nextVisibleEnabledButton.update(CheckUiState.Gone)
        }
    }

    object InsufficientInput : GameUiState {
        override fun update(
            shuffleWordTextView: UpdateShuffleWordTextView,
            textInputLayout: UpdateTextInputLayout,
            textInputEditText: UpdateTextInputEditText,
            skipVisibleEnabledButton: UpdateVisibleEnabledButton,
            checkVisibleEnabledButton: UpdateVisibleEnabledButton,
            nextVisibleEnabledButton: UpdateVisibleEnabledButton
        ) {
            textInputLayout.update(InputUiState.EnabledNoError)
            skipVisibleEnabledButton.update(CheckUiState.Visible)
            checkVisibleEnabledButton.update(CheckUiState.Disabled)
            nextVisibleEnabledButton.update(CheckUiState.Gone)
        }
    }

    object SufficientInput : GameUiState {
        override fun update(
            shuffleWordTextView: UpdateShuffleWordTextView,
            textInputLayout: UpdateTextInputLayout,
            textInputEditText: UpdateTextInputEditText,
            skipVisibleEnabledButton: UpdateVisibleEnabledButton,
            checkVisibleEnabledButton: UpdateVisibleEnabledButton,
            nextVisibleEnabledButton: UpdateVisibleEnabledButton
        ) {
            textInputLayout.update(InputUiState.EnabledNoError)
            skipVisibleEnabledButton.update(CheckUiState.Visible)
            checkVisibleEnabledButton.update(CheckUiState.Visible)
            nextVisibleEnabledButton.update(CheckUiState.Gone)
        }
    }

    object Correct : GameUiState {
        override fun update(
            shuffleWordTextView: UpdateShuffleWordTextView,
            textInputLayout: UpdateTextInputLayout,
            textInputEditText: UpdateTextInputEditText,
            skipVisibleEnabledButton: UpdateVisibleEnabledButton,
            checkVisibleEnabledButton: UpdateVisibleEnabledButton,
            nextVisibleEnabledButton: UpdateVisibleEnabledButton
        ) {
            textInputLayout.update(InputUiState.Correct)
            skipVisibleEnabledButton.update(CheckUiState.Invisible)
            checkVisibleEnabledButton.update(CheckUiState.Gone)
            nextVisibleEnabledButton.update(CheckUiState.Visible)
        }
    }

    object InCorrect : GameUiState {
        override fun update(
            shuffleWordTextView: UpdateShuffleWordTextView,
            textInputLayout: UpdateTextInputLayout,
            textInputEditText: UpdateTextInputEditText,
            skipVisibleEnabledButton: UpdateVisibleEnabledButton,
            checkVisibleEnabledButton: UpdateVisibleEnabledButton,
            nextVisibleEnabledButton: UpdateVisibleEnabledButton
        ) {
            textInputLayout.update(InputUiState.Incorrect)
            skipVisibleEnabledButton.update(CheckUiState.Visible)
            checkVisibleEnabledButton.update(CheckUiState.Disabled)
            nextVisibleEnabledButton.update(CheckUiState.Gone)
        }
    }

    object Empty : GameUiState {
        override fun update(
            shuffleWordTextView: UpdateShuffleWordTextView,
            textInputLayout: UpdateTextInputLayout,
            textInputEditText: UpdateTextInputEditText,
            skipVisibleEnabledButton: UpdateVisibleEnabledButton,
            checkVisibleEnabledButton: UpdateVisibleEnabledButton,
            nextVisibleEnabledButton: UpdateVisibleEnabledButton
        ) = Unit

    }

}


