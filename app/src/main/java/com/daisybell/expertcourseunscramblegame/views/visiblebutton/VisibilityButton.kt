package com.daisybell.expertcourseunscramblegame.views.visiblebutton

import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton

/**
 * @author DaisyBell on 21.09.2024
 */
class VisibilityButton : AppCompatButton, UpdateVisibility {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private lateinit var uiState: VisibilityUiState

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val savedState = VisibilityButtonSavedState(it)
            savedState.save(uiState)
            return savedState
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoreState = state as VisibilityButtonSavedState
        super.onRestoreInstanceState(restoreState.superState)
        update(restoreState.restore())
    }

    override fun update(visibility: Int) {
        this.visibility = visibility
    }

    override fun update(state: VisibilityUiState) {
        this.uiState = state
        state.update(this)
    }

}

