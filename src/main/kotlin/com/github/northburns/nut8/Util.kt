package com.github.northburns.nut8

/**
 * Like [forEach] but prints progress to standard out _every 5000 element.
 *
 * Only applicable to [Collection] since the size has to be known upfront.
 *
 */
inline fun <T> Collection<T>.forEachPrintProgress(action: (T) -> Unit) {
    this.forEachIndexed { index, element ->
        action(element)
        if (index % 5000 == 0)
            println(" %d %%".format(100 * (index + 1) / size))
    }
    println(" done.")
}
