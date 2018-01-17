@file:JvmName("Nut")

package com.github.northburns.nut8

import java.io.File
import java.lang.ProcessBuilder.Redirect.*

fun main(vararg args: String) {
    println("Compressing and writing file.")
    inputFile("alastalon_salissa.txt")
            .let(::compress)
            .let { File("nut.txt").writeText(it) }
    println("Running the provided validator")
    ProcessBuilder("./downloads/alastalo_validator","nut.txt")
            .redirectOutput(INHERIT)
            .redirectError(INHERIT)
            .start()
            .waitFor()
}

fun inputFile(fileName: String): String =
        ClassLoader
                .getSystemResource(fileName)
                .readText()
