package com.daisybell.expertcourseunscramblegame

import android.content.SharedPreferences

/**
 * @author DaisyBell on 20.09.2024
 */
interface IntCache {

    fun save(value: Int)

    fun read(): Int

    class Base(
        private val sharedPreferences: SharedPreferences,
        private val key: String,
        private val default: Int,
    ) : IntCache {

        override fun save(value: Int) {
            sharedPreferences.edit().putInt(key, value).apply()
        }

        override fun read(): Int = sharedPreferences.getInt(key, default)

    }
}