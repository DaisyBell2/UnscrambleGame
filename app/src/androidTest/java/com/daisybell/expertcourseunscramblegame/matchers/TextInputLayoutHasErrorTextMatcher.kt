package com.daisybell.expertcourseunscramblegame.matchers

import android.view.View
import androidx.annotation.StringRes
import androidx.test.espresso.matcher.BoundedMatcher
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description

/**
 * @author DaisyBell on 09.08.2024
 */
class TextInputLayoutHasErrorTextMatcher(@StringRes private val errorResId: Int) :
    BoundedMatcher<View, TextInputLayout>(TextInputLayout::class.java) {

    override fun describeTo(description: Description) {
        description.appendText("error doesn't match with expected $errorResId")
    }

    override fun matchesSafely(item: TextInputLayout): Boolean {
        return item.error == item.context.getString(errorResId)
    }
}