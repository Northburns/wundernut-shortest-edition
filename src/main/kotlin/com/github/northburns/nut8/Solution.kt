package com.github.northburns.nut8

//
// The problem is a classic: Bin Packing problem
// https://en.wikipedia.org/wiki/Bin_packing_problem
//
// But there is a twist: each item beyond the first increases the spaced used by one (the space between words)
//
// Algorithm used here: Best Fit with sorted data
//  * The Best Fit algorithm places a new object in the fullest bin that still has room.
//  * ... better results are achieved by packing the largest objects first.
// Source: https://www2.cs.arizona.edu/icon/oddsends/bpack/bpack.htm
//

const val LINELENGTH = 80

fun compress(input: String) = Book()
        .also { book ->
            input
                    .split(Regex("\\s"))
                    .filterNot(String::isBlank)
                    .sortedByDescending(String::length)
                    .forEachPrintProgress(book::addWord)
        }.toString()

class Book {
    private val lines: MutableList<Line> = mutableListOf()
    private fun createLine() = Line().also { lines.add(it) }

    fun addWord(word: String) {
        (lines
                .filter { it.roomLeft >= word.length }
                .minBy { it.roomLeft }
                ?: createLine())
                .apply { append(word) }
    }

    override fun toString() = lines.joinToString(separator = "\n")
}

class Line {
    private val words = mutableListOf<String>()
    /**
     * This can only fit a word this long anymore.
     *
     * Negative values are defined to mean the same as zero = no room left.
     */
    var roomLeft = LINELENGTH
        private set

    fun append(word: String) {
        if (word.length > LINELENGTH) throw IllegalArgumentException("Too long: $word")
        words.add(word)
        roomLeft -= word.length + 1 // remember the separating space.
    }

    override fun toString() = words.joinToString(separator = " ")
}
