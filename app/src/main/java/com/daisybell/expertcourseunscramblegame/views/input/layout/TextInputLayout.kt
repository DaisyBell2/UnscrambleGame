package com.daisybell.expertcourseunscramblegame.views.input.layout

/**
 * @author DaisyBell on 30.09.2024
 */
import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import com.daisybell.expertcourseunscramblegame.InputUiState
import com.daisybell.expertcourseunscramblegame.R
import com.google.android.material.textfield.TextInputLayout

class TextInputLayout : TextInputLayout, UpdateTextInputLayout {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private lateinit var uiState: InputUiState

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val savedState = TextInputLayoutSavedState(it)
            savedState.save(uiState)
            return savedState
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as TextInputLayoutSavedState
        super.onRestoreInstanceState(restoredState.superState)
        update(restoredState.restore())
    }

    override fun update(state: InputUiState) {
        uiState = state
        state.update(this)
    }

    override fun update(errorVisible: Boolean, enabled: Boolean) {
        isErrorEnabled = errorVisible
        if (errorVisible)
            error = this.context.getString(R.string.incorrect_message)
        isEnabled = enabled
    }
}