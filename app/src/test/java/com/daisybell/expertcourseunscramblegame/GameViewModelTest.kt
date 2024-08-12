package com.daisybell.expertcourseunscramblegame

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class GameViewModelTest {

    private lateinit var viewModel: GameViewModel

    @Before
    fun setup() {
        viewModel = GameViewModel(repository = FakeRepository)
    }

    /**
     * UGTC-01
     */
    @Test
    fun caseNumber1() {
        val actual: GameUiState = viewModel.init()
        val expected: GameUiState = GameUiState.Initial(shuffledWord = "olleH")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Hell")
        expected = GameUiState.InsuffientInput(shuffledWord = "olleH")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Hello")
        expected = GameUiState.SuffientInput(shuffledWord = "olleH")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "Hello")
        expected = GameUiState.Correct(shuffledWord = "olleH")
        assertEquals(expected, actual)

        actual = viewModel.next()
        expected = GameUiState.Initial(shuffledWord = "eyB")
        assertEquals(expected, actual)
    }

    /**
     * UGTC-02
     */
    @Test
    fun caseNumber2() {
        val actual: GameUiState = viewModel.init()
        val expected: GameUiState = GameUiState.Initial(shuffledWord = "laminA")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Anima")
        expected = GameUiState.InsuffientInput(shuffledWord = "laminA")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Animas")
        expected = GameUiState.SuffientInput(shuffledWord = "laminA")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "Animas")
        expected = GameUiState.InCorrect(shuffledWord = "laminA")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "taC")
        assertEquals(expected, actual)
    }

    /**
     * UGTC-03
     */
    @Test
    fun caseNumber3() {
        val actual: GameUiState = viewModel.init()
        val expected: GameUiState = GameUiState.Initial(shuffledWord = "otuA")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Aut")
        expected = GameUiState.InsuffientInput(shuffledWord = "otuA")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "emosewA")
        assertEquals(expected, actual)
    }

    /**
     * UGTC-04
     */
    @Test
    fun caseNumber4() {
        val actual: GameUiState = viewModel.init()
        val expected: GameUiState = GameUiState.Initial(shuffledWord = "neeuQ")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Quee")
        expected = GameUiState.InsuffientInput(shuffledWord = "neeuQ")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Queen")
        expected = GameUiState.SuffientInput(shuffledWord = "neeuQ")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Quee")
        expected = GameUiState.InsuffientInput(shuffledWord = "neeuQ")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "oreH")
        assertEquals(expected, actual)
    }

    /**
     * UGTC-05
     */
    @Test
    fun caseNumber5() {
        val actual: GameUiState = viewModel.init()
        val expected: GameUiState = GameUiState.Initial(shuffledWord = "ykS")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Sk")
        expected = GameUiState.InsuffientInput(shuffledWord = "ykS")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Sky")
        expected = GameUiState.SuffientInput(shuffledWord = "ykS")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "goD")
        assertEquals(expected, actual)
    }

    /**
     * UGTC-06
     */
    @Test
    fun caseNumber6() {
        val actual: GameUiState = viewModel.init()
        val expected: GameUiState = GameUiState.Initial(shuffledWord = "ekaC")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Cak")
        expected = GameUiState.InsuffientInput(shuffledWord = "ekaC")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Cake")
        expected = GameUiState.SuffientInput(shuffledWord = "ekaC")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Cakes")
        expected = GameUiState.InsuffientInput(shuffledWord = "ekaC")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Cake")
        expected = GameUiState.SuffientInput(shuffledWord = "ekaC")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "ydnaC")
        assertEquals(expected, actual)
    }

    /**
     * UGTC-07
     */
    @Test
    fun caseNumber7() {
        val actual: GameUiState = viewModel.init()
        val expected: GameUiState = GameUiState.Initial(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phon")
        expected = GameUiState.InsuffientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phons")
        expected = GameUiState.SuffientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "Phons")
        expected = GameUiState.InCorrect(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phon")
        expected = GameUiState.InsuffientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.handleUserInput(text = "Phone")
        expected = GameUiState.SuffientInput(shuffledWord = "enohP")
        assertEquals(expected, actual)

        actual = viewModel.check(text = "Phone")
        expected = GameUiState.InCorrect(shuffledWord = "enohP")
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
        val actual: GameUiState = viewModel.init()
        val expected: GameUiState = GameUiState.Initial(shuffledWord = "retaW")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "taoB")
        assertEquals(expected, actual)

        actual = viewModel.skip()
        expected = GameUiState.Initial(shuffledWord = "hctaW")
        assertEquals(expected, actual)
    }
}

private class FakeRepository : GameRepository {

    private var originalList = listOf(
        "Hello",
        "Bye",
        "Animal",
        "Cat",
        "Auto",
        "Awesome",
        "Queen",
        "Hero",
        "Sky",
        "Dog",
        "Cake",
        "Candy",
        "Phone",
        "Computer",
        "Water",
        "Boat",
        "Watch"
    )

    private var shuffledWord = originalList.map { word -> word.reversed() }

    private var index = 0

    override fun shuffledWord(): String = shuffledWord[index]

    override fun originalWord(): String = originalList[index]

    override fun check() {
        index++
        if (index == originalList.size) index = 0
    }

    /*
        "olleH",
        "eyB",
        "laminA",
        "taC",
        "otuA",
        "emosewA",
        "neeuQ",
        "oreH",
        "ykS",
        "goD",
        "ekaC",
        "ydnaC",
        "enohP",
        "retupmoC",
        "retaW",
        "taoB",
        "hctaW"
     */
}