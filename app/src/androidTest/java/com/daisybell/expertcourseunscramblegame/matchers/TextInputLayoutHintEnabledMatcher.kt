package com.daisybell.expertcourseunscramblegame.matchers

import android.view.View
import androidx.test.espresso.matcher.BoundedMatcher
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description

/**
 * @author DaisyBell on 09.08.2024
 */
class TextInputLayoutHintEnabledMatcher(private val expectingEnabled: Boolean) :
    BoundedMatcher<View, TextInputLayout>(TextInputLayout::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("hint enabled doesn't match with expected $expectingEnabled")
    }

    override fun matchesSafely(item: TextInputLayout): Boolean {
        return item.isHintEnabled == expectingEnabled
    }
}