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

    private fun ActivityScenarioRule<*>.doWithRecreate(block: () -> Unit) {
        block.invoke()
        scenario.recreate()
        block.invoke()
    }

    /**
     * UGTC-01
     */
    @Test
    fun caseNumber1() {
        scenarioRule.doWithRecreate(gamePage::assertInitialState)

        gamePage.addInputWord(text = "Phon")
        scenarioRule.doWithRecreate(gamePage::assertInsufficientInputState)

        gamePage.addInputWord(text = "e")
        scenarioRule.doWithRecreate(gamePage::assertSufficientInputState)

        gamePage.clickCheck()
        scenarioRule.doWithRecreate(gamePage::assertCorrectState)

        gamePage.clickNext()
        gamePage = GamePage(word = "Computer".reversed())
        scenarioRule.doWithRecreate(gamePage::assertInitialState)
    }

    /**
     * UGTC-02
     */
    @Test
    fun caseNumber2() {
        scenarioRule.doWithRecreate(gamePage::assertInitialState)

        gamePage.addInputWord(text = "Phon")
        scenarioRule.doWithRecreate(gamePage::assertInsufficientInputState)

        gamePage.addInputWord(text = "a")
        scenarioRule.doWithRecreate(gamePage::assertSufficientInputState)

        gamePage.clickCheck()
        scenarioRule.doWithRecreate(gamePage::assertIncorrectState)

        gamePage.clickSkip()
        gamePage = GamePage(word = "Computer".reversed())
        scenarioRule.doWithRecreate(gamePage::assertInitialState)
    }

    /**
     * UGTC-03
     */
    @Test
    fun caseNumber3() {
        scenarioRule.doWithRecreate(gamePage::assertInitialState)

        gamePage.addInputWord(text = "Pho")
        scenarioRule.doWithRecreate(gamePage::assertInsufficientInputState)

        gamePage.clickSkip()
        gamePage = GamePage(word = "Computer".reversed())
        scenarioRule.doWithRecreate(gamePage::assertInitialState)
    }

    /**
     * UGTC-04
     */
    @Test
    fun caseNumber4() {
        scenarioRule.doWithRecreate(gamePage::assertInitialState)

        gamePage.addInputWord(text = "Phon")
        scenarioRule.doWithRecreate(gamePage::assertInsufficientInputState)

        gamePage.addInputWord(text = "e")
        scenarioRule.doWithRecreate(gamePage::assertSufficientInputState)

        gamePage.removeInputLastLetter()
        scenarioRule.doWithRecreate(gamePage::assertInsufficientInputState)

        gamePage.clickSkip()
        gamePage = GamePage(word = "Computer".reversed())
        scenarioRule.doWithRecreate(gamePage::assertInitialState)
    }

    /**
     * UGTC-05
     */
    @Test
    fun caseNumber5() {
        scenarioRule.doWithRecreate(gamePage::assertInitialState)

        gamePage.addInputWord(text = "Phon")
        scenarioRule.doWithRecreate(gamePage::assertInsufficientInputState)

        gamePage.addInputWord(text = "e")
        scenarioRule.doWithRecreate(gamePage::assertSufficientInputState)

        gamePage.clickSkip()
        gamePage = GamePage(word = "Computer".reversed())
        scenarioRule.doWithRecreate(gamePage::assertInitialState)
    }

    /**
     * UGTC-06
     */
    @Test
    fun caseNumber6() {
        scenarioRule.doWithRecreate(gamePage::assertInitialState)

        gamePage.addInputWord(text = "Phon")
        scenarioRule.doWithRecreate(gamePage::assertInsufficientInputState)

        gamePage.addInputWord(text = "e")
        scenarioRule.doWithRecreate(gamePage::assertSufficientInputState)

        gamePage.removeInputLastLetter()
        scenarioRule.doWithRecreate(gamePage::assertInsufficientInputState)

        gamePage.addInputWord(text = "e")
        scenarioRule.doWithRecreate(gamePage::assertSufficientInputState)

        gamePage.clickSkip()
        gamePage = GamePage(word = "Computer".reversed())
        scenarioRule.doWithRecreate(gamePage::assertInitialState)
    }

    /**
     * UGTC-07
     */
    @Test
    fun caseNumber7() {
        scenarioRule.doWithRecreate(gamePage::assertInitialState)

        gamePage.addInputWord(text = "Phon")
        scenarioRule.doWithRecreate(gamePage::assertInsufficientInputState)

        gamePage.addInputWord(text = "a")
        scenarioRule.doWithRecreate(gamePage::assertSufficientInputState)

        gamePage.clickCheck()
        scenarioRule.doWithRecreate(gamePage::assertIncorrectState)

        gamePage.removeInputLastLetter()
        scenarioRule.doWithRecreate(gamePage::assertInsufficientInputState)

        gamePage.addInputWord(text = "e")
        scenarioRule.doWithRecreate(gamePage::assertSufficientInputState)

        gamePage.clickCheck()
        scenarioRule.doWithRecreate(gamePage::assertCorrectState)

        gamePage.clickNext()
        gamePage = GamePage(word = "Computer".reversed())
        scenarioRule.doWithRecreate(gamePage::assertInitialState)
    }

    /**
     * UGTC-08
     */
    @Test
    fun caseNumber8() {
        scenarioRule.doWithRecreate(gamePage::assertInitialState)

        gamePage.clickSkip()
        gamePage = GamePage(word = "Computer".reversed())
        scenarioRule.doWithRecreate(gamePage::assertInitialState)

        gamePage.clickSkip()
        gamePage = GamePage(word = "Hero".reversed())
        scenarioRule.doWithRecreate(gamePage::assertInitialState)
    }
}