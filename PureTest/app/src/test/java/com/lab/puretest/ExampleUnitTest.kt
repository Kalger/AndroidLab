package com.lab.puretest

import android.util.Log
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private lateinit var  num: String

    @Test
    fun addition_isCorrect() {
        val da = Data("str", 123)
        println(da.component2())
    }
}
