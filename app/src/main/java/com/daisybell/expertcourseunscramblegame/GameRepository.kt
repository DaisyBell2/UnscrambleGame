package com.daisybell.expertcourseunscramblegame

interface GameRepository {

    fun shuffledWord(): String
    fun originalWord(): String
    fun check()
    fun saveUserInput(value: String)
    fun userInput(): String

    class Base(
        private val index: IntCache,
        private val userInput: StringCache,
        private val shuffleStrategy: ShuffleStrategy = ShuffleStrategy.Reverse(),
        private val originalList: List<String> = listOf(
            "Phone",
            "Computer",
            "Hero",
        )
    ) : GameRepository {

        private val shuffledList: List<String> =
            originalList.map { word -> shuffleStrategy.shuffle(word) }

        override fun shuffledWord(): String = shuffledList[index.read()]

        override fun originalWord(): String = originalList[index.read()]

        override fun check() {
            val value = index.read() + 1
            index.save(if (value == originalList.size) 0 else value)
            userInput.save("")
        }

        override fun saveUserInput(value: String) {
            userInput.save(value)
        }

        override fun userInput(): String = userInput.read()

    }
}

interface ShuffleStrategy {

    fun shuffle(source: String): String

    class Base : ShuffleStrategy {
        override fun shuffle(source: String): String {
            return source.toCharArray().apply { shuffle() }.concatToString()
        }
    }

    class Reverse : ShuffleStrategy {
        override fun shuffle(source: String): String = source.reversed()
    }

}
