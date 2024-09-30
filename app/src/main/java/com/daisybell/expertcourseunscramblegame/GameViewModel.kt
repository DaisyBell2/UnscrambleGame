package com.daisybell.expertcourseunscramblegame

class GameViewModel(private val repository: GameRepository) {


    fun init(firstRun: Boolean = true): GameUiState =
        if (firstRun) {
            GameUiState.Initial(repository.shuffledWord(), repository.userInput())
        } else GameUiState.Empty


    fun handleUserInput(text: String): GameUiState {
        repository.saveUserInput(text)
        val shuffledWord = repository.shuffledWord()
        val isSufficient = text.length == shuffledWord.length

        return if (isSufficient) {
            GameUiState.SufficientInput
        } else {
            GameUiState.InsufficientInput
        }
    }

    fun check(text: String): GameUiState {
        val originalWord = repository.originalWord()

        val isCorrect = originalWord.equals(text, ignoreCase = true)

        return if (isCorrect) {
            GameUiState.Correct
        } else {
            GameUiState.InCorrect
        }
    }

    fun next(): GameUiState {
        repository.check()
        return init()
    }

    fun skip(): GameUiState {
        repository.check()
        return init()
    }

}
