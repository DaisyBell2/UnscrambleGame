package com.daisybell.expertcourseunscramblegame.views.input.edittext

/**
 * @author DaisyBell on 30.09.2024
 */
import android.content.Context
import android.util.AttributeSet

class TextInputEditText : com.google.android.material.textfield.TextInputEditText,
    UpdateTextInputEditText {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun getFreezesText(): Boolean = true

    override fun update(userInput: String) {
        this.setText(userInput)
    }
}

interface UpdateTextInputEditText {

    fun update(userInput: String)
}
