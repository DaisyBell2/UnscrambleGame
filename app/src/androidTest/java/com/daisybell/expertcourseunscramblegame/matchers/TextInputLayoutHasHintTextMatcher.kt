package com.daisybell.expertcourseunscramblegame.matchers

import android.view.View
import androidx.annotation.StringRes
import androidx.test.espresso.matcher.BoundedMatcher
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description

/**
 * @author DaisyBell on 09.08.2024
 */
class TextInputLayoutHasHintTextMatcher(@StringRes private val textResId: Int) :
    BoundedMatcher<View, TextInputLayout>(TextInputLayout::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("hint doesn't match with expected $textResId")
    }

    override fun matchesSafely(item: TextInputLayout): Boolean {
        return item.hint == item.context.getString(textResId)
    }
}