package com.lab.puretest

import android.content.Context

class TestConstructor  {

    private lateinit var  num: String

    constructor(str:String ){
//        num = 3
    }

    private fun testFun(){
         lateinit var num2: String

        num2 = "3"
        println(num2)
        print(num)
    }
}