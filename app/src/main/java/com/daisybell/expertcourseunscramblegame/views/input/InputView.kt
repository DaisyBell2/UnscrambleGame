package com.daisybell.expertcourseunscramblegame.views.input

/**
 * @author DaisyBell on 30.09.2024
 */
import android.content.Context
import android.os.Parcelable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.daisybell.expertcourseunscramblegame.R
import com.daisybell.expertcourseunscramblegame.databinding.InputBinding

class InputView : FrameLayout, UpdateInput {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    private lateinit var uiState: InputUiState

    private val binding = InputBinding.inflate(LayoutInflater.from(context), this, true)

    override fun onSaveInstanceState(): Parcelable? {
        return super.onSaveInstanceState()?.let {
            val savedState = InputViewSavedState(it)
            savedState.save(uiState)
            return savedState
        }
    }

    override fun onRestoreInstanceState(state: Parcelable?) {
        val restoredState = state as InputViewSavedState
        super.onRestoreInstanceState(restoredState.superState)
        update(restoredState.restore())
    }

    override fun update(state: InputUiState) {
        uiState = state
        state.update(this)
    }

    override fun update(userInput: String) {
        binding.inputEditText.setText(userInput)
    }

    override fun update(errorVisible: Boolean, enabled: Boolean) = with(binding) {
        inputLayout.isErrorEnabled = errorVisible
        if (errorVisible)
            inputLayout.error = inputLayout.context.getString(R.string.incorrect_message)
        inputLayout.isEnabled = enabled
    }

    fun addTextChangedListener(textWatcher: TextWatcher) {
        binding.inputEditText.addTextChangedListener(textWatcher)
    }

    fun removeTextChangedListener(textWatcher: TextWatcher) {
        binding.inputEditText.addTextChangedListener(textWatcher)
    }

    fun text(): String = binding.inputEditText.text.toString()

}