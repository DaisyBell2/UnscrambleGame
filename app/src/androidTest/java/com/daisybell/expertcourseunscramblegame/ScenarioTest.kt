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

    /*
     Phone
     Computer
     Hero
    */
    @Before
    fun setup() {
        gamePage = GamePage(word = "Phone".reversed())
    }

    /**
     * UGTC-01
     */
    @Test
    fun caseNumber1() {
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()

        gamePage.addInputWord(text = "Phon")
        gamePage.assertInsufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "e")
        gamePage.assertSufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertSufficientInputState()

        gamePage.clickCheck()
        gamePage.assertCorrectState()
        scenarioRule.scenario.recreate()
        gamePage.assertCorrectState()

        gamePage.clickNext()
        gamePage = GamePage(word = "Computer".reversed())
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()
    }

    /**
     * UGTC-02
     */
    @Test
    fun caseNumber2() {
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()

        gamePage.addInputWord(text = "Phon")
        gamePage.assertInsufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "a")
        gamePage.assertSufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertSufficientInputState()

        gamePage.clickCheck()
        gamePage.assertIncorrectState()
        scenarioRule.scenario.recreate()
        gamePage.assertIncorrectState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "Computer".reversed())
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()
    }

    /**
     * UGTC-03
     */
    @Test
    fun caseNumber3() {
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()

        gamePage.addInputWord(text = "Pho")
        gamePage.assertInsufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertInsufficientInputState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "Computer".reversed())
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()
    }

    /**
     * UGTC-04
     */
    @Test
    fun caseNumber4() {
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()

        gamePage.addInputWord(text = "Phon")
        gamePage.assertInsufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "e")
        gamePage.assertSufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertSufficientInputState()

        gamePage.removeInputLastLetter()
        gamePage.assertInsufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertInsufficientInputState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "Computer".reversed())
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()
    }

    /**
     * UGTC-05
     */
    @Test
    fun caseNumber5() {
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()

        gamePage.addInputWord(text = "Phon")
        gamePage.assertInsufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "e")
        gamePage.assertSufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertSufficientInputState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "Computer".reversed())
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()
    }

    /**
     * UGTC-06
     */
    @Test
    fun caseNumber6() {
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()

        gamePage.addInputWord(text = "Phon")
        gamePage.assertInsufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "e")
        gamePage.assertSufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertSufficientInputState()

        gamePage.removeInputLastLetter()
        gamePage.assertInsufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "e")
        gamePage.assertSufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertSufficientInputState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "Computer".reversed())
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()
    }

    /**
     * UGTC-07
     */
    @Test
    fun caseNumber7() {
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()

        gamePage.addInputWord(text = "Phon")
        gamePage.assertInsufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "a")
        gamePage.assertSufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertSufficientInputState()

        gamePage.clickCheck()
        gamePage.assertIncorrectState()
        scenarioRule.scenario.recreate()
        gamePage.assertIncorrectState()

        gamePage.removeInputLastLetter()
        gamePage.assertInsufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertInsufficientInputState()

        gamePage.addInputWord(text = "e")
        gamePage.assertSufficientInputState()
        scenarioRule.scenario.recreate()
        gamePage.assertSufficientInputState()

        gamePage.clickCheck()
        gamePage.assertCorrectState()
        scenarioRule.scenario.recreate()
        gamePage.assertCorrectState()

        gamePage.clickNext()
        gamePage = GamePage(word = "Computer".reversed())
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()
    }

    /**
     * UGTC-08
     */
    @Test
    fun caseNumber8() {
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "Computer".reversed())
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()

        gamePage.clickSkip()
        gamePage = GamePage(word = "Hero".reversed())
        gamePage.assertInitialState()
        scenarioRule.scenario.recreate()
        gamePage.assertInitialState()
    }
}