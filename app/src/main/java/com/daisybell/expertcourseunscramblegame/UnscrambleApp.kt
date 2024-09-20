package com.daisybell.expertcourseunscramblegame

import android.app.Application
import android.content.Context

/**
 * @author DaisyBell on 05.09.2024
 */
class UnscrambleApp : Application() {

    lateinit var viewModel: GameViewModel

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences =
            getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
        viewModel = GameViewModel(
            GameRepository.Base(
                index = IntCache.Base(sharedPreferences, "indexKey", 0),
                userInput = StringCache.Base(sharedPreferences, "userInputKey", "")
            )
        )
    }
}