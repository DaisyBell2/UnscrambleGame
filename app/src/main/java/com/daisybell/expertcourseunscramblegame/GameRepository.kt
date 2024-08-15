package com.daisybell.expertcourseunscramblegame

interface GameRepository {

    fun shuffledWord(): String
    fun originalWord(): String
    fun check()

    class Base(
        private val shuffleStrategy: ShuffleStrategy = ShuffleStrategy.Reverse(),
        private val originalList: List<String> = listOf(
            "Phone",
            "Computer",
            "Hero",
        )
    ) : GameRepository {

        private val shuffledList: List<String> =
            originalList.map { word -> shuffleStrategy.shuffle(word) }

        private var index = 0

        override fun shuffledWord(): String = shuffledList[index]

        override fun originalWord(): String = originalList[index]

        override fun check() {
            if (index + 1 == originalList.size)
                index = 0
            else
                index++
        }

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
