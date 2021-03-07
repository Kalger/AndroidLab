package com.lab.puretest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lab.puretest.R
import com.lab.puretest.databinding.ActivityViewBindTestBinding
import kotlinx.android.synthetic.main.activity_view_bind_test.*

class ViewBindTestActivity : AppCompatActivity() {

    private lateinit var binding :ActivityViewBindTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBindTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.hello.text = "Test"
//        binding.another.included.text = "lulala"
    }
}