package com.lab.puretest.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lab.puretest.R
import com.lab.puretest.databinding.ActivityAutoSizeTextBinding
import java.util.*

class AutoSizeTextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAutoSizeTextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAutoSizeTextBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.text.viewTreeObserver.addOnGlobalLayoutListener {
            Log.e("AutoSizeTextActivity", "linecout: ${binding.text.lineCount}")
        }

    }
}