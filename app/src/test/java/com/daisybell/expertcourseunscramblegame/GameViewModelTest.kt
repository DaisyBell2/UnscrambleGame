package com.daisybell.expertcourseunscramblegame

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class GameViewModelTest {

    private lateinit var viewModel: GameViewModel

    @Before
    fun setup() {
        viewModel = GameViewModel(repository = FakeRepository())
    }

    /**
     * UGTC-01
     */
    @Test
    fun caseNumber1() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phon")
        expected = GameUiState.InsufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phone")
        expected = GameUiState.SufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "Phone")
        expected = GameUiState.Correct(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = GameUiState.Initial(shuffledWord = "retupmoC")
        assertEquals(expected, actual)
    }

    /**
     * UGTC-02
     */
    @Test
    fun caseNumber2() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phon")
        expected = GameUiState.InsufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phona")
        expected = GameUiState.SufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "Phona")
        expected = GameUiState.InCorrect(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "retupmoC")
        assertEquals(expected, actual)
    }

    /**
     * UGTC-03
     */
    @Test
    fun caseNumber3() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phonas")
        expected = GameUiState.InsufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "retupmoC")
        assertEquals(expected, actual)
    }

    /**
     * UGTC-04
     */
    @Test
    fun caseNumber4() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phon")
        expected = GameUiState.InsufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phone")
        expected = GameUiState.SufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phones")
        expected = GameUiState.InsufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "retupmoC")
        assertEquals(expected, actual)
    }

    /**
     * UGTC-05
     */
    @Test
    fun caseNumber5() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phon")
        expected = GameUiState.InsufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phone")
        expected = GameUiState.SufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "retupmoC")
        assertEquals(expected, actual)
    }

    /**
     * UGTC-06
     */
    @Test
    fun caseNumber6() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phon")
        expected = GameUiState.InsufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phone")
        expected = GameUiState.SufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phoner")
        expected = GameUiState.InsufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phone")
        expected = GameUiState.SufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "retupmoC")
        assertEquals(expected, actual)
    }

    /**
     * UGTC-07
     */
    @Test
    fun caseNumber7() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phon")
        expected = GameUiState.InsufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phons")
        expected = GameUiState.SufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "Phons")
        expected = GameUiState.InCorrect(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phon")
        expected = GameUiState.InsufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phone")
        expected = GameUiState.SufficientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "Phone")
        expected = GameUiState.Correct(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = GameUiState.Initial(shuffledWord = "retupmoC")
        assertEquals(expected, actual)
    }

    /**
     * UGTC-08
     */
    @Test
    fun caseNumber8() {
        var actual: GameUiState = viewModel.init()
        var expected: GameUiState = GameUiState.Initial(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "retupmoC")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "oreH")
        assertEquals(expected, actual)
    }
}

private class FakeRepository : GameRepository {

    private var originalList = listOf(
        "Phone",
        "Computer",
        "Hero",
    )

    private var shuffledWord = originalList.map { word -> word.reversed() }

    private var index = 0

    override fun shuffledWord(): String = shuffledWord[index]

    override fun originalWord(): String = originalList[index]

    override fun check() {
        index++
        if (index == originalList.size) index = 0
        saveUserInput("")
    }

    private var userInput: String = ""

    override fun saveUserInput(value: String) {
        userInput = value
    }

    override fun userInput(): String = userInput

    /*
        "enohP",
        "retupmoC",
        "oreH",
     */
}