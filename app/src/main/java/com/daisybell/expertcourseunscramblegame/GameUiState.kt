package com.daisybell.expertcourseunscramblegame

import com.daisybell.expertcourseunscramblegame.databinding.ActivityMainBinding

interface GameUiState {

    fun update(binding: ActivityMainBinding) {}

    data class Initial(val shuffledWord: String) : GameUiState {

    }

    data class InsufficientInput(val shuffledWord: String) : GameUiState {

    }

    data class SufficientInput(val shuffledWord: String) : GameUiState {

    }

    data class Correct(val shuffledWord: String) : GameUiState {

    }

    data class InCorrect(val shuffledWord: String) : GameUiState {

    }

}
