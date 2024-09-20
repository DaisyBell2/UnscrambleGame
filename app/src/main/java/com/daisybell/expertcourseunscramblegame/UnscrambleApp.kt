package com.daisybell.expertcourseunscramblegame

import android.app.Application

/**
 * @author DaisyBell on 05.09.2024
 */
class UnscrambleApp : Application() {

    lateinit var viewModel: GameViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = GameViewModel(GameRepository.Base())
    }
}