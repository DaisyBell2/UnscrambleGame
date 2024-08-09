package com.daisybell.expertcourseunscramblegame.game

import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isNotEnabled
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.daisybell.expertcourseunscramblegame.R
import com.daisybell.expertcourseunscramblegame.matchers.ButtonColorMatcher
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matcher

class CheckButtonUi(containerIdMatcher: Matcher<View>, containerClassTypeMatcher: Matcher<View>) :
    AbstractButton(
        onView(
            allOf(
                containerIdMatcher,
                containerClassTypeMatcher,
                withId(R.id.checkButton),
                withText(R.string.check),
                ButtonColorMatcher("#DF61FF"),
                isAssignableFrom(AppCompatButton::class.java),
            )
        )
    ) {
    fun assertVisibleDisabled() {
        interaction
            .check(matches(isDisplayed()))
            .check(matches(isNotEnabled()))
    }

}
