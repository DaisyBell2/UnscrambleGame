package com.daisybell.expertcourseunscramblegame

import android.content.SharedPreferences

/**
 * @author DaisyBell on 20.09.2024
 */
interface StringCache {

    fun save(value: String)

    fun read(): String

    class Base(
        private val sharedPreferences: SharedPreferences,
        private val key: String,
        private val default: String,
    ) : StringCache {

        override fun save(value: String) {
            sharedPreferences.edit().putString(key, value).apply()
        }

        override fun read(): String = sharedPreferences.getString(key, default) ?: default

    }
}