package com.daisybell.expertcourseunscramblegame

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.daisybell.expertcourseunscramblegame.game.GamePage
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ScenarioTest {

    @get:Rule
    val scenarioRule = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var gamePage: GamePage

    @Before
    fun setup() {
        gamePage = GamePage(word = "Hello".reversed())
    }

    /**
     * UGTC-01
     */
    @Test
    fun caseNumber1() {
        gamePage.assertInitialState()

        gamePage.addInputWord(text = "Hell")
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "o")
        gamePage.assertSufficientInputState()

        gamePage.clickCheck()
        gamePage.assertCorrectState()

        gamePage.clickNext()
        gamePage = GamePage(word = "Bye".reversed())
        gamePage.assertInitialState()
    }

    /**
     * UGTC-02
     */
    @Test
    fun caseNumber2() {
        gamePage.assertInitialState()

        gamePage.addInputWord(text = "Hell")
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "o")
        gamePage.assertSufficientInputState()

        gamePage.clickCheck()
        gamePage.assertIncorrectState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "Cat".reversed())
        gamePage.assertInitialState()
    }

    /**
     * UGTC-03
     */
    @Test
    fun caseNumber3() {
        gamePage.assertInitialState()

        gamePage.addInputWord(text = "Hel")
        gamePage.assertInsufficientInputState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "Animal".reversed())
        gamePage.assertInitialState()
    }

    /**
     * UGTC-04
     */
    @Test
    fun caseNumber4() {
        gamePage.assertInitialState()

        gamePage.addInputWord(text = "Hell")
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "o")
        gamePage.assertSufficientInputState()

        gamePage.removeInputLastLetter()
        gamePage.assertInsufficientInputState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "Dog".reversed())
        gamePage.assertInitialState()
    }

    /**
     * UGTC-05
     */
    @Test
    fun caseNumber5() {
        gamePage.assertInitialState()

        gamePage.addInputWord(text = "Hell")
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "o")
        gamePage.assertSufficientInputState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "Sky".reversed())
        gamePage.assertInitialState()
    }

    /**
     * UGTC-06
     */
    @Test
    fun caseNumber6() {
        gamePage.assertInitialState()

        gamePage.addInputWord(text = "Hell")
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "o")
        gamePage.assertSufficientInputState()

        gamePage.removeInputLastLetter()
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "o")
        gamePage.assertSufficientInputState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "Auto".reversed())
        gamePage.assertInitialState()
    }

    /**
     * UGTC-07
     */
    @Test
    fun caseNumber7() {
        gamePage.assertInitialState()

        gamePage.addInputWord(text = "Hell")
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "o")
        gamePage.assertSufficientInputState()

        gamePage.clickCheck()
        gamePage.assertIncorrectState()

        gamePage.removeInputLastLetter()
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "o")
        gamePage.assertSufficientInputState()

        gamePage.clickCheck()
        gamePage.assertCorrectState()

        gamePage.clickNext()
        gamePage = GamePage(word = "Awesome".reversed())
        gamePage.assertInitialState()
    }

    /**
     * UGTC-08
     */
    @Test
    fun caseNumber8() {
        gamePage.assertInitialState()

        gamePage.clickNext()
        gamePage = GamePage(word = "Queen".reversed())
        gamePage.assertInitialState()

        gamePage.clickNext()
        gamePage = GamePage(word = "Hero".reversed())
        gamePage.assertInitialState()
    }
}