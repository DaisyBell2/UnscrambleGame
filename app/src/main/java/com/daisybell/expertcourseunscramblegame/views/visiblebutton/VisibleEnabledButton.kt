package com.daisybell.expertcourseunscramblegame.views.visiblebutton

/**
 * @author DaisyBell on 30.09.2024
 */
import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.daisybell.expertcourseunscramblegame.CheckUiState

class VisibleEnabledButton : AppCompatButton, UpdateVisibleEnabledButton {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private lateinit var uiState: CheckUiState

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val savedState = VisibleEnabledButtonSavedState(it)
            savedState.save(uiState)
            return savedState
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as VisibleEnabledButtonSavedState
        super.onRestoreInstanceState(restoredState.superState)
        update(restoredState.restore())
    }

    override fun update(state: CheckUiState) {
        uiState = state
        state.update(this)
    }

    override fun update(visibility: Int, enabled: Boolean) {
        this.visibility = visibility
        isEnabled = enabled
    }
}