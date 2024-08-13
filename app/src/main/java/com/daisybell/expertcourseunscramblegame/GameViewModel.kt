package com.daisybell.expertcourseunscramblegame

class GameViewModel(private val repository: GameRepository) {


    fun init(): GameUiState {
        return GameUiState.Initial(repository.shuffledWord())
    }

    fun handleUserInput(text: String): GameUiState {
        val shuffledWord = repository.shuffledWord()
        val isSufficient = text.length == shuffledWord.length

        return if (isSufficient) {
            GameUiState.SufficientInput(shuffledWord)
        } else {
            GameUiState.InsufficientInput(shuffledWord)
        }
    }

    fun check(text: String): GameUiState {
        val shuffledWord = repository.shuffledWord()
        val originalWord = repository.originalWord()

        val isCorrect = originalWord.equals(text, ignoreCase = true)

        return if (isCorrect) {
            GameUiState.Correct(shuffledWord)
        } else {
            GameUiState.InCorrect(shuffledWord)
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
