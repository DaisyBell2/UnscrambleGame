package com.daisybell.expertcourseunscramblegame.views.shuffledword

/**
 * @author DaisyBell on 30.09.2024
 */
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class ShuffleWordTextView : AppCompatTextView, UpdateText {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun getFreezesText(): Boolean = true

    override fun update(text: String) {
        this.text = text
    }
}