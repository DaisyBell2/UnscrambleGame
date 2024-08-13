package com.daisybell.expertcourseunscramblegame

interface GameRepository {

    fun shuffledWord(): String
    fun originalWord(): String
    fun check()
}
