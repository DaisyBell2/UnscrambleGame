package com.daisybell.expertcourseunscramblegame.game

import android.view.KeyEvent
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.pressKey
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isEnabled
import androidx.test.espresso.matcher.ViewMatchers.isNotEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.daisybell.expertcourseunscramblegame.R
import com.daisybell.expertcourseunscramblegame.matchers.TextInputLayoutErrorEnabledMatcher
import com.daisybell.expertcourseunscramblegame.matchers.TextInputLayoutHasErrorTextMatcher
import com.daisybell.expertcourseunscramblegame.matchers.TextInputLayoutHasHintTextMatcher
import com.daisybell.expertcourseunscramblegame.matchers.TextInputLayoutHintEnabledMatcher
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

class InputUi(
    containerIdMatcher: Matcher<View>,
    containerClassTypeMatcher: Matcher<View>
) {

    private val inputLayoutId: Int = R.id.inputLayout
    private val layoutInteraction: ViewInteraction = onView(
        allOf(
            containerIdMatcher,
            containerClassTypeMatcher,
            withId(inputLayoutId),
            isAssignableFrom(TextInputLayout::class.java)
        )
    )
    private val inputInteraction: ViewInteraction = onView(
        allOf(
            withId(R.id.inputEditText),
            isAssignableFrom(TextInputEditText::class.java)
        )
    )

    private val textInputLayoutErrorEnabledMatcherFalse = TextInputLayoutErrorEnabledMatcher(false)

    fun assertInitialState() {
        layoutInteraction
            .check(matches(isDisplayed()))
            .check(matches(isEnabled()))
            .check(matches(textInputLayoutErrorEnabledMatcherFalse))
            .check(matches(TextInputLayoutHasHintTextMatcher(R.string.hint_message)))
            .check(matches(TextInputLayoutHintEnabledMatcher(true)))
        inputInteraction
            .check(matches(withText("")))
    }

    fun addWord(text: String) {
        inputInteraction.perform(typeText(text), closeSoftKeyboard())
    }

    fun assertInsufficientInputState() {
        layoutInteraction
            .check(matches(isDisplayed()))
            .check(matches(isEnabled()))
            .check(matches(textInputLayoutErrorEnabledMatcherFalse))
            .check(matches(TextInputLayoutHasHintTextMatcher(R.string.hint_message)))
            .check(matches(TextInputLayoutHintEnabledMatcher(true)))

    }

    fun assertSufficientInputState() {
        layoutInteraction
            .check(matches(isDisplayed()))
            .check(matches(isEnabled()))
            .check(matches(textInputLayoutErrorEnabledMatcherFalse))
            .check(matches(TextInputLayoutHasHintTextMatcher(R.string.hint_message)))
            .check(matches(TextInputLayoutHintEnabledMatcher(true)))
    }

    fun assertCorrectState() {
        layoutInteraction
            .check(matches(isDisplayed()))
            .check(matches(isNotEnabled()))
            .check(matches(textInputLayoutErrorEnabledMatcherFalse))
            .check(matches(TextInputLayoutHasHintTextMatcher(R.string.hint_message)))
            .check(matches(TextInputLayoutHintEnabledMatcher(true)))
    }

    fun assertIncorrectState() {
        layoutInteraction
            .check(matches(isDisplayed()))
            .check(matches(isEnabled()))
            .check(matches(TextInputLayoutErrorEnabledMatcher(true)))
            .check(matches(TextInputLayoutHasErrorTextMatcher(R.string.incorrect_message)))
            .check(matches(TextInputLayoutHasHintTextMatcher(R.string.hint_message)))
            .check(matches(TextInputLayoutHintEnabledMatcher(true)))
    }

    fun removeLastLetter() {
        inputInteraction.perform(click(), pressKey(KeyEvent.KEYCODE_DEL), closeSoftKeyboard())
    }

}
